package Maze;

import java.awt.*;
import javax.swing.*;

public class MazeSolver {

    public boolean solveMaze(int row, int col) {
        MazeGenerator mazeGenerator = new MazeGenerator();
        // Try to solve the maze by continuing current path from position
        // (row,col).  Return true if a solution is found.  The maze is
        // considered to be solved if the path reaches the lower right cell.
        if (mazeGenerator.maze[row][col] == MazeGenerator.emptyCode) {
            mazeGenerator.maze[row][col] = MazeGenerator.pathCode;      // add this cell to the path
           // repaint();
            if (row == mazeGenerator.rows-2 && col == mazeGenerator.columns-2)
                return true;  // path has reached goal
            try { Thread.sleep(mazeGenerator.speedSleep); }
            catch (InterruptedException e) { }
            if ( solveMaze(row-1,col)  ||     // try to solve maze by extending path
                    solveMaze(row,col-1)  ||     //    in each possible direction
                    solveMaze(row+1,col)  ||
                    solveMaze(row,col+1) )
                return true;
            // maze can't be solved from this cell, so backtrack out of the cell
            mazeGenerator.maze[row][col] = MazeGenerator.visitedCode;   // mark cell as having been visited
           // repaint();
            synchronized(this) {
                try { wait(mazeGenerator.speedSleep); }
                catch (InterruptedException e) { }
            }
        }
        return false;
    }


}
