package ru.scherin.MyFirstIronSon.command;

public enum CommandName {

    JOKE("/joke"),
    JOKES("/jokes"),
    HELP("/help"),
    DELETE("/delete"),
    CREATE("/create");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

}