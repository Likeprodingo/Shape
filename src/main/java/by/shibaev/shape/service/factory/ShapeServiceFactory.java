package by.shibaev.shape.service.factory;

import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.entity.shape.Sphere;
import by.shibaev.shape.exception.CustomException;
import by.shibaev.shape.service.ShapeService;
import by.shibaev.shape.service.impl.SphereServiceImpl;

import java.util.Optional;

public class ShapeServiceFactory {
    public Optional<ShapeService> getShapeService(Shape shape) {
        Optional<ShapeService> service = Optional.empty();
        if (shape instanceof Sphere) {
            service = Optional.of(SphereServiceImpl.getInstance());
        }
        return service;
    }
}
