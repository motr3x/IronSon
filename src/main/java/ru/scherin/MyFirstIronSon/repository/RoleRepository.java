package ru.scherin.MyFirstIronSon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.scherin.MyFirstIronSon.entity.Role;
import ru.scherin.MyFirstIronSon.entity.RoleType;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType name);
}
