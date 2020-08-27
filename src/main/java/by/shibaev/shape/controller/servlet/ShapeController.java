package by.shibaev.shape.controller.servlet;

import by.shibaev.shape.controller.command.AttributeName;
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
import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(urlPatterns = "/controller")
public class ShapeController extends HttpServlet {
    private static Logger logger = LogManager.getLogger();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<CommandProcessor> processor = CommandProvider.provide(request);
        logger.log(Level.INFO, "I HAVE GOT {}", request.getParameter("command"));
        CommandProcessor command = processor.orElseThrow(IllegalAccessError::new);
        String page = command.process(request);
        logger.log(Level.INFO, "I HAVE GOT {}", request.getAttribute(AttributeName.FILES));
        if (page != null){
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(JspPath.ERROR);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
