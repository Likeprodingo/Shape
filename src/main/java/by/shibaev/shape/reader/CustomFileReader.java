package by.shibaev.shape.reader;

import by.shibaev.shape.exception.CustomException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomFileReader {
    private static Logger logger = LogManager.getLogger();
    private static CustomFileReader instance;
    private static final String DIRECTORY_PATH = "D:\\servlet\\src\\main\\resources\\upload\\";

    private CustomFileReader() {
    }

    public static CustomFileReader getInstance() {
        if (instance == null) {
            instance = new CustomFileReader();
        }
        return instance;
    }

    public List<String> read(String filename) throws CustomException {
        List<String> lines;
        Path path = Paths.get(DIRECTORY_PATH + filename);
        try (Stream<String> lineStream = Files.lines(path)) {

            lines = lineStream.collect(Collectors.toList());

        } catch (IOException e) {
            throw new CustomException("File read error", e);
        }
        logger.log(Level.INFO, "read {} shapes", lines.size());
        return lines;
    }
}
