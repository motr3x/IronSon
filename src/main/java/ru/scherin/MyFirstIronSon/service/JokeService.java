package ru.scherin.MyFirstIronSon.service;

import ru.scherin.MyFirstIronSon.DTO.JokeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JokeService {
    List<JokeDto> getAllJoke();
    JokeDto getJokeById(Long id);
    void deleteJokeById(Long id);
    void editJokeById(Long id, String text);
}
