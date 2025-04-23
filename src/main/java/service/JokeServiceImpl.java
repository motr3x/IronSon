package service;

import entity.Joke;
import exception.JokeNotFoundException;
import org.springframework.stereotype.Service;
import repository.JokeRepository;

import java.util.List;

@Service
public class JokeServiceImpl implements JokeService{
    private final JokeRepository jokeRepository;

    public JokeServiceImpl(JokeRepository jokeRepository) {
        this.jokeRepository = jokeRepository;
    }

    @Override
    public List<Joke> getAllJoke() {
        return jokeRepository.findAll();
    }

    @Override
    public Joke getJokeById(Long id) {
        return jokeRepository.getJokeById(id);
    }

    @Override
    public void deleteJokeById(Long id) {
        jokeRepository.deleteJokeById(id);
    }
}
