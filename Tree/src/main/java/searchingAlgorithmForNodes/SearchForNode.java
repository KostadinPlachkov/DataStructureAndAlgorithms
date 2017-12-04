package main.java.searchingAlgorithmForNodes;

import main.java.nodes.Node;

import java.util.ArrayList;

/**
 * Created by Kostadin on 14-Sep-17.
 */
public class SearchForNode {

    public static int equalTo(Node head, ArrayList<Object> characteristics) {
        int count = 0;
        ArrayList<Object> headCharacteristics = head.characteristics();
        boolean characteristicsAreEqual = true;
        for (Object characteristic: characteristics) {
            if (!headCharacteristics.contains(characteristic)) {
                characteristicsAreEqual = false;
            }
        }
        if (characteristicsAreEqual) {
            count++;
        }
        for (Node child : head.getChildren()) {
            count += equalTo(child, characteristics);
        }
        return count;
    }
}
