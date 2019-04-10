package Maze;

public class MazeGenerator {
    public int[][] maze;   // Description of state of maze.  The value of maze[i][j]
    // is one of the constants wallCode, pathcode, emptyCode,
    // or visitedCode.  (Value can also be negative, temporarily,
    // inside createMaze().)
    //    A maze is made up of walls and corridors.  maze[i][j]
    // is either part of a wall or part of a corridor.  A cell
    // cell that is part of a corridor is represented by pathCode
    // if it is part of the current path through the maze, by
    // visitedCode if it has already been explored without finding
    // a solution, and by emptyCode if it has not yet been explored.

    public final static int backgroundCode = 0;
    public final static int wallCode = 1;
    public final static int pathCode = 2;
    public final static int emptyCode = 3;
    public final static int visitedCode = 4;
    int rows = 31;          // number of rows of cells in maze, including a wall around edges
    int columns = 41;       // number of columns of cells in maze, including a wall around edges
    int border = 0;         // minimum number of pixels between maze and edge of panel
    int sleepTime = 5000;   // wait time after solving one maze before making another
    int speedSleep = 30;    // short delay between steps in making and solving maze
    int blockSize = 12;     // size of each cell

    int width = -1;   // width of panel, to be set by checkSize()
    int height = -1;  // height of panel, to be set by checkSize()

    int totalWidth;   // width of panel, minus border area (set in checkSize())
    int totalHeight;  // height of panel, minus border area (set in checkSize())
    int left;         // left edge of maze, allowing for border (set in checkSize())
    int top;          // top edge of maze, allowing for border (set in checkSize())

    boolean mazeExists = false; // set to true when maze[][] is valid; used in
    // redrawMaze(); set to true in createMaze(), and
    // reset to false in run()

    public void checkSize() {
        // Called before drawing the maze, to set parameters used for drawing.
        if (getWidth() != width || getHeight() != height) {
            width  = getWidth();
            height = getHeight();
            int w = (width - 2*border) / columns;
            int h = (height - 2*border) / rows;
            left = (width - w*columns) / 2;
            top = (height - h*rows) / 2;
            totalWidth = w*columns;
            totalHeight = h*rows;
        }
    }

    public int getWidth() {
        return width;
    }
    public int getHeight(){
        return height;
    }

    public void makeMaze() {
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
        // Tear down a wall, unless doing so will form a loop.  Tearing down a wall
        // joins two "rooms" into one "room".  (Rooms begin to look like corridors
        // as they grow.)  When a wall is torn down, the room codes on one side are
        // converted to match those on the other side, so all the cells in a room
        // have the same code.   Note that if the room codes on both sides of a
        // wall already have the same code, then tearing down that wall would
        // create a loop, so the wall is left in place.
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
