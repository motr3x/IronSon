package ru.scherin.MyFirstIronSon.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.scherin.MyFirstIronSon.entity.Joke;
import ru.scherin.MyFirstIronSon.service.JokeServiceImpl;
import ru.scherin.MyFirstIronSon.service.SendBotMessageService;

import java.util.Date;

public class CreateJokeCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    private final JokeServiceImpl jokeService;
    public CreateJokeCommand(SendBotMessageService sendBotMessageService, JokeServiceImpl jokeService) {
        this.sendBotMessageService = sendBotMessageService;
        this.jokeService = jokeService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),"Joke was created");
        Joke newJoke = new Joke();
        newJoke.setDateOfCreate(new Date());
        newJoke.setDateOfModify(new Date());
        newJoke.setText(update.getMessage().getText().replace("/create ", "").toString());
        newJoke.setId(632L);
        jokeService.saveJoke(newJoke);
    }
}