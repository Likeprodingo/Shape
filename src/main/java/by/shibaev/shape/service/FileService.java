package by.shibaev.shape.service;

import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.exception.CustomException;
import by.shibaev.shape.parser.InputShapeParser;
import by.shibaev.shape.reader.CustomFileReader;
import by.shibaev.shape.repository.ShapeRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileService {

    private static Logger logger = LogManager.getLogger();
    private static String PATH = "D:\\servlet\\src\\main\\resources\\upload";
    private static FileService instance;

    public static FileService getInstance() {
        if (instance == null) {
            instance = new FileService();
        }
        return instance;
    }

    public void addRepository(String filename) {
        CustomFileReader customFileReader = CustomFileReader.getInstance();
        InputShapeParser shapeParser = new InputShapeParser();
        ShapeRepository shapeRepository = ShapeRepository.getInstance();
        List<String> lines;
        List<Shape> shapes;
        try {
            lines = customFileReader.read(filename);
            shapes = shapeParser.parseData(lines);
            for (Shape shape : shapes) {
                shapeRepository.add(shape);
            }
        } catch (CustomException e) {
            logger.log(Level.ERROR, "Read exception", e);
        }
    }

    public List<String> getFileList() {
        File folder = new File(PATH);
        File[] files = folder.listFiles();
        List<String> result = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                result.add(file.getName());
            }
        }
        return result;
    }
}
