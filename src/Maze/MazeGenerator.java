package Maze;

import javax.swing.*;
import java.awt.*;

public class MazeGenerator extends JPanel{
    public static int[][] maze;

    public static int[][] getMaze() {
        return maze;
    }

    public static void setMaze(int[][] maze) {
        MazeGenerator.maze = maze;
    }

    public final static int backgroundCode = 0;
    public final static int wallCode = 1;
    public final static int pathCode = 2;
    public final static int emptyCode = 3;
    public final static int visitedCode = 4;


    public static Color[] color;
    public static int rows = 51;
    public static int columns = 51;
    public static int border = 10;
    public static int sleepTime = 2000;
    public static int speedSleep = 20;
    public static int blockSize = 15;

    public static int width, height;

    public static int totalWidth;
    public static int totalHeight;
    public static int left;
    public static int top;

    public static boolean mazeExists = false; // set to true when maze[][] is valid; used in
    // redrawMaze(); set to true in createMaze(), and
    // reset to false in run()



    public int getWidth() {
        return width;
    }
    public int getHeight(){
        return height;
    }

    public static void makeMaze() {
        // Create a random maze.  The strategy is to start with
        // a grid of disconnected "rooms" separated by walls.
        // then look at each of the separating walls, in a random
        // order.  If tearing down a wall would not create a loop
        // in the maze, then tear it down.  Otherwise, leave it in place.
        if (maze == null)
            maze = new int[rows][columns];
        int i,j;
        int emptyCt = 0; // number of rooms
        int wallCt = 0;  // number of walls
        int[] wallrow = new int[(rows*columns)/2];  // position of walls between rooms
        int[] wallcol = new int[(rows*columns)/2];
        for (i = 0; i<rows; i++)  // start with everything being a wall
            for (j = 0; j < columns; j++)
                maze[i][j] = wallCode;
        for (i = 1; i<rows-1; i += 2)  // make a grid of empty rooms
            for (j = 1; j<columns-1; j += 2) {
                emptyCt++;
                maze[i][j] = -emptyCt;  // each room is represented by a different negative number
                if (i < rows-2) {  // record info about wall below this room
                    wallrow[wallCt] = i+1;
                    wallcol[wallCt] = j;
                    wallCt++;
                }
                if (j < columns-2) {  // record info about wall to right of this room
                    wallrow[wallCt] = i;
                    wallcol[wallCt] = j+1;
                    wallCt++;
                }
            }
        mazeExists = true;

        int r;
        for (i=wallCt-1; i>0; i--) {
            r = (int)(Math.random() * i);  // choose a wall randomly and maybe tear it down
            //tearDown(wallrow[r],wallcol[r]);
            wallrow[r] = wallrow[i];
            wallcol[r] = wallcol[i];
        }
        for (i=1; i<rows-1; i++)  // replace negative values in maze[][] with emptyCode
            for (j=1; j<columns-1; j++)
                if (maze[i][j] < 0)
                    maze[i][j] = emptyCode;
    }

    public void tearDown(int row, int col) {

        if (row % 2 == 1 && maze[row][col-1] != maze[row][col+1]) {
            // row is odd; wall separates rooms horizontally
            fill(row, col-1, maze[row][col-1], maze[row][col+1]);
            maze[row][col] = maze[row][col+1];

        }
        else if (row % 2 == 0 && maze[row-1][col] != maze[row+1][col]) {
            // row is even; wall separates rooms vertically
            fill(row-1, col, maze[row-1][col], maze[row+1][col]);
            maze[row][col] = maze[row+1][col];

        }
    }

    public void fill(int row, int col, int replace, int replaceWith) {
        // called by tearDown() to change "room codes".
        if (maze[row][col] == replace) {
            maze[row][col] = replaceWith;
            fill(row+1,col,replace,replaceWith);
            fill(row-1,col,replace,replaceWith);
            fill(row,col+1,replace,replaceWith);
            fill(row,col-1,replace,replaceWith);
        }
    }

}
