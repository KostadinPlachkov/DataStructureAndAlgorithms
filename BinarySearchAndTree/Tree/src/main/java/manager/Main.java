package main.java.manager;


/**
 * Write a program that takes as input two integers x and y.
 * Based on the integers the program generates randomly treeCharacteristics
 * structure having depth = x and every nodes(except any leaf)
 * has y children. Every nodes can be either
 * ISimpleNode(contains only integer value) or
 * IColoredNode (containing integer value and color like
 * red, green, blue, yellow, white) or
 * ShapedNode (having number, color and Shape like
 * rectangle, triangle, diamond, circle).
 * After the treeCharacteristics is generated a console menu should be shown
 * where the user can search for nodes by either number or color
 * or shape or combinations between these 3 properties.

 The search must be configurable:
 - many threads can be configured for better performance
 - indexation of the structure can be also configured in
 order to have at the end high performing search algorithm
 */

public class Main {

    public static void main(String[] args) throws Exception {
        Manager manager = new Manager();
        manager.start();
    }
}
