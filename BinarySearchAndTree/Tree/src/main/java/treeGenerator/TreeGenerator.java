package main.java.treeGenerator;

import main.java.nodeFactory.NodeFactory;
import main.java.nodes.Node;

/**
 * Created by Kostadin on 11-Sep-17.
 */
public class TreeGenerator {
    public Node generate(int depth, int children) {

        Node head = NodeFactory.getRandomNode();
        tree(head, depth, children);
        return head;  // The root of the tree.
    }

    private void tree(Node head, int depth, int children) {
        if (depth == 0) {
            return;
        }
        setChildren(head, children);
        for (Node child: head.getChildren()) {
            tree(child, depth - 1, children);
        }
    }

    private static void setChildren(Node head, int children) {
        for (int i = 0; i < children; i++) {
            head.setChild(NodeFactory.getRandomNode());
        }
    }
}
