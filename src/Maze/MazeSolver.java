package Maze;

import java.awt.*;
import javax.swing.*;

public class MazeSolver extends JPanel{
    boolean solveMaze(int row, int col) {
        // Try to solve the maze by continuing current path from position
        // (row,col).  Return true if a solution is found.  The maze is
        // considered to be solved if the path reaches the lower right cell.
        if (MazeGenerator.maze[row][col] == MazeGenerator.emptyCode) {
            MazeGenerator.maze[row][col] = MazeGenerator.pathCode;      // add this cell to the path
            repaint();
            if (row == MazeGenerator.rows-2 && col == MazeGenerator.columns-2)
                return true;  // path has reached goal
            try { Thread.sleep(MazeGenerator.speedSleep); }
            catch (InterruptedException e) { }
            if ( solveMaze(row-1,col)  ||     // try to solve maze by extending path
                    solveMaze(row,col-1)  ||     //    in each possible direction
                    solveMaze(row+1,col)  ||
                    solveMaze(row,col+1) )
                return true;
            // maze can't be solved from this cell, so backtrack out of the cell
            MazeGenerator.maze[row][col] = MazeGenerator.visitedCode;   // mark cell as having been visited
            repaint();
            synchronized(this) {
                try { wait(MazeGenerator.speedSleep); }
                catch (InterruptedException e) { }
            }
        }
        return false;
    }


}
