package by.shibaev.shape.controller.command.provider;

import by.shibaev.shape.controller.command.CommandProcessor;
import by.shibaev.shape.controller.command.type.CommandType;

public class CommandProvider {
    public static CommandProcessor provide(String command) {
        CommandProcessor commandProcessor = CommandType.GET.getCommand();
        for (CommandType commandType : CommandType.values()) {
            if (commandType.getName().equals(command)) {
                commandProcessor = commandType.getCommand();
            }
        }
        return commandProcessor;
    }
}