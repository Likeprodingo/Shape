package by.shibaev.shape.entity.shape;

import by.shibaev.shape.entity.Point;
import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.warehouse.ShapeWareHouse;

public class Sphere extends Shape {
    private Point center;
    private double radius;

    public Sphere(Point center, double radius, int id) {
        super(id);
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
        ShapeWareHouse shapeWareHouse = ShapeWareHouse.getInstance();
        notifyObserver();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        notifyObserver();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sphere sphere = (Sphere) o;

        if (Double.compare(sphere.radius, radius) != 0) return false;
        return center != null ? center.equals(sphere.center) : sphere.center == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = center != null ? center.hashCode() : 0;
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Sphere{");
        sb.append("center=").append(center);
        sb.append(", radius=").append(radius);
        sb.append('}');
        return sb.toString();
    }
}
