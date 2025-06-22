package ru.scherin.MyFirstIronSon.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.scherin.MyFirstIronSon.entity.RegistrationRequest;
import ru.scherin.MyFirstIronSon.entity.RoleType;
import ru.scherin.MyFirstIronSon.entity.User;
import ru.scherin.MyFirstIronSon.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegistrationRequest request) {
        return ResponseEntity.ok(userService.registerUser(
                request.getUsername(),
                request.getPassword(),
                RoleType.USER
        ));
    }

    @PreAuthorize("hasAuthority('USER_MANAGE')")
    @PutMapping("/{userId}/role")
    public ResponseEntity<User> changeRole(
            @PathVariable Long userId,
            @RequestParam RoleType newRole) {
        return ResponseEntity.ok(userService.changeUserRole(userId, newRole));
    }
}


