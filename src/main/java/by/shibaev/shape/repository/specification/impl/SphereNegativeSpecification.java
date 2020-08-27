package by.shibaev.shape.repository.specification.impl;

import by.shibaev.shape.entity.Point;
import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.entity.shape.Sphere;
import by.shibaev.shape.repository.specification.ShapeSpecification;

public class SphereNegativeSpecification implements ShapeSpecification {
    @Override
    public boolean test(Shape shape) {
        boolean result;
        try {
            Sphere sphere = (Sphere) shape;
            result = sphere.getCenter().getxPosition() <= 0 &&
                    sphere.getCenter().getyPosition() <= 0 &&
                    sphere.getCenter().getzPosition() <= 0;
        } catch (ClassCastException e) {
            result = false;
        }
        return result;
    }
}
