package ru.scherin.MyFirstIronSon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.scherin.MyFirstIronSon.entity.JokeCall;

public interface JokeCallRepository extends JpaRepository<JokeCall, Long> {
}
