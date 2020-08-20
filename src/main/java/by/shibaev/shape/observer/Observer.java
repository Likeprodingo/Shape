package by.shibaev.shape.observer;

import java.util.EventObject;

public interface Observer<T extends EventObject> {
    void update(T event);
}
