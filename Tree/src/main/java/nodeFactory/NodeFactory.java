package main.java.nodeFactory;

import main.java.nodes.ColoredNode;
import main.java.nodes.Node;
import main.java.nodes.ShapedNode;
import main.java.nodes.SimpleNode;

import java.util.Random;

/**
 * Created by Kostadin on 11-Sep-17.
 */
public class NodeFactory {

    public static ShapedNode getShapedNode() {
        return new ShapedNode();
    }

    public static SimpleNode getSimpleNode() {
        return new SimpleNode();
    }

    public static ColoredNode getColoredNode() {
        return new ColoredNode();
    }

    public static Node getRandomNode() {
        return new Node[]{getShapedNode(), getColoredNode(), getSimpleNode()}[new Random().nextInt(3)];
    }

}
