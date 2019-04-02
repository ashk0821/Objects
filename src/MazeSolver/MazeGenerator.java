package MazeSolver;

import java.awt.*;

public class MazeGenerator {
    public int maze [][];
    int rows = 41;
    int columns = 41;
    boolean mazeExists = false;

    public static final int backgroundInt = 0;
    public static final int wallInt = 1;
    public static final int pathInt = 2;
    public static final int emptyInt = 3;
    public static final int visitedInt = 2;

    public void generateMaze() {
        if (maze == null) {
            maze = new int[rows][columns];
        }

        /* Number of rooms and walls defaulted to 0 */
        int emptyRoomCount = 0, wallCount = 0;

        /* Position of the walls between the rooms */
        int [] wallRows = new int [(rows * columns) / 2], wallColumns = new int [(rows * columns) / 2];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns ; j++) {
                maze[i][j] = wallInt;
            }
        }

        for (int i = 1; i < rows - 1; i += 2) {
            for (int j = 1; j < columns -1 ; j++) {
                emptyRoomCount++;
                maze[i][j] = -(emptyRoomCount);

                if (i < rows - 2){
                    wallRows[wallCount] = i + 1;
                    wallColumns[wallCount] = j;
                    wallCount++;
                }
                if (j < columns - 2){
                    wallRows[wallCount] = i;
                    wallColumns[wallCount] = j + 1;
                    wallCount++;
                }
            }
        }

        mazeExists = true;
        int randomWall = 0;
        for (int i = wallCount - 1; i > 0; i--) {
            /* https://dzone.com/articles/random-number-generation-in-java */
            randomWall = (int) (Math.random() * i);
            removeWall(wallRows[randomWall], wallColumns[randomWall]);
            wallRows[randomWall] = wallRows[i];
            wallColumns[randomWall] = wallColumns[i];
        }

        for (int i = 1; i < rows - 1 ; i++) {
            for (int j = 1; j < columns - 1; j++) {
                if (maze[i][j] < 0){
                    maze[i][j] = emptyInt;
                }
            }
        }

    }

    public void removeWall (int row, int column){
        if (row % 2 == 1 && maze[row][column - 1] != maze[row][column + 1]){
            maze[row][column] = maze[row][column];
        }
        else if (row % 2 == 0 && maze[row - 1][column] != maze[row + 1][column]){
            maze[row][column] = maze[row + 1][column];
        }
    }

}
