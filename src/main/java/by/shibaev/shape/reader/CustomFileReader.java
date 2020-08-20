package by.shibaev.shape.reader;

import by.shibaev.shape.exception.CustomException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomFileReader {
    private static CustomFileReader instance;
    private static final String FILE_NAME = "src/main/resources/data.txt";

    private CustomFileReader() {
    }

    public static CustomFileReader getInstance() {
        if (instance == null) {
            instance = new CustomFileReader();
        }
        return instance;
    }

    public List<String> read() throws CustomException {
        List<String> lines;
        Path path = Paths.get(FILE_NAME);
        try (Stream<String> lineStream = Files.lines(path)) {

            lines = lineStream.collect(Collectors.toList());

        } catch (IOException e) {
            throw new CustomException("File read error", e);
        }
        return lines;
    }
}