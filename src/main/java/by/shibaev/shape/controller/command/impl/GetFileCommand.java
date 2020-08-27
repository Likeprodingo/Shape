package by.shibaev.shape.controller.command.impl;

import by.shibaev.shape.controller.command.AttributeName;
import by.shibaev.shape.controller.command.CommandProcessor;
import by.shibaev.shape.controller.command.ParameterName;
import by.shibaev.shape.controller.servlet.JspPath;
import by.shibaev.shape.entity.Shape;
import by.shibaev.shape.service.FileService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class GetFileCommand implements CommandProcessor {
    @Override
    public String process(HttpServletRequest request) {
        FileService fileService = FileService.getInstance();
        List<String> fileNames = fileService.getFileList();
        request.setAttribute(AttributeName.FILES,fileNames);
        return JspPath.MAIN;
    }
}
