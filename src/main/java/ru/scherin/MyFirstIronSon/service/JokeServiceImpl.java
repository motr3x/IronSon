package ru.scherin.MyFirstIronSon.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.scherin.MyFirstIronSon.DTO.JokeDto;
import ru.scherin.MyFirstIronSon.entity.Joke;
import org.springframework.stereotype.Service;
import ru.scherin.MyFirstIronSon.entity.JokeCall;
import ru.scherin.MyFirstIronSon.exception.JokeNotFoundException;
import ru.scherin.MyFirstIronSon.repository.JokeCallRepository;
import ru.scherin.MyFirstIronSon.repository.JokeRepository;
import ru.scherin.MyFirstIronSon.config.JokeMapper;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JokeServiceImpl implements JokeService{
    private final JokeRepository jokeRepository;
    private final JokeMapper jokeMapper;
    private final JokeCallRepository jokeCallRepository;

    public JokeServiceImpl(JokeRepository jokeRepository, JokeMapper jokeMapper, JokeCallRepository jokeCallRepository) {
        this.jokeRepository = jokeRepository;
        this.jokeMapper = jokeMapper;
        this.jokeCallRepository = jokeCallRepository;
    }
    public String getJokeStatistics() {
        long totalJokes = jokeRepository.count();
        long totalCalls = jokeCallRepository.count();
        String mostPopularJoke = jokeRepository.findMostPopularJoke()
                .map(j -> String.format("\"%s\" - %d вызовов", j.getText(), j.getCalls().size()))
                .orElse("Нет данных");

        return String.format(
                "📊 Статистика:\n\n" +
                        "• Всего анекдотов: %d\n" +
                        "• Всего вызовов: %d\n" +
                        "• Самый популярный: %s",
                totalJokes, totalCalls, mostPopularJoke
        );
    }
    public List<JokeDto> getTop5PopularJokes() {
        return jokeRepository.findTopPopularJokes(PageRequest.of(0, 5))
                .getContent()
                .stream()
                .map(jokeMapper::toDto)
                .collect(Collectors.toList());
    }
    private void logJokeCall(Long jokeId, Long userId) {
        JokeCall call = new JokeCall();
        call.setCallTime(LocalDateTime.now());
        call.setUserId(userId);
        call.setJoke(jokeRepository.getReferenceById(jokeId));
        jokeCallRepository.save(call);
    }
    @Transactional
    public JokeDto getRandomJoke(Long userId) {
        Joke joke = jokeRepository.findRandomJoke()
                .orElseThrow(() -> new EntityNotFoundException("No jokes available"));

        logJokeCall(joke.getId(), userId);
        return jokeMapper.toDto(joke);
    }
    public Page<JokeDto> getAllJokes(Pageable pageable) {
        return jokeRepository.findAll(pageable)
                .map(jokeMapper::toDto);
    }
    @Transactional
    public void saveJoke(Joke newJoke){
        jokeRepository.save(newJoke);
    }
    public JokeDto getJokeById(Long id) {
        Joke joke = jokeRepository.findById(id).orElseThrow();
        return convertToJokeDto(joke);
    }
    public JokeDto convertToJokeDto(Joke joke) {
        JokeDto jokeDto = new JokeDto();
        jokeDto.setText(joke.getText());
        jokeDto.setAuthor(joke.getAuthor());
        return jokeDto;
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
