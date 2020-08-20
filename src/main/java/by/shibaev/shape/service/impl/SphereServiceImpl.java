package by.shibaev.shape.service.impl;

import by.shibaev.shape.entity.Flat;
import by.shibaev.shape.entity.Point;
import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.entity.shape.Sphere;
import by.shibaev.shape.exception.CustomException;
import by.shibaev.shape.service.ShapeService;

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
    public double calculateVolumeRatio(Shape shape, Flat flat) {
        return 0;
    }

    @Override
    public boolean isRelate(Shape shape, Flat flat) {
        return true;
    }


    private Point calculateMiddle(Point A, Point B) {
        int x = (A.getxPosition() - B.getxPosition()) / 2;
        int y = (A.getyPosition() - B.getyPosition()) / 2;
        int z = (A.getzPosition() - B.getzPosition()) / 2;
        return new Point(x, y, z);
    }
}
