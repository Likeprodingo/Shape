package by.shibaev.shape.controller.command.type;

import by.shibaev.shape.controller.command.CommandProcessor;
import by.shibaev.shape.controller.command.impl.GetCommand;

public enum CommandType {

    GET("get", new GetCommand());

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
