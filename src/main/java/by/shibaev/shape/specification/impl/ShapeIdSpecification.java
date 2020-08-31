package by.shibaev.shape.specification.impl;

import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.specification.ShapeSpecification;

public class ShapeIdSpecification implements ShapeSpecification {
    private int shapeId;

    public ShapeIdSpecification(int shapeId) {
        this.shapeId = shapeId;
    }

    @Override
    public boolean test(Shape shape) {
        return shapeId == shape.getId();
    }
}
