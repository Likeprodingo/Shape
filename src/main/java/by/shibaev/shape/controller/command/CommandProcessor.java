package by.shibaev.shape.controller.command;

import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.warehouse.ShapeWareHouseParameters;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface CommandProcessor {
    String process(HttpServletRequest request);
}
