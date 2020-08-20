import by.shibaev.shape.exception.CustomException;
import by.shibaev.shape.parser.InputShapeParser;
import by.shibaev.shape.reader.CustomFileReader;

public class Main {
    public static void main(String[] args) throws CustomException {
        CustomFileReader customFileReader = CustomFileReader.getInstance();
        InputShapeParser inputShapeParser = new InputShapeParser();
        System.out.println(inputShapeParser.parseData(customFileReader.read()));
    }
}
