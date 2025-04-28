package ru.scherin.MyFirstIronSon.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createdJoke(@RequestBody Joke joke){
        jokeService.saveJoke(joke);
        return ResponseEntity.status(HttpStatus.CREATED).body("Анекдот создан");
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public ResponseEntity<List<Joke>> getAllJoke(){
        return ResponseEntity.ok(jokeService.getAllJoke());
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public ResponseEntity<String> editJokes(
            @PathVariable("id") Long id,
            @RequestBody Joke joke) {
        jokeService.editJokeById(id, joke.getText());
        return ResponseEntity.ok("Анекдот отредактирован");
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Joke getJokeById(@PathVariable Long id){
        return jokeService.getJokeById(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJokeById(@PathVariable Long id){
        jokeService.deleteJokeById(id);
        return ResponseEntity.ok("Анекдот удален");
    }
}
