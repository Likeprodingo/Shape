package by.shibaev.shape.controller.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(urlPatterns = "/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024
        , maxFileSize = 1024 * 1024 * 5
        , maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUploadServlet extends HttpServlet {
    private Logger logger = LogManager.getLogger();
    private static final String UPLOAD_DIR = "D:\\servlet\\src\\main\\resources\\upload\\";
    private static final String PATH = "/main.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());

        List<FileItem> files = null;
        try {
            files = sf.parseRequest(request);
            for (FileItem item : files) {
                try {
                    item.write(new File(UPLOAD_DIR + item.getName()));
                } catch (Exception e) {
                    logger.log(Level.ERROR, "Write file exception", e);
                }
            }
        } catch (FileUploadException e) {
            logger.log(Level.ERROR, "Parse exception", e);
        }
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher(PATH);
        dispatcher.forward(request, response);
    }
}
