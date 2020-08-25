package by.shibaev.shape.controller.servlet;

import by.shibaev.shape.controller.command.CommandProcessor;
import by.shibaev.shape.controller.command.provider.CommandProvider;
import by.shibaev.shape.entity.Shape;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(urlPatterns = "/controller")
public class ShapeController extends HttpServlet {
    private static final String PATH = "/main.jsp";
    private static Logger logger = LogManager.getLogger();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = "get";
        CommandProcessor processor = CommandProvider.provide(command);
        String filename = request.getParameter("file");
        logger.log(Level.INFO,"File name {}",filename);
        List<Shape> shapes = processor.process(filename);
        request.setAttribute("shapes", shapes);
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher(PATH);
        dispatcher.forward(request, response);
    }
}
