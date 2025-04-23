package controller;

import entity.Joke;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import service.JokeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/joke")
public class JokeController {
    private final JokeServiceImpl jokeService;

    public JokeController(JokeServiceImpl jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping()
    public List<Joke> getAllJoke(){
        return jokeService.getAllJoke();
    }

    @GetMapping("/{id}")
    public Joke getJokeById(@PathVariable Long id){
        return jokeService.getJokeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteJokeById(@PathVariable Long id){
        jokeService.deleteJokeById(id);
    }
}
