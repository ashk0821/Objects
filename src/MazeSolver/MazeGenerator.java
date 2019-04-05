package MazeSolver;

import java.io.*;
import java.util.*;

public class MazeGenerator {
    public final int uncheckedWallCode = 0;
    public final int checkedWallCode = 1;
    public Node [][] maze;
    private int size;
    private int [] startingPoint;

    public MazeGenerator (int size, int[] startingPoint){
        this.startingPoint = startingPoint;
        this.size = size;

        maze = new Node[this.size][this.size];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = new Node(i, j, maze);
                maze[i][j].setWallCode(uncheckedWallCode);
            }
        }
    }

    public MazeGenerator (Node[][] maze){
        this.maze = maze;
        this.size = maze.length;
        startingPoint = startPoint();
    }

    public int[] startPoint(){
        int[] startingPoint = new int[2];

        for (int j = 0; j < maze[0].length; j++) {
            if (!maze[0][j].top_wall) {
                startingPoint[0] = maze[0][j].horizontalNode;
                startingPoint[1] = maze[0][j].verticalNode;
            }
        }

        return startingPoint;
    }

    public boolean generate() throws IOException{
        maze[startingPoint[0]][startingPoint[1]].setWallCode(checkedWallCode);
        maze[startingPoint[0]][startingPoint[1]].top_wall = false;

        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j].getWallCode() == checkedWallCode) {
                    ArrayList<Node> temp = maze[i][j].uncheckedNodes();
                    for (Node node : temp) {
                        list.add(node);
                    }
                }
            }
        }

        if (list.size() == 0) {
            Random r = new Random();
            int rand_int = r.nextInt(size);
            maze[maze.length - 1][rand_int].bot_wall = false;
            write_to_file();
            return true;
        }

        Random rand = new Random();
        Node current_node = list.get(rand.nextInt(list.size()));
        list = current_node.checkedNodes();
        Random rand2 = new Random();
        Node connection_node = list.get(rand2.nextInt(list.size()));

        if (connection_node.verticalNode - 1 == current_node.verticalNode)
            current_node.open_right();
        else if (connection_node.verticalNode + 1 == current_node.verticalNode)
            current_node.open_left();
        else if (connection_node.horizontalNode - 1 == current_node.horizontalNode)
            current_node.open_bot();
        else if (connection_node.horizontalNode + 1 == current_node.horizontalNode)
            current_node.open_top();

        current_node.setWallCode(checkedWallCode);
        return false;
    }

    public void write_to_file() throws IOException {
        String write_to_maze = "";
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j].top_wall) {
                    write_to_maze += ("---");
                } else
                    write_to_maze += ("   ");
            }
            write_to_maze += "\n";

            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j].left_wall) {
                    if (j == maze[i].length - 1)
                        write_to_maze += "|"+maze[i][j].getWallCode()+ "|";
                    else
                        write_to_maze += ("|"+maze[i][j].getWallCode()+ " ");
                }
                else {
                    if (j == maze[i].length - 1)
                        write_to_maze += " "+maze[i][j].getWallCode()+ "|";
                    else
                        write_to_maze += (" "+maze[i][j].getWallCode()+ " ");
                }
            }
            write_to_maze += "\n";

        }

        for (int j = 0; j < maze[maze.length - 1].length; j++) {

            if (maze[maze.length - 1][j].bot_wall)
                write_to_maze += "---";
            else
                write_to_maze += "   ";
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("Maze.txt"));
        writer.write(write_to_maze);

        writer.close();
    }

    public void write_to_array_file(String file_name){
        try {
            FileOutputStream fos = new FileOutputStream(file_name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(maze);
            oos.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public void write_to_file(Node[][] temp_maze) throws IOException {
        String write_to_maze = "";
        for (int i = 0; i < temp_maze.length; i++) {
            for (int j = 0; j < temp_maze[i].length; j++) {
                if (temp_maze[i][j].top_wall) {
                    write_to_maze += ("---");
                } else
                    write_to_maze += ("   ");
            }
            write_to_maze += "\n";

            for (int j = 0; j < temp_maze[i].length; j++) {
                if (temp_maze[i][j].left_wall) {
                    if (j == temp_maze[i].length - 1)
                        write_to_maze += "|"+maze[i][j].getWallCode()+ "|";
                    else
                        write_to_maze += ("|"+maze[i][j].getWallCode()+ " ");
                } else {
                    if (j == temp_maze[i].length - 1)
                        write_to_maze += " "+maze[i][j].getWallCode()+ "|";
                    else
                        write_to_maze += (" "+maze[i][j].getWallCode()+ " ");
                }
            }
            write_to_maze += "\n";

        }

        for (int j = 0; j < temp_maze[temp_maze.length - 1].length; j++) {

            if (temp_maze[temp_maze.length - 1][j].bot_wall)
                write_to_maze += "---";
            else
                write_to_maze += "   ";
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("Maze.txt"));
        writer.write(write_to_maze);

        writer.close();
    }

    public int[] end_point(){

        int[] end = new int[2];
        for (int i = 0; i < maze.length; i++) {
            if(!(maze[maze.length-1][i].bot_wall)){
                end[0] = i;
                end[1] = maze.length-1;
            }
        }

        return end;
    }




}

