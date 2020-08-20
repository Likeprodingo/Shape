package by.shibaev.shape.observer.impl;

import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.observer.Observer;
import by.shibaev.shape.observer.ShapeEvent;
import by.shibaev.shape.service.ShapeService;
import by.shibaev.shape.service.factory.ShapeServiceFactory;
import by.shibaev.shape.warehouse.ShapeWareHouse;
import by.shibaev.shape.warehouse.ShapeWareHouseParameters;

import java.util.Optional;

public class ShapeObserver implements Observer<ShapeEvent> {
    @Override
    public void update(ShapeEvent event) {
        Shape shape = event.getSource();
        ShapeServiceFactory shapeServiceFactory = new ShapeServiceFactory();
        Optional<ShapeService> service = shapeServiceFactory.getShapeService(shape);
        if(service.isPresent()){
            double volume = service.get().calculateVolume(shape);
            double square = service.get().calculateSquare(shape);
            ShapeWareHouseParameters shapeWareHouseParameters = new ShapeWareHouseParameters(volume,square);
            ShapeWareHouse shapeWareHouse = ShapeWareHouse.getInstance();
            shapeWareHouse.update(shape, shapeWareHouseParameters);
        }
    }
}
