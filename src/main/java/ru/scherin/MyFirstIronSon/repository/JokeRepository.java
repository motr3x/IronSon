package ru.scherin.MyFirstIronSon.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import ru.scherin.MyFirstIronSon.entity.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JokeRepository extends JpaRepository<Joke, Long> {
    void removeById(Long id);

    @Query(value = "SELECT j FROM Joke j LEFT JOIN JokeCall c ON j.id = c.joke.id " +
            "GROUP BY j.id ORDER BY COUNT(c) DESC")
    Page<Joke> findTopPopularJokes(Pageable pageable);
    @Query("SELECT j FROM Joke j LEFT JOIN j.calls c " +
            "GROUP BY j " +
            "ORDER BY COUNT(c) DESC, j.dateOfCreate DESC " +
            "LIMIT 1")
    Optional<Joke> findMostPopularJoke();
    @Query(value = "SELECT * FROM joke ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Joke> findRandomJoke();
}
