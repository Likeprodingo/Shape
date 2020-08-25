package reader;

import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.exception.CustomException;
import by.shibaev.shape.parser.InputShapeParser;
import by.shibaev.shape.reader.CustomFileReader;
import by.shibaev.shape.repository.ShapeRepository;
import by.shibaev.shape.warehouse.ShapeWareHouse;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FullFillTest {
    @Test
    public void fullFillTest() throws CustomException {
        CustomFileReader reader = CustomFileReader.getInstance();
        InputShapeParser parser = new InputShapeParser();
        List<String> data = reader.read("data.txt");
        List<Shape> shapes = parser.parseData(data);
        assertEquals(shapes.size(), 1);
    }
}
