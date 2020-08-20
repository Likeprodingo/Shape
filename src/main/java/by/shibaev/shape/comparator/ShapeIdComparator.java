package by.shibaev.shape.comparator;

import by.shibaev.shape.entity.Shape;


import java.util.Comparator;

public class ShapeIdComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        return Integer.compare(s1.getId(), s2.getId());
    }
}
