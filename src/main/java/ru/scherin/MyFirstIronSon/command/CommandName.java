package ru.scherin.MyFirstIronSon.command;

public enum CommandName {

    JOKE("/joke"),
    JOKES("/jokes"),
    HELP("/help"),
    DELETE("/delete"),
    CREATE("/create"),
    NO("/no"),
    RANDOM("/random"),
    TOP("/top"),
    STATS("/stats");
    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

}