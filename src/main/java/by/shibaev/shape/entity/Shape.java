package by.shibaev.shape.entity;

import by.shibaev.shape.observer.Observable;
import by.shibaev.shape.observer.Observer;
import by.shibaev.shape.observer.ShapeEvent;
import by.shibaev.shape.observer.impl.ShapeObserver;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class Shape implements Observable {
    private int id;
    private Observer observer;

    public int getId() {
        return id;
    }

    public Shape(int id) {
        this.id = id;
        observer = new ShapeObserver();
    }

    @Override
    public void notifyObserver() {
        EventObject eventObject = new ShapeEvent(this);
        observer.update(eventObject);
    }
}
