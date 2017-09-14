package main.java.manager;

import main.java.console.Menu;
import main.java.nodes.Node;
import main.java.searchingAlgorithmForNodes.SearchForNode;
import main.java.treeCharacteristics.TreeCharacteristics;
import main.java.treeGenerator.TreeGenerator;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kostadin on 14-Sep-17.
 */

public class Manager {

    public void start() {
        TreeGenerator treeGenerator = new TreeGenerator();
        Menu menu = new Menu();
        menu.startupText();
        HashMap<TreeCharacteristics, Integer> userInput = menu.userInput();
        menu.generateTree();
        Node treeHead = treeGenerator.generate(userInput.get(TreeCharacteristics.DEPTH), userInput.get(TreeCharacteristics.CHILDREN));
        menu.printTree(treeHead);
        menu.searchConsole();
        menu.searchHelper();
        while (true) {
            ArrayList<Object> characteristics = menu.searchForNode();
            int result = SearchForNode.equalTo(treeHead, characteristics);
            menu.searchResult(result);
        }
    }
}
