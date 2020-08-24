package by.shibaev.shape.validator.impl;

import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.entity.shape.Sphere;
import by.shibaev.shape.parser.InputShapeParser;
import by.shibaev.shape.reader.ParameterIndex;
import by.shibaev.shape.validator.ShapeValidator;

import java.util.Arrays;
import java.util.List;

public class SphereValidator implements ShapeValidator {
    private static final int MAX_RADIUS = 1000;
    @Override
    public boolean isParamsValid(String line) {
        boolean res = true;
        InputShapeParser inputShapeParser = new InputShapeParser();
        List<String> parameters = inputShapeParser.parseParameters(line);
        if (parameters.size() != 6) {
            res = false;
        } else {
            try {
                Sphere sphere = inputShapeParser.sphereParser(line);
                if (sphere.getRadius() <= 0 || sphere.getRadius() > MAX_RADIUS) {
                    res = false;
                }
                if (sphere.getId() < 0) {
                    res = false;
                }
            } catch (NumberFormatException e) {
                res = false;
            }
        }
        return res;
    }
}
