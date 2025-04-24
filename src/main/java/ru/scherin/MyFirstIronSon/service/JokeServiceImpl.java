package ru.scherin.MyFirstIronSon.service;

import ru.scherin.MyFirstIronSon.entity.Joke;
import org.springframework.stereotype.Service;
import ru.scherin.MyFirstIronSon.repository.JokeRepository;

import javax.transaction.Transactional;
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
    @Transactional
    public void saveJoke(Joke newJoke){
        jokeRepository.save(newJoke);
    }
    @Override
    public Joke getJokeById(Long id) {
        return jokeRepository.getJokeById(id);
    }
    @Transactional
    @Override
    public void deleteJokeById(Long id) {
        jokeRepository.deleteJokeById(id);
    }
}
