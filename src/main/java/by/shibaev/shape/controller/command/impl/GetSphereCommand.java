package by.shibaev.shape.controller.command.impl;

import by.shibaev.shape.controller.command.AttributeName;
import by.shibaev.shape.controller.command.CommandProcessor;
import by.shibaev.shape.controller.command.ParameterName;
import by.shibaev.shape.controller.servlet.JspPath;
import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.entity.shape.Sphere;
import by.shibaev.shape.repository.ShapeRepository;
import by.shibaev.shape.repository.specification.impl.SphereSpecification;
import by.shibaev.shape.service.FileService;
import by.shibaev.shape.service.ShapeService;
import by.shibaev.shape.service.impl.SphereServiceImpl;

import javax.management.Attribute;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetSphereCommand implements CommandProcessor {
    @Override
    public String process(HttpServletRequest request) {
        FileService fileService = FileService.getInstance();
        String filename = request.getParameter(ParameterName.FILE);
        fileService.addRepository(filename);
        ShapeRepository repository = ShapeRepository.getInstance();
        SphereServiceImpl sphereService = SphereServiceImpl.getInstance();
        List<Shape> shapes = repository.getShapes();
        List<Sphere> spheres = sphereService.convert(shapes);
        List<String> fileNames = fileService.getFileList();
        request.setAttribute(AttributeName.FILES,fileNames);
        request.setAttribute(AttributeName.SPHERES,spheres);
        return JspPath.MAIN;
    }
}
