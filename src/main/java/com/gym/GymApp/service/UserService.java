package com.gym.GymApp.service;

import com.gym.GymApp.model.Role;
import com.gym.GymApp.model.User;

import java.util.List;

public interface UserService {
    User getUser(String email);

    List<User> getUsers(Integer pageNo, Integer pageSize, String sortBy);

    User saveUser(User user);

    User updateUser(User user);

    void addRoleToUser(String email, String roleName);

    void deleteRoleToUser(String email, String roleName);

    void deleteById(Long id);

    Role saveRole(Role role);

    List<Role> getRoles();

    void deleteRole(Role role);
}
