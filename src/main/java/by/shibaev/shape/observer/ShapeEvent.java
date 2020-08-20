package by.shibaev.shape.observer;

import by.shibaev.shape.entity.Shape;

import java.util.EventObject;

public class ShapeEvent extends EventObject {
    public ShapeEvent(Object source) {
        super(source);
    }

    @Override
    public Shape getSource() {
        return (Shape) super.getSource();
    }
}
