package me.cerratolabs.rustrcon.commands.factory;

import me.cerratolabs.rustrcon.commands.GenericCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandFactory {

    private List<GenericCommand> commandList;

    public CommandFactory() {
        commandList = new ArrayList<>();
    }

    public GenericCommand findCommandByMessage(String message) {
        return commandList.stream().filter(command -> message.contains(command.getMessageContains())).findFirst().orElse(null);
    }

}