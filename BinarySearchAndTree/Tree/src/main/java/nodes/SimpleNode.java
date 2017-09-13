package main.java.nodes;

import java.util.Random;

/**
 * Created by Kostadin on 10-Sep-17.
 */
public class SimpleNode extends Node implements ISimpleNode {
    private int value;

    public SimpleNode() {
        Random random = new Random();
        this.value = random.nextInt();
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }
}
