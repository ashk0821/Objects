package MazeSolver;

import java.util.ArrayList;
import java.util.Random;

public class MazeSolver {
    private boolean isFinished = false;
    public final int checked_value = 2;
    public final int wrong_way_value = 3;

    public void solve(Node[][] maze) {
        ArrayList<Node> paths = new ArrayList<Node>();
        MazeGenerator Maze = new MazeGenerator(maze);
        int[] start = Maze.startPoint();
        int[] end = Maze.end_point();

        paths = maze[start[0]][start[1]].path_options();
        Random rand_int = new Random();
        Node next = paths.get(rand_int.nextInt(paths.size()));
        maze[start[0]][start[1]].setWallCode(checked_value);
        maze[next.horizontalNode][next.verticalNode].setWallCode(checked_value);

        while(!isFinished) {
            paths = next.path_options();
            if(next.verticalNode == end[0]&& next.horizontalNode == end[1]) {
                isFinished = true;
                next.setWallCode(checked_value);
            }
            else if(paths.size() == 0) {
                next.setWallCode(wrong_way_value);
                next = next.back_tracing();
            }
            else {
                maze[next.horizontalNode][next.verticalNode].setWallCode(checked_value);
                rand_int = new Random();
                next = paths.get(rand_int.nextInt(paths.size()));
            }
        }

        MazeAnimator.solver_called = true;
        try {
            Maze.write_to_file();
        }
        catch (Exception ex){
            System.out.println("Error");
        }
    }

}
