package by.shibaev.shape.service;

import by.shibaev.shape.entity.Flat;
import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.exception.CustomException;

public interface ShapeService {

    double calculateVolume(Shape shape);

    double calculateSquare(Shape shape);

    double calculateVolumeRatio(Shape shape, Flat flat);

    boolean isRelate(Shape shape, Flat flat);
}
