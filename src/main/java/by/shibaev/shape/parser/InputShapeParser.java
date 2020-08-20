package by.shibaev.shape.parser;

import by.shibaev.shape.entity.Point;
import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.entity.factory.ShapeFactory;
import by.shibaev.shape.entity.ShapeType;
import by.shibaev.shape.entity.shape.Sphere;
import by.shibaev.shape.reader.ParameterIndex;
import by.shibaev.shape.validator.ShapeValidator;
import by.shibaev.shape.validator.factory.ValidatorFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InputShapeParser {
    private static final String LINE_FORMAT_PATTERN = " ";

    public List<Shape> parseData(List<String> lines) {
        List<Shape> shapes;
        ShapeFactory shapeFactory = new ShapeFactory();
        shapes = lines.stream()
                .filter((s) ->
                        getShapeType(s).isPresent()
                )
                .map((s -> shapeFactory.getShape(s).get())
                )
                .collect(Collectors.toList());
        return shapes;
    }

    private Optional<ShapeType> getShapeType(String line) {
        Optional<ShapeType> result = Optional.empty();
        Optional<ShapeValidator> validator;
        ValidatorFactory validatorFactory = new ValidatorFactory();
        List<String> parameters = parseParameters(line);
        try {
            String value = parameters.get(ParameterIndex.TYPE_INDEX);
            for (ShapeType type : ShapeType.values()) {
                validator = validatorFactory.getValidator(type);
                if(validator.isEmpty()){
                    continue;
                }
                if (type.getName().equals(value) && validator.get().isParamsValid(line)) {
                    result = Optional.of(type);
                    break;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            //log
        }
        return result;
    }

    public List<String> parseParameters(String line){
        return Arrays.asList(line.split(LINE_FORMAT_PATTERN));
    }


    public Sphere sphereParser(String line) throws NumberFormatException {
        List<String> parameters = parseParameters(line);
        Point point;
        int id = Integer.parseInt(parameters.get(ParameterIndex.ID_INDEX));
        double radius = Double.parseDouble(parameters.get(ParameterIndex.RADIUS_INDEX));
        int x = Integer.parseInt(parameters.get(ParameterIndex.X_INDEX));
        int y = Integer.parseInt(parameters.get(ParameterIndex.Y_INDEX));
        int z = Integer.parseInt(parameters.get(ParameterIndex.Z_INDEX));
        point = new Point(x, y, z);
        return new Sphere(point, radius, id);
    }
}
