package main.java.nodes;


import main.java.treeCharacteristics.Color;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kostadin on 10-Sep-17.
 */
public class ColoredNode extends SimpleNode implements IColoredNode {
    private Color color;

    public ColoredNode() {
        Random random = new Random();
        this.color = (Color.values())[random.nextInt(Color.values().length)];
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ArrayList<Object> characteristics() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(getValue());
        arrayList.add(getColor());
        return arrayList;
    }
}
