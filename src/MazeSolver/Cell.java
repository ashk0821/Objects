package MazeSolver;


import java.util.ArrayList;

public class Cell {
    public Cell[][] nodes;
    public int verticalNode, horizontalNode;
    public boolean topWall = true;
    public boolean bottomWall = true;
    public boolean rightWall = true;
    public boolean leftWall = true;
    private int wallCode= 0;

    public Cell(int horizontalNode, int verticalNode, Cell[][] nodes) {
        this.verticalNode = verticalNode;
        this.horizontalNode = horizontalNode;
        this.nodes = nodes;
    }

    public void setWallCode(int code){
        this.wallCode = code;
    }

    public ArrayList<Cell> pathInstructions(){
        ArrayList<Cell> temp = new ArrayList<>();
        if(!topWall && horizontalNode!=0){
            if(nodes[horizontalNode-1][verticalNode].wallCode == 1)
                temp.add(nodes[horizontalNode-1][verticalNode]);
        }
        if(!bottomWall && horizontalNode!=nodes.length-1){
            if(nodes[horizontalNode+1][verticalNode].wallCode == 1)
                temp.add(nodes[horizontalNode+1][verticalNode]);
        }
        if(!rightWall && verticalNode!=nodes[0].length-1){
            if(nodes[horizontalNode][verticalNode+1].wallCode == 1)
                temp.add(nodes[horizontalNode][verticalNode+1]);
        }
        if(!leftWall && verticalNode!=0){
            if(nodes[horizontalNode][verticalNode-1].wallCode == 1)
                temp.add(nodes[horizontalNode][verticalNode-1]);
        }
        return temp;
    }

    public int getWallCode(){
        return wallCode;
    }

    public Cell back_tracing(){
        if(!topWall && horizontalNode!=0){
            if(nodes[horizontalNode-1][verticalNode].wallCode== 2)
                return (nodes[horizontalNode-1][verticalNode]);
        }
        if(!bottomWall){
            if(nodes[horizontalNode+1][verticalNode].wallCode == 2)
                return (nodes[horizontalNode+1][verticalNode]);
        }
        if(!rightWall){
            if(nodes[horizontalNode][verticalNode+1].wallCode == 2)
                return (nodes[horizontalNode][verticalNode+1]);
        }
        if(!leftWall){
            if(nodes[horizontalNode][verticalNode-1].wallCode == 2)
                return (nodes[horizontalNode][verticalNode-1]);
        }
        return null;
    }

    public Cell next_node(){
        try {
            if (!topWall && horizontalNode != 0) {
                if (nodes[horizontalNode - 1][verticalNode].wallCode == 2)
                    return (nodes[horizontalNode - 1][verticalNode]);
            }
            if (!bottomWall && horizontalNode != nodes.length - 1) {
                if (nodes[horizontalNode + 1][verticalNode].wallCode == 2)
                    return (nodes[horizontalNode + 1][verticalNode]);
            }
            if (!rightWall) {
                if (nodes[horizontalNode][verticalNode + 1].wallCode == 2)
                    return (nodes[horizontalNode][verticalNode + 1]);
            }
            if (!leftWall) {
                if (nodes[horizontalNode][verticalNode - 1].wallCode == 2)
                    return (nodes[horizontalNode][verticalNode - 1]);
            }
        }
        catch (Exception ex){
        }
        return null;
    }

    public void open_top() {
        topWall = false;

        nodes[horizontalNode - 1][verticalNode].bottomWall = false;

    }

    public void open_bot() {
        bottomWall = false;
        nodes[horizontalNode + 1][verticalNode].topWall = false;

    }

    public void open_left() {
        leftWall = false;
        nodes[horizontalNode][verticalNode - 1].rightWall = false;

    }

    public void open_right() {
        rightWall = false;

        nodes[horizontalNode][verticalNode + 1].leftWall = false;

    }

    public ArrayList<Cell> uncheckedNodes() {
        ArrayList<Cell> neighbors = new ArrayList<>();
        try {
            if (nodes[horizontalNode + 1][verticalNode].wallCode == 0)
                neighbors.add(nodes[horizontalNode + 1][verticalNode]);
            if (nodes[horizontalNode - 1][verticalNode].wallCode == 0)
                neighbors.add(nodes[horizontalNode - 1][verticalNode]);
            if (nodes[horizontalNode][verticalNode + 1].wallCode == 0)
                neighbors.add(nodes[horizontalNode][verticalNode + 1]);

            if (nodes[horizontalNode][verticalNode - 1].wallCode == 0)
                neighbors.add(nodes[horizontalNode][verticalNode - 1]);
        } catch (Exception ex) {

        }
        return neighbors;
    }

    public ArrayList<Cell> checkedNodes() {
        ArrayList<Cell> neighbors = new ArrayList<>();
        try {
            if (nodes[horizontalNode + 1][verticalNode].wallCode == 1)
                neighbors.add(nodes[horizontalNode + 1][verticalNode]);
        } catch (Exception ex) {
        }
        try {
            if (nodes[horizontalNode - 1][verticalNode].wallCode == 1)
                neighbors.add(nodes[horizontalNode - 1][verticalNode]);
        } catch (Exception ex) {
        }
        try {
            if (nodes[horizontalNode][verticalNode + 1].wallCode == 1)
                neighbors.add(nodes[horizontalNode][verticalNode + 1]);
        } catch (Exception ex) {
        }
        try {
            if (nodes[horizontalNode][verticalNode - 1].wallCode == 1)
                neighbors.add(nodes[horizontalNode][verticalNode - 1]);
        } catch (Exception ex) {
        }
        return neighbors;
    }

}


