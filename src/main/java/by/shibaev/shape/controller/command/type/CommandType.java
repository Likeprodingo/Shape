package by.shibaev.shape.controller.command.type;

import by.shibaev.shape.controller.command.CommandProcessor;
import by.shibaev.shape.controller.command.impl.GetFileCommand;
import by.shibaev.shape.controller.command.impl.GetSphereCommand;

public enum CommandType {

    GET_FILES("files", new GetFileCommand()),
    GET("get_sphere", new GetSphereCommand());

    String name;
    CommandProcessor command;

    CommandType(String name, CommandProcessor command) {
        this.name = name;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public CommandProcessor getCommand() {
        return command;
    }
}
