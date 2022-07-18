package com.gym.GymApp.controller;

import com.gym.GymApp.model.Role;
import com.gym.GymApp.model.RoleToUserForm;
import com.gym.GymApp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final UserService userService;

    public RoleController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return ResponseEntity.ok().body(userService.saveRole(role));
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addRole(@RequestBody RoleToUserForm role) {
        userService.addRoleToUser(role.getEmail(), role.getRoleName());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteRoleToUser(@RequestBody RoleToUserForm role) {
        userService.deleteRoleToUser(role.getEmail(), role.getRoleName());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok().body(userService.getRoles());
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteRole(@RequestBody Role role) {
        userService.deleteRole(role);
        return ResponseEntity.ok().build();
    }

}
