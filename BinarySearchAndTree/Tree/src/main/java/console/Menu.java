package main.java.console;

import main.java.nodes.Node;
import main.java.treeCharacteristics.TreeCharacteristics;
import main.java.treeConverter.TreeConverter;

import java.util.HashMap;

/**
 * Created by Kostadin on 14-Sep-17.
 */
public class Menu implements IMenu {

    @Override
    public void startupText() {
        InputOutput.write("TreeGenerator V2.0");
        InputOutput.write("Author: Kostadin Plachkov");
    }

    @Override
    public HashMap<TreeCharacteristics, Integer> userInput() throws Exception {
        InputOutput.write("To generate a tree, please enter:");
        InputOutput.write("- Depth: ");
        int depth = 0;
        try {
            depth = Integer.parseInt(InputOutput.read());
        }
        catch (Exception e){
            throw new Exception("Please enter a number! Exception: " + e);
        }
        InputOutput.write("- Children: ");
        int children = 0;
        try {
            children = Integer.parseInt(InputOutput.read());
        }
        catch (Exception e){
            throw new Exception("Please enter a number! Exception: " + e);
        }
        HashMap<TreeCharacteristics, Integer> result = new HashMap<>();
        result.put(TreeCharacteristics.DEPTH, depth);
        result.put(TreeCharacteristics.CHILDREN, children);
        return result;
    }

    @Override
    public void generateTree() {
        InputOutput.write("Generating tree...");
    }

    @Override
    public void printTree(Node head) {
        TreeConverter treeConverter = new TreeConverter();
        InputOutput.write(treeConverter.toString(head));
    }
}
