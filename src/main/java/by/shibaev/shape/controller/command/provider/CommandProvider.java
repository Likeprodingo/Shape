package by.shibaev.shape.controller.command.provider;

import by.shibaev.shape.controller.command.CommandProcessor;
import by.shibaev.shape.controller.command.type.CommandType;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandProvider {
    private static final Logger logger = LogManager.getLogger();
    private static String COMMAND = "command";
    public static Optional<CommandProcessor> provide(HttpServletRequest request) {
        Optional<CommandProcessor> commandProcessor = Optional.empty();
        for (CommandType commandType : CommandType.values()) {
            if (commandType.getName().equals(request.getParameter(COMMAND).toLowerCase())) {
                commandProcessor = Optional.of(commandType.getCommand());
                logger.log(Level.INFO,"Command tag: {}",commandType.getName());
                break;
            }
        }
        return commandProcessor;
    }
}