package MazeSolver;

import java.util.ArrayList;
import java.util.Random;

public class MazeSolver {
    private boolean solved = false;
    public void solve(Cell[][] maze) {
        int cellCheckedCode = 2;
        int deadEndCode = 3;

        ArrayList<Cell> paths;
        MazeGenerator Maze = new MazeGenerator(maze);
        int[] start = Maze.startPoint();
        int[] end = Maze.end_point();

        paths = maze[start[0]][start[1]].pathInstructions();
        Random rand_int = new Random();
        Cell next = paths.get(rand_int.nextInt(paths.size()));
        maze[start[0]][start[1]].setWallCode(cellCheckedCode);
        maze[next.horizontalNode][next.verticalNode].setWallCode(cellCheckedCode);

        while(!solved) {
            paths = next.pathInstructions();
            if(next.verticalNode == end[0]&& next.horizontalNode == end[1]) {
                solved = true;
                next.setWallCode(cellCheckedCode);
            }
            else if(paths.size() == 0) {
                next.setWallCode(deadEndCode);
                next = next.back_tracing();
            }
            else {
                maze[next.horizontalNode][next.verticalNode].setWallCode(cellCheckedCode);
                rand_int = new Random();
                next = paths.get(rand_int.nextInt(paths.size()));
            }
        }

        MazeAnimator.solver_called = true;
        try {
            Maze.writeMazeASCII();
        }
        catch (Exception ex){
            System.out.println("Error");
        }
    }

}
