package MazeSolver;

import java.util.ArrayList;

public class Node {
    public Node[][] nodes;
    public int verticalNode;
    public int horizontalNode;
    public boolean top_wall = true;
    public boolean bot_wall = true;
    public boolean right_wall = true;
    public boolean left_wall = true;
    private int wallCode= 0;

    public Node(int horizontalNode, int verticalNode, Node[][] nodes) {
        this.verticalNode = verticalNode;
        this.horizontalNode = horizontalNode;
        this.nodes = nodes;
    }

    public void setWallCode(int code){
        this.wallCode = code;
    }

    public ArrayList<Node> path_options(){
        ArrayList<Node> temp = new ArrayList<Node>();
        if(!top_wall && horizontalNode!=0){
            if(nodes[horizontalNode-1][verticalNode].wallCode == 1)
                temp.add(nodes[horizontalNode-1][verticalNode]);
        }
        if(!bot_wall && horizontalNode!=nodes.length-1){
            if(nodes[horizontalNode+1][verticalNode].wallCode == 1)
                temp.add(nodes[horizontalNode+1][verticalNode]);
        }
        if(!right_wall&& verticalNode!=nodes[0].length-1){
            if(nodes[horizontalNode][verticalNode+1].wallCode == 1)
                temp.add(nodes[horizontalNode][verticalNode+1]);
        }
        if(!left_wall && verticalNode!=0){
            if(nodes[horizontalNode][verticalNode-1].wallCode == 1)
                temp.add(nodes[horizontalNode][verticalNode-1]);
        }
        return temp;
    }

    public int getWallCode(){
        return wallCode;
    }

    public Node back_tracing(){
        if(!top_wall && horizontalNode!=0){
            if(nodes[horizontalNode-1][verticalNode].wallCode== 2)
                return (nodes[horizontalNode-1][verticalNode]);
        }
        if(!bot_wall){
            if(nodes[horizontalNode+1][verticalNode].wallCode == 2)
                return (nodes[horizontalNode+1][verticalNode]);
        }
        if(!right_wall){
            if(nodes[horizontalNode][verticalNode+1].wallCode == 2)
                return (nodes[horizontalNode][verticalNode+1]);
        }
        if(!left_wall){
            if(nodes[horizontalNode][verticalNode-1].wallCode == 2)
                return (nodes[horizontalNode][verticalNode-1]);
        }
        return null;
    }

    public Node next_node(){
        try {
            if (!top_wall && horizontalNode != 0) {
                if (nodes[horizontalNode - 1][verticalNode].wallCode == 2)
                    return (nodes[horizontalNode - 1][verticalNode]);
            }
            if (!bot_wall && horizontalNode != nodes.length - 1) {
                if (nodes[horizontalNode + 1][verticalNode].wallCode == 2)
                    return (nodes[horizontalNode + 1][verticalNode]);
            }
            if (!right_wall) {
                if (nodes[horizontalNode][verticalNode + 1].wallCode == 2)
                    return (nodes[horizontalNode][verticalNode + 1]);
            }
            if (!left_wall) {
                if (nodes[horizontalNode][verticalNode - 1].wallCode == 2)
                    return (nodes[horizontalNode][verticalNode - 1]);
            }
        }
        catch (Exception ex){
        }
        return null;
    }

    public void open_top() {
        top_wall = false;

        nodes[horizontalNode - 1][verticalNode].bot_wall = false;

    }

    public void open_bot() {
        bot_wall = false;
        nodes[horizontalNode + 1][verticalNode].top_wall = false;

    }

    public void open_left() {
        left_wall = false;
        nodes[horizontalNode][verticalNode - 1].right_wall = false;

    }

    public void open_right() {
        right_wall = false;

        nodes[horizontalNode][verticalNode + 1].left_wall = false;

    }

    public ArrayList<Node> uncheckedNodes() {
        ArrayList<Node> neighbors = new ArrayList<Node>();
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

    public ArrayList<Node> checkedNodes() {
        ArrayList<Node> neighbors = new ArrayList<Node>();
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


