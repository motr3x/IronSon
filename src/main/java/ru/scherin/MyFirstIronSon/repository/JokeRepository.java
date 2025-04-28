package ru.scherin.MyFirstIronSon.repository;

import ru.scherin.MyFirstIronSon.entity.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokeRepository extends JpaRepository<Joke, Long> {
    void removeById(Long id);
}
