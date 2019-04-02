package MazeSolver;

public class MazeSolver extends MazeGenerator {
    public boolean solveMaze(int row, int column){
        if (maze[row][column] == emptyInt){
            maze[row][column] = pathInt;
            if ((row == rows - 2) && (column == columns - 2)){
                return true;
            }
            if (solveMaze(row - 1, column) || solveMaze(row, column- 1) || solveMaze(row + 1, column)
                    || solveMaze(row, column + 1)){
                return true;
            }
            maze[row][column] = visitedInt;
        }
        return false;

    }

}
