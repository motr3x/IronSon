package ru.scherin.MyFirstIronSon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.scherin.MyFirstIronSon.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
