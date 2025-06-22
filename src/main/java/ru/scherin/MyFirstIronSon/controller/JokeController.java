package ru.scherin.MyFirstIronSon.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import ru.scherin.MyFirstIronSon.DTO.JokeDto;
import ru.scherin.MyFirstIronSon.entity.Joke;
import org.springframework.web.bind.annotation.*;
import ru.scherin.MyFirstIronSon.service.JokeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/joke")
public class JokeController {
    private final JokeServiceImpl jokeService;

    public JokeController(JokeServiceImpl jokeService) {
        this.jokeService = jokeService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @PreAuthorize("hasAuthority('JOKE_WRITE')")
    public ResponseEntity<String> createJoke(@RequestBody JokeDto jokeDto) {
        Joke joke = new Joke();
        joke.setText(jokeDto.getText());
        joke.setAuthor(jokeDto.getAuthor());
        jokeService.saveJoke(joke);
        return ResponseEntity.status(HttpStatus.CREATED).body("Анекдот создан");
    }

    @GetMapping("/top")
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<JokeDto>> getTopJokes() {
        return ResponseEntity.ok(jokeService.getTop5PopularJokes());
    }

    @GetMapping("/random")
    @PreAuthorize("permitAll()")
    public ResponseEntity<JokeDto> getRandomJoke(
            @RequestParam Long userId) {
        return ResponseEntity.ok(jokeService.getRandomJoke(userId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<Page<JokeDto>> getAllJokes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(jokeService.getAllJokes(PageRequest.of(page, size)));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('JOKE_MODIFY')")
    public ResponseEntity<String> editJokes(
            @PathVariable("id") Long id,
            @RequestBody Joke joke) {
        jokeService.editJokeById(id, joke.getText());
        return ResponseEntity.ok("Анекдот отредактирован");
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")  // Доступно всем
    public JokeDto getJokeById(@PathVariable Long id){
        return jokeService.getJokeById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('JOKE_DELETE')")
    public ResponseEntity<String> deleteJokeById(@PathVariable Long id){
        jokeService.deleteJokeById(id);
        return ResponseEntity.ok("Анекдот удален");
    }
}