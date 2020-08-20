package by.shibaev.shape.entity.factory;

import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.entity.ShapeType;
import by.shibaev.shape.parser.InputShapeParser;
import by.shibaev.shape.reader.ParameterIndex;

import java.util.List;
import java.util.Optional;

public class ShapeFactory {

    public Optional<Shape> getShape(String line) {
        Optional<Shape> result = Optional.empty();
        InputShapeParser shapeParser = new InputShapeParser();
        List<String> parameters = shapeParser.parseParameters(line);
        String typeName = parameters.get(ParameterIndex.TYPE_INDEX);
        ShapeType type = null;
        for (ShapeType t : ShapeType.values()) {
            if (t.getName().equals(typeName)) {
                type = t;
                break;
            }
        }
        switch (type) {
            case Sphere:
                result = Optional.of(shapeParser.sphereParser(line));
                break;
        }
        return result;
    }
}
