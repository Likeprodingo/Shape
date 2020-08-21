package by.shibaev.shape.repository;

import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.exception.CustomException;
import by.shibaev.shape.repository.specification.ShapeSpecification;
import by.shibaev.shape.warehouse.ShapeWareHouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ShapeRepository {
    private static ShapeRepository instance;
    private static Logger logger = LogManager.getLogger();

    private ShapeRepository() {
    }

    private List<Shape> shapes = new ArrayList<>();

    public static ShapeRepository getInstance() {
        if (instance == null) {
            instance = new ShapeRepository();
        }
        return instance;
    }

    public List<Shape> getShapes() {
        return Collections.unmodifiableList(shapes);
    }

    public Optional<Shape> getShape(int id) {
        Optional<Shape> result = Optional.empty();
        for (Shape shape : shapes) {
            if (shape.getId() == id) {
                result = Optional.of(shape);
            }
        }
        return result;
    }

    public void add(Shape shape) throws CustomException {
        ShapeWareHouse shapeWareHouse = ShapeWareHouse.getInstance();
        shapeWareHouse.add(shape);
        logger.log(Level.INFO, "shape added: {}", shape);
        shapes.add(shape);
    }

    public void remove(Shape shape) {
        ShapeWareHouse shapeWareHouse = ShapeWareHouse.getInstance();
        shapeWareHouse.remove(shape);
        logger.log(Level.INFO, "shape removed: {}", shape);
        shapes.remove(shape);
    }

    public List<Shape> query(ShapeSpecification specification) {
        return shapes.stream().filter(specification).collect(Collectors.toList());
    }

    public List<Shape> sort(Comparator<Shape> comparator) {
        return shapes.stream().sorted(comparator).collect(Collectors.toList());
    }
}
