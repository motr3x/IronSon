package ru.scherin.MyFirstIronSon.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.scherin.MyFirstIronSon.service.JokeServiceImpl;
import ru.scherin.MyFirstIronSon.service.SendBotMessageService;

public class RandomJokeCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final JokeServiceImpl jokeService;

    public RandomJokeCommand(SendBotMessageService sendBotMessageService, JokeServiceImpl jokeService) {
        this.sendBotMessageService = sendBotMessageService;
        this.jokeService = jokeService;
    }

    @Override
    public void execute(Update update) {
        Long userId = update.getMessage().getFrom().getId();
        String joke = jokeService.getRandomJoke(userId).toString();
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), joke);
    }
}