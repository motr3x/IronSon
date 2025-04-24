package ru.scherin.MyFirstIronSon.command;

import com.google.common.collect.ImmutableMap;
import ru.scherin.MyFirstIronSon.service.SendBotMessageService;
import ru.scherin.MyFirstIronSon.service.JokeServiceImpl;

import static ru.scherin.MyFirstIronSon.command.CommandName.*;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService, JokeServiceImpl jokeService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(JOKE.getCommandName(), new JokeCommand(sendBotMessageService, jokeService))
                .put(JOKES.getCommandName(), new JokesCommand(sendBotMessageService, jokeService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(DELETE.getCommandName(), new DeleteJokeCommand(sendBotMessageService, jokeService))
                .put(CREATE.getCommandName(), new CreateJokeCommand(sendBotMessageService, jokeService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }

}