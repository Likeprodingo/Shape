package by.shibaev.shape.warehouse;

import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.service.ShapeService;
import by.shibaev.shape.service.factory.ShapeServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class ShapeWareHouse {

    private static ShapeWareHouse instance;
    private Map<Integer, ShapeWareHouseParameters> shapes = new HashMap<>();
    private static Logger logger = LogManager.getLogger();

    private ShapeWareHouse() {
    }

    public static ShapeWareHouse getInstance() {
        if (instance == null) {
            instance = new ShapeWareHouse();
        }
        return instance;
    }

    public Map<Integer, ShapeWareHouseParameters> getShapes() {
        return Collections.unmodifiableMap(shapes);
    }

    public void add(Shape shape) {
        ShapeServiceFactory factory = new ShapeServiceFactory();
        Optional<ShapeService> service = factory.getShapeService(shape);
        if (service.isPresent()) {
            if (shapes.containsKey(shape.getId())) {
                logger.log(Level.INFO, "same shape exist: {}", shape);
            } else {
                double volume = service.get().calculateVolume(shape);
                double square = service.get().calculateSquare(shape);
                shapes.put(shape.getId(), new ShapeWareHouseParameters(volume, square));
            }
        } else {
            logger.log(Level.WARN, "service doesn't exist");
        }
    }

    public void remove(Shape shape) {
        if (shapes.remove(shape.getId()) == null) {
            logger.log(Level.INFO, "shape doesn't exist: {}", shape);
        }
    }

    public void update(Shape shape, ShapeWareHouseParameters parameters) {
        shapes.replace(shape.getId(), parameters);
    }
}
