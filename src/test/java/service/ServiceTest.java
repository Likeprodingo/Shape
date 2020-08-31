package service;

import by.shibaev.shape.entity.FlatType;
import by.shibaev.shape.entity.Point;
import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.entity.shape.Sphere;
import by.shibaev.shape.service.ShapeService;
import by.shibaev.shape.service.impl.SphereServiceImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ServiceTest {
    ShapeService sphereService = SphereServiceImpl.getInstance();

    @Test
    public void calculateVolumeTest() {
        double expected = 113.09733359999998;
        Shape shape = new Sphere(new Point(1, 1, 1), 3, 1);
        assertEquals(expected, sphereService.calculateVolume(shape));
    }

    @Test
    public void calculateSquareTest() {
        double expected = 12.5663704;
        Shape shape = new Sphere(new Point(1, 1, 1), 1, 1);
        assertEquals(expected, sphereService.calculateSquare(shape));
    }

    @Test
    public void volumeRatioTest() {
        double expected = 0.5;
        Shape shape = new Sphere(new Point(1, 1, 0), 2, 1);
        FlatType flatType = FlatType.XY;
        assertEquals(sphereService.calculateVolumeRatio(shape, flatType), expected);
    }

    @Test
    public void isRelatePositive() {
        double expected = 0.5;
        Shape shape = new Sphere(new Point(1, 1, 2), 2, 1);
        FlatType flatType = FlatType.XY;
        assertTrue(sphereService.isRelate(shape,flatType));
    }

    @Test
    public void isRelateNegative() {
        double expected = 0.5;
        Shape shape = new Sphere(new Point(1, 1, 3), 2, 1);
        FlatType flatType = FlatType.XY;
        assertFalse(sphereService.isRelate(shape,flatType));
    }
}
