package ru.scherin.MyFirstIronSon.service;

import ru.scherin.MyFirstIronSon.entity.Joke;
import org.springframework.stereotype.Service;
import ru.scherin.MyFirstIronSon.exception.JokeNotFoundException;
import ru.scherin.MyFirstIronSon.repository.JokeRepository;

import javax.transaction.Transactional;
import java.util.Date;
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
    public Joke getJokeById(Long id) {
        return jokeRepository.findById(id).orElseThrow(() -> new JokeNotFoundException("Анекдот с "+id+" не найден"));
    }

    @Transactional
    @Override
    public void deleteJokeById(Long id) {
        if (!jokeRepository.existsById(id)) {
            throw new JokeNotFoundException("Анекдот с "+id+" не найден");
        }
        jokeRepository.deleteById(id);
    }
    @Transactional
    public void editJokeById(Long id, String text) {
        Joke joke = jokeRepository.findById(id).orElseThrow(() -> new JokeNotFoundException("Анекдот с "+id+" не найден"));
        joke.setText(text);
        joke.setDateOfModify(new Date());
        jokeRepository.save(joke);
    }
}
