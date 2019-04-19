package Maze;

import javax.swing.*;
import java.awt.*;

public class MazeAnimator extends JPanel implements Runnable{
    MazeSolver solver = new MazeSolver();
    private Color[] colorList;
    private int totalWidth, totalHeight, leftWall, topWall;

    public MazeAnimator() {
        /* https://docs.oracle.com/javase/7/docs/api/javax/swing/JPanel.html */
        colorList = new Color[] {Color.BLACK, Color.BLACK, Color.BLUE, Color.WHITE, Color.WHITE};

        setBackground(colorList[MazeGenerator.backgroundCode]);

        setPreferredSize(new Dimension(MazeGenerator.cellSize * MazeGenerator.columns,
                MazeGenerator.cellSize * MazeGenerator.rows));

        /* https://www.geeksforgeeks.org/java-lang-thread-class-java/ */
        new Thread(this).start();
    }

    /* Sets the size of the width and height needed for drawing before animating/generating the maze */
    public void setSize() {
        int border = 10;
        if (getWidth() != MazeGenerator.width || getHeight() != MazeGenerator.height) {
            MazeGenerator.width = getWidth();
            MazeGenerator.height = getHeight();

            int width = (MazeGenerator.width - 2 * border) / MazeGenerator.columns;
            int height = (MazeGenerator.height - 2 * border) / MazeGenerator.rows;

            leftWall = (MazeGenerator.width - width * MazeGenerator.columns) / 2;
            topWall = (MazeGenerator.height - height * MazeGenerator.rows) / 2;

            totalWidth = width * MazeGenerator.columns;
            totalHeight = height * MazeGenerator.rows;
        }
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        setSize();
        animateMaze(graphics);
    }

    public void animateMaze(Graphics graphics) {
        if (MazeGenerator.mazeExists) {
            int width = totalWidth / MazeGenerator.columns;
            int height = totalHeight / MazeGenerator.rows;

            for (int j = 0; j < MazeGenerator.columns; j++){
                for (int i = 0; i < MazeGenerator.rows; i++) {
                    if (MazeGenerator.maze[i][j] < 0) {
                        graphics.setColor(colorList[MazeGenerator.emptyCode]);
                    }
                    else {
                        graphics.setColor(colorList[MazeGenerator.maze[i][j]]);
                    }
                    graphics.fillRect( (j * width) + leftWall, (i * height) +
                            topWall, width, height);
                }
            }

        }
    }

    /* While-loop to repeatedly generate, solve, and animate a new maze until the user makes it force-quit */
    public void run() {
        int sleepTime = 2000;
        while (true) {
            MazeGenerator.generateMaze();
            solver.solveMaze(1,1);

            synchronized(this) {
                try {
                    wait(sleepTime);
                }
                catch (InterruptedException e) {

                }
            }

            MazeGenerator.mazeExists = false;
            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Maze Solver");
        window.setContentPane(new MazeAnimator());
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
