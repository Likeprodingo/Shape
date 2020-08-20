package repository;

import by.shibaev.shape.repository.ShapeRepository;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class RepositoryTest {
    @Test
    public void getShapeTest(){
        ShapeRepository shapeRepository = ShapeRepository.getInstance();
        int id = 0;
        assertTrue(shapeRepository.getShape(id).isEmpty());
    }
}
