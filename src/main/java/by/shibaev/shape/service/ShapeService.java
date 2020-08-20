package by.shibaev.shape.service;

import by.shibaev.shape.entity.FlatType;
import by.shibaev.shape.entity.Shape;

public interface ShapeService {

    double calculateVolume(Shape shape);

    double calculateSquare(Shape shape);

    double calculateVolumeRatio(Shape shape, FlatType flat);

    boolean isRelate(Shape shape, FlatType flat);
}
