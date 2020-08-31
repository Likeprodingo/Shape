package by.shibaev.shape.specification.impl;

import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.entity.shape.Sphere;
import by.shibaev.shape.specification.ShapeSpecification;

public class SphereSpecification implements ShapeSpecification {
    @Override
    public boolean test(Shape shape) {
        boolean result = true;
        try {
            Sphere sphere = (Sphere) shape;
        } catch (ClassCastException e) {
            result = false;
        }
        return result;
    }
}
