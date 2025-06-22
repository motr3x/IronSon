package ru.scherin.MyFirstIronSon.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.scherin.MyFirstIronSon.service.JokeServiceImpl;
import ru.scherin.MyFirstIronSon.service.SendBotMessageService;

public class StatsCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final JokeServiceImpl jokeService;

    public StatsCommand(SendBotMessageService sendBotMessageService, JokeServiceImpl jokeService) {
        this.sendBotMessageService = sendBotMessageService;
        this.jokeService = jokeService;
    }

    @Override
    public void execute(Update update) {
        String stats = jokeService.getJokeStatistics();
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), stats);
    }
}
