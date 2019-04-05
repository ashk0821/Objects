package MazeSolver;

import java.util.ArrayList;

public class x {
    /*
    public Node[][] maze;
    public int x, y;
    public boolean topWall = true, bottomWall = true, leftWall = true, rightWall = true;
    private int wallCode = 0;

    public x(int x, int y, Node[][] maze){
        this.x = x;
        this.y = y;
        this.maze = maze;
    }

    public void setWallCode(int code){
        wallCode = code;
    }
    public int getWallCode(){
        return wallCode;
    }

    public ArrayList<Node> path(){
        ArrayList<Node> temporaryMaze = new ArrayList<Node>();
        if ((topWall == false) && (x != 0)){
            if (maze[x - 1][y].wallCode == 1){
                temporaryMaze.add(maze[x - 1][y]);
            }
        }
        if ((bottomWall == false) && (x != maze.length - 1)){
            if (maze[x + 1][y].wallCode == 1){
                temporaryMaze.add(maze[x + 1][y]);
            }
        }
        if ((rightWall == false) && (y != maze[0].length - 1)){
            if (maze[x][y + 1].wallCode == 1){
                temporaryMaze.add(maze[x][y + 1]);
            }
        }
        if ((leftWall == false) && (y != 0)){
            if (maze[x][y - 1].wallCode == 1){
                temporaryMaze.add(maze[x][y - 1]);
            }
        }
        return temporaryMaze;
    }

    public Node backTrace (){
        if ((topWall == false) && (x != 0)){
            if (maze[x - 1][y].wallCode == 2){
                return (maze[x - 1][y]);
            }
        }
        if ((bottomWall == false) && (x != maze.length - 1)){
            if (maze[x + 1][y].wallCode == 2){
                return (maze[x + 1][y]);
            }
        }
        if ((rightWall == false) && (y != maze[0].length - 1)){
            if (maze[x][y + 1].wallCode == 2){
                return (maze[x][y + 1]);
            }
        }
        if ((leftWall == false) && (y != 0)){
            if (maze[x][y - 1].wallCode == 2){
                return (maze[x][y - 1]);
            }
        }
        return null;
    }

    public Node nextNode(){
        if ((topWall == false) && (x != 0)){
            if (maze[x - 1][y].wallCode == 2){
                return (maze[x - 1][y]);
            }
        }
        if ((bottomWall == false) && (x != maze.length - 1)){
            if (maze[x + 1][y].wallCode == 2){
                return (maze[x + 1][y]);
            }
        }
        if ((rightWall == false) && (y != maze[0].length - 1)){
            if (maze[x][y + 1].wallCode == 2){
                return (maze[x][y + 1]);
            }
        }
        if ((leftWall == false) && (y != 0)){
            if (maze[x][y - 1].wallCode == 2){
                return (maze[x][y - 1]);
            }
        }
        return null;
    }

    public void openTopWall(){
        topWall = false;
        maze[x - 1][y].bottomWall = false;
    }
    public void openBottomWall(){
        bottomWall = false;
        maze[x+ 1][y].topWall = false;
    }
    public void openLeftWall(){
        topWall = false;
        maze[x][y - 1].rightWall = false;
    }
    public void openRightWall(){
        topWall = false;
        maze[x][y + 1].leftWall = false;
    }

    public ArrayList<Node> uncheckedNeighbors (){
        ArrayList<Node> neighborsList = new ArrayList<>();

        if (maze[x + 1][y].wallCode == 0){
            neighborsList.add(maze[x + 1][y]);
        }
        if (maze[x - 1][y].wallCode == 0){
            neighborsList.add(maze[x - 1][y]);
        }
        if (maze[x][y + 1].wallCode == 0){
            neighborsList.add(maze[x][y + 1]);
        }
        if (maze[x][y + 1].wallCode == 0){
            neighborsList.add(maze[x][y + 1]);
        }
        return neighborsList;
    }

    public ArrayList<Node> checkedNeighbors (){
        ArrayList<Node> neighborsList = new ArrayList<>();

        if (maze[x + 1][y].wallCode == 1){
            neighborsList.add(maze[x + 1][y]);
        }
        if (maze[x - 1][y].wallCode == 1){
            neighborsList.add(maze[x - 1][y]);
        }
        if (maze[x][y + 1].wallCode == 1){
            neighborsList.add(maze[x][y + 1]);
        }
        if (maze[x][y + 1].wallCode == 1){
            neighborsList.add(maze[x][y + 1]);
        }
        return neighborsList;
    }
    */
}
