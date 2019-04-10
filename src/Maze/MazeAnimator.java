package Maze;

import javax.swing.*;
import java.awt.*;

public class MazeAnimator extends JPanel implements Runnable {

    // a main routine makes it possible to run this class as a program
    public static void main(String[] args) {
        JFrame window = new JFrame("Maze Solver");
        window.setContentPane(new MazeAnimator());
        window.pack();
        window.setLocation(120, 80);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    Color[] color;

    MazeGenerator mazeGenerator = new MazeGenerator();
    MazeSolver mazeSolver = new MazeSolver();

    public MazeAnimator() {
        color = new Color[] {
                new Color(200,0,0),
                new Color(200,0,0),
                new Color(128,128,255),
                Color.WHITE,
                new Color(200,200,200)
        };
        setBackground(color[MazeGenerator.backgroundCode]);
        setPreferredSize(new Dimension(mazeGenerator.blockSize* mazeGenerator.columns, mazeGenerator.blockSize* mazeGenerator.rows));
        new Thread(this).start();
    }

    synchronized protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        mazeGenerator.checkSize();
        redrawMaze(g);
    }

    void redrawMaze(Graphics g) {
        // draws the entire maze
        if (mazeGenerator.mazeExists) {
            int w = mazeGenerator.totalWidth / mazeGenerator.columns;  // width of each cell
            int h = mazeGenerator.totalHeight / mazeGenerator.rows;    // height of each cell
            for (int j=0; j< mazeGenerator.columns; j++)
                for (int i=0; i<mazeGenerator.rows; i++) {
                    if (mazeGenerator.maze[i][j] < 0)
                        g.setColor(color[MazeGenerator.emptyCode]);
                    else
                        g.setColor(color[mazeGenerator.maze[i][j]]);
                    g.fillRect( (j * w) + mazeGenerator.left, (i * h) + mazeGenerator.top, w, h );
                }
        }
    }

    public void run() {
        // run method for thread repeatedly makes a maze and then solves it
        try { Thread.sleep(1000); } // wait a bit before starting
        catch (InterruptedException e) { }
        while (true) {
            mazeGenerator.makeMaze();
            mazeSolver.solveMaze(1,1);
            synchronized(this) {
                try { wait(mazeGenerator.sleepTime); }
                catch (InterruptedException e) { }
            }
            mazeGenerator.mazeExists = false;
            repaint();
        }
    }
}
