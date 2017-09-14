package main.java.console;

import main.java.nodes.Node;
import main.java.treeCharacteristics.TreeCharacteristics;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kostadin on 14-Sep-17.
 */
public interface IMenu {
    void startupText();
    HashMap<TreeCharacteristics, Integer> userInput();
    void printTree(Node head);
    ArrayList<Object> searchForNode();
    void searchResult(int result);

}
