package by.shibaev.shape.service.impl;

import by.shibaev.shape.entity.FlatType;
import by.shibaev.shape.entity.Point;
import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.entity.shape.Sphere;
import by.shibaev.shape.service.ShapeService;

import java.util.ArrayList;
import java.util.List;

public class SphereServiceImpl implements ShapeService {
    private static SphereServiceImpl instance;
    private static double PI = 3.1415926;

    private SphereServiceImpl() {
    }

    public static SphereServiceImpl getInstance() {
        if (instance == null) {
            instance = new SphereServiceImpl();
        }
        return instance;
    }

    @Override
    public double calculateVolume(Shape shape) {
        Sphere sphere = (Sphere) shape;
        return 4 / 3. * PI * Math.pow(sphere.getRadius(), 3);
    }

    @Override
    public double calculateSquare(Shape shape) {
        Sphere sphere = (Sphere) shape;
        return 4 * PI * Math.pow(sphere.getRadius(), 2);
    }

    @Override
    public double calculateVolumeRatio(Shape shape, FlatType flat) {
        Sphere sphere = (Sphere) shape;
        double result;
        double distance = calculateDistance(sphere.getCenter(), flat);
        if (distance < sphere.getRadius()) {
            result = distance / sphere.getRadius();
        } else {
            result = 0;
        }
        return result;
    }

    @Override
    public boolean isRelate(Shape shape, FlatType flat) {
        Sphere sphere = (Sphere) shape;
        return calculateDistance(sphere.getCenter(), flat) == sphere.getRadius();
    }

    private double calculateDistance(Point center, FlatType type) {
        double distance = 0;

        switch (type) {
            case ZY:
                distance = center.getxPosition();
                break;
            case XZ:
                distance = center.getyPosition();
                break;
            case XY:
                distance = center.getzPosition();
                break;
        }
        return distance;
    }

    public List<Sphere> convert(List<Shape> shapes) {
        List<Sphere> spheres = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape instanceof Sphere) {
                spheres.add((Sphere) shape);
            }
        }
        return spheres;
    }
}
