package ru.scherin.MyFirstIronSon.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.scherin.MyFirstIronSon.service.SendBotMessageService;

import static ru.scherin.MyFirstIronSon.command.CommandName.*;

public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("✨<b>Дотупные команды</b>✨\n\n"

                    + "%s - получить все шутки\n"
                    + "%s id - получить шутку по id\n"
                    + "%s id - удалить шутку по id\n"
                    + "%s - добавить новую шутку\n\n"
                    + "%s - получить помощь в работе со мной",
            JOKES.getCommandName(), JOKE.getCommandName(), DELETE.getCommandName(), CREATE.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}