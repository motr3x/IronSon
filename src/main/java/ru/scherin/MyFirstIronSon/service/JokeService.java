package ru.scherin.MyFirstIronSon.service;

import ru.scherin.MyFirstIronSon.entity.Joke;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JokeService {
    List<Joke> getAllJoke();
    Joke getJokeById(Long id);
    void deleteJokeById(Long id);
    void editJokeById(Long id, String text);
}
