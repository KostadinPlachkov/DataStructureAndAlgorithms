package main.java.console;

import main.java.treeCharacteristics.Color;
import main.java.nodes.Node;
import main.java.treeCharacteristics.Shape;
import main.java.treeCharacteristics.TreeCharacteristics;
import main.java.treeConverter.TreeConverter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kostadin on 14-Sep-17.
 */
public class Menu implements IMenu {

    @Override
    public void startupText() {
        InputOutput.write("==================================");
        InputOutput.write("TreeGenerator V2.0");
        InputOutput.write("Author: Kostadin Plachkov");
        InputOutput.write("==================================");

    }

    @Override
    public HashMap<TreeCharacteristics, Integer> userInput() {
        InputOutput.write("To generate a tree, please enter:");
        int depth = 0;
        while (depth < 1) {
            InputOutput.write("- Depth [more than 0]: ");
            depth = Integer.parseInt(InputOutput.read());
        }
        int children = 0;
        while (children < 2) {
            InputOutput.write("- Children [more than 1]: ");
            children = Integer.parseInt(InputOutput.read());
        }
        HashMap<TreeCharacteristics, Integer> result = new HashMap<>();
        result.put(TreeCharacteristics.DEPTH, depth);
        result.put(TreeCharacteristics.CHILDREN, children);
        return result;
    }

    public void generateTree() {
        InputOutput.write("Generating tree...");
    }

    @Override
    public void printTree(Node head) {
        TreeConverter treeConverter = new TreeConverter();
        InputOutput.write(treeConverter.toString(head));
    }

    public void searchConsole() {
        InputOutput.write("==================================");
        InputOutput.write("Search Console");
        InputOutput.write("==================================");

    }

    public void searchHelper() {
        InputOutput.write("You can search for nodes by either number (integer) or color (red, green, blue, yellow, white)\n" +
                "or shape (rectangle, triangle, diamond, circle) or combinations between these 3 properties.");

    }

    private Integer searchForValue() {
        InputOutput.write("Enter an integer value or press n for NONE:");
        String userInput = InputOutput.read().toLowerCase();
        if ("n".equals(userInput)) {
            return null;
        }
        return Integer.parseInt(userInput);
    }

    private Color searchForColor() {
        Color[] colors = Color.values();
        int userInput;
        do {
            InputOutput.write("Choose a color:");
            InputOutput.write("0. None");
            for (int i = 1, j = 0; j < colors.length; i++, j++) {
                InputOutput.write(i + ". " + colors[j]);
            }
            InputOutput.write("Enter a number:");
            userInput = Integer.parseInt(InputOutput.read()) - 1;
        }
        while (userInput >= colors.length);
        if (userInput < 0) {
            return null;
        }
        return colors[userInput];
    }

    private Shape searchForShape() {
        Shape[] shapes = Shape.values();
        int userInput;
        do {
            InputOutput.write("Choose a shape:");
            InputOutput.write("0. None");
            for (int i = 1, j = 0; j < shapes.length; i++, j++) {
                InputOutput.write(i + ". " + shapes[j]);
            }
            InputOutput.write("Enter a number:");
            userInput = Integer.parseInt(InputOutput.read()) - 1;
        }
        while (userInput >= shapes.length);
        if (userInput < 0) {
            return null;
        }
        return shapes[userInput];
    }

    @Override
    public ArrayList<Object> searchForNode() {
        Integer value = searchForValue();
        Color color = searchForColor();
        Shape shape = searchForShape();
        ArrayList<Object> characteristics = new ArrayList<>();
        if (value != null) {
            characteristics.add(value);
        }
        if (color != null) {
            characteristics.add(color);
        }
        if (shape != null) {
            characteristics.add(shape);
        }
        return characteristics;
    }

    @Override
    public void searchResult(int result) {
        InputOutput.write("==================================");
        InputOutput.write("Nodes found: " + result);
        InputOutput.write("==================================");
    }


}
