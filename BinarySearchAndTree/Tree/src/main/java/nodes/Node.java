package main.java.nodes;

import java.util.ArrayList;

/**
 * Created by Kostadin on 13-Sep-17.
 */
public class Node {

    private ArrayList<Node> children = new ArrayList<>();

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public void setChild(Node child) {
        this.children.add(child);
    }

}
