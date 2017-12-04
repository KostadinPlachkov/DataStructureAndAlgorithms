package main.java.nodes;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kostadin on 10-Sep-17.
 */
public class SimpleNode extends Node implements ISimpleNode {
    private int value;

    public SimpleNode() {
        Random random = new Random();
        this.value = random.nextInt(1000);  // Change this number to lower if you want to get a match with value.
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<Object> characteristics() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(getValue());
        return arrayList;
    }
}
