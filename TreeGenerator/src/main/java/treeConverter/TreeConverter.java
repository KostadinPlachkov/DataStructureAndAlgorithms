package main.java.treeConverter;


import main.java.nodes.Node;

/**
 * Created by Kostadin on 14-Sep-17.
 */
public class TreeConverter {

    private static final int indent = 4;

    public String toString(Node head) {
        return toString(head, 0);
    }

    private String toString(Node head, int increment) {
        String treeString = "";
        String inc = "";
        for (int i = 0; i < increment; ++i) {
            inc = inc + " ";
        }
        treeString = inc + head;
        for (Node child : head.getChildren()) {
            treeString += "\n" + toString(child, increment + indent);
        }
        return treeString;
    }
}
