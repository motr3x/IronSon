package ru.scherin.MyFirstIronSon.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.scherin.MyFirstIronSon.entity.RoleType;
import ru.scherin.MyFirstIronSon.entity.User;
import ru.scherin.MyFirstIronSon.repository.RoleRepository;
import ru.scherin.MyFirstIronSon.repository.UserRepository;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String username, String password, RoleType roleType) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(roleRepository.findByName(roleType)
                .orElseThrow(() -> new EntityNotFoundException("Role not found")));
        return userRepository.save(user);
    }

    public User changeUserRole(Long userId, RoleType newRoleType) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setRole(roleRepository.findByName(newRoleType)
                .orElseThrow(() -> new EntityNotFoundException("Role not found")));
        return userRepository.save(user);
    }
}