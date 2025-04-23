package repository;

import entity.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokeRepository extends JpaRepository<Joke, Long> {
    Joke getJokeById(Long id);
    void deleteJokeById(Long id);
}
