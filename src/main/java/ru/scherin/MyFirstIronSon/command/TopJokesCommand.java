package ru.scherin.MyFirstIronSon.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.scherin.MyFirstIronSon.service.JokeServiceImpl;
import ru.scherin.MyFirstIronSon.service.SendBotMessageService;

import java.util.stream.Collectors;

public class TopJokesCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final JokeServiceImpl jokeService;

    public TopJokesCommand(SendBotMessageService sendBotMessageService, JokeServiceImpl jokeService) {
        this.sendBotMessageService = sendBotMessageService;
        this.jokeService = jokeService;
    }

    @Override
    public void execute(Update update) {
        String topJokes = jokeService.getTop5PopularJokes().stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n\n"));
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
                "Топ-5 популярных анекдотов:\n\n" + topJokes);
    }
}