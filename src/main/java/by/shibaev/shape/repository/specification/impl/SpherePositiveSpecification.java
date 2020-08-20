package by.shibaev.shape.repository.specification.impl;

import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.entity.shape.Sphere;
import by.shibaev.shape.repository.specification.ShapeSpecification;

public class SpherePositiveSpecification implements ShapeSpecification {
    @Override
    public boolean test(Shape shape) {
        Sphere sphere = (Sphere) shape;
        return sphere.getCenter().getxPosition() >= 0 && sphere.getCenter().getxPosition() >= 0 &&
                sphere.getCenter().getyPosition() >= 0 && sphere.getCenter().getyPosition() >= 0 &&
                sphere.getCenter().getzPosition() >= 0 && sphere.getCenter().getzPosition() >= 0;
    }
}
