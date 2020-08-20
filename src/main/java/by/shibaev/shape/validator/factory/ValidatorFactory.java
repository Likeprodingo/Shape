package by.shibaev.shape.validator.factory;

import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.entity.ShapeType;
import by.shibaev.shape.entity.shape.Sphere;
import by.shibaev.shape.parser.InputShapeParser;
import by.shibaev.shape.reader.ParameterIndex;
import by.shibaev.shape.service.ShapeService;
import by.shibaev.shape.service.impl.SphereServiceImpl;
import by.shibaev.shape.validator.ShapeValidator;
import by.shibaev.shape.validator.impl.SphereValidator;

import java.util.List;
import java.util.Optional;

public class ValidatorFactory {
    public Optional<ShapeValidator> getValidator(ShapeType type) {
        Optional<ShapeValidator> service = Optional.empty();
        switch (type) {
            case Sphere:
                service = Optional.of(new SphereValidator());
                break;
        }
        return service;
    }
}
