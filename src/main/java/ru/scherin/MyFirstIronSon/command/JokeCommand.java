package ru.scherin.MyFirstIronSon.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.scherin.MyFirstIronSon.service.JokeServiceImpl;
import ru.scherin.MyFirstIronSon.service.SendBotMessageService;


public class JokeCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final JokeServiceImpl jokeService;
    public JokeCommand(SendBotMessageService sendBotMessageService, JokeServiceImpl jokeService) {
        this.sendBotMessageService = sendBotMessageService;
        this.jokeService = jokeService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),jokeService.getJokeById(Long.parseLong(update.getMessage().getText().replace("/joke ", ""))).toString());
    }
}
