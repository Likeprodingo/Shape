package by.shibaev.shape.controller.command.impl;

import by.shibaev.shape.controller.command.CommandProcessor;
import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.exception.CustomException;
import by.shibaev.shape.parser.InputShapeParser;
import by.shibaev.shape.reader.CustomFileReader;
import by.shibaev.shape.repository.ShapeRepository;
import by.shibaev.shape.warehouse.ShapeWareHouseParameters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetCommand implements CommandProcessor {

    private static Logger logger = LogManager.getLogger();

    @Override
    public List<Shape> process(String data) {
        List<Shape> result = new ArrayList<>();
        CustomFileReader reader = CustomFileReader.getInstance();
        ShapeRepository repository = ShapeRepository.getInstance();
        InputShapeParser parser = new InputShapeParser();
        try {
            List<String> lines = reader.read(data);
            result = parser.parseData(lines);
            for (Shape s : result) {
                repository.add(s);
            }
        } catch (CustomException e) {
            logger.log(Level.ERROR, "File not exists", e);
        }
        return result;
    }
}
