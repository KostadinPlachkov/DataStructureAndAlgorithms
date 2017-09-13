package main.java.nodes;


import main.java.shapes.Shape;

import java.util.Random;

/**
 * Created by Kostadin on 10-Sep-17.
 */
public class ShapedNode extends ColoredNode implements IShapedNode {
    private Shape shape;

    public ShapedNode() {
        Random random = new Random();
        this.shape = (Shape.values())[random.nextInt(Shape.values().length)];
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }

    @Override
    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
