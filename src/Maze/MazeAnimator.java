package Maze;

import javax.swing.*;
import java.awt.*;

public class MazeAnimator extends JPanel implements Runnable {
    MazeSolver solver = new MazeSolver();


    public static void main(String[] args) {
        JFrame window = new JFrame("Maze Solver");
        window.setContentPane(new MazeAnimator());
        window.pack();
        window.setLocation(120, 80);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public MazeAnimator() {
        MazeGenerator.color = new Color[] {
                new Color(200,0,0),
                new Color(200,0,0),
                new Color(128,128,255),
                Color.WHITE,
                new Color(200,200,200)
        };
        setBackground(MazeGenerator.color[MazeGenerator.backgroundCode]);
        setPreferredSize(new Dimension(MazeGenerator.blockSize* MazeGenerator.columns, MazeGenerator.blockSize*MazeGenerator.rows));
        new Thread(this).start();
    }

    void checkSize() {
        // Called before drawing the MazeGenerator, to set parameters used for drawing.
        if (getWidth() != MazeGenerator.width || getHeight() != MazeGenerator.height) {
            MazeGenerator.width  = getWidth();
            MazeGenerator.height = getHeight();
            int w = (MazeGenerator.width - 2* MazeGenerator.border) / MazeGenerator.columns;
            int h = (MazeGenerator.height - 2* MazeGenerator.border) / MazeGenerator.rows;
            MazeGenerator.left = (MazeGenerator.width - w* MazeGenerator.columns) / 2;
            MazeGenerator.top = (MazeGenerator.height - h* MazeGenerator.rows) / 2;
            MazeGenerator.totalWidth = w*MazeGenerator.columns;
            MazeGenerator.totalHeight = h*MazeGenerator.rows;
        }
    }

    synchronized protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        checkSize();
        redrawMaze(g);
    }

    void redrawMaze(Graphics g) {
        // draws the entire MazeGenerator
        if (MazeGenerator.mazeExists) {
            int w = MazeGenerator.totalWidth / MazeGenerator.columns;  // width of each cell
            int h = MazeGenerator.totalHeight / MazeGenerator.rows;    // height of each cell
            for (int j=0; j< MazeGenerator.columns; j++)
                for (int i=0; i<MazeGenerator.rows; i++) {
                    if (MazeGenerator.maze[i][j] < 0)
                        g.setColor(MazeGenerator.color[MazeGenerator.emptyCode]);
                    else
                        g.setColor(MazeGenerator.color[MazeGenerator.maze[i][j]]);
                    g.fillRect( (j * w) + MazeGenerator.left, (i * h) + MazeGenerator.top, w, h );
                }
        }
    }

    public void run() {
        // run method for thread repeatedly makes a MazeGenerator and then solves it
        try { Thread.sleep(1000); } // wait a bit before starting
        catch (InterruptedException e) { }
        while (true) {
            MazeGenerator.makeMaze();
            solver.solveMaze(1,1);
            synchronized(this) {
                try { wait(MazeGenerator.sleepTime); }
                catch (InterruptedException e) { }
            }
            MazeGenerator.mazeExists = false;
            repaint();
        }
    }
}
