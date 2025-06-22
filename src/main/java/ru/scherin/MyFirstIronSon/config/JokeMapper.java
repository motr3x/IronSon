package ru.scherin.MyFirstIronSon.config;

import org.springframework.stereotype.Component;
import ru.scherin.MyFirstIronSon.DTO.JokeDto;
import ru.scherin.MyFirstIronSon.entity.Joke;

@Component
public class JokeMapper {


    public JokeDto toDto(Joke joke) {
        return new JokeDto(
                joke.getId(),
                joke.getText(),
                joke.getAuthor(),
                joke.getDateOfCreate(),
                joke.getDateOfModify()
        );
    }

    public Joke toEntity(JokeDto jokeDto) {
        Joke joke = new Joke();
        joke.setText(jokeDto.getText());
        joke.setAuthor(jokeDto.getAuthor());
        joke.setDateOfCreate(jokeDto.getDateOfCreate());
        joke.setDateOfModify(jokeDto.getDateOfModify());
        return joke;
    }
}