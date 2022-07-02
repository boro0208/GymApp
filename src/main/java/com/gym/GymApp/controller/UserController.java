package com.gym.GymApp.controller;

import com.gym.GymApp.model.User;
import com.gym.GymApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping(path = "/user/all")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = repository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Long id) {
        Optional<User> user = repository.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(path = "/user/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        User oldUser = repository.findByEmail(user.getEmail());
        if (oldUser != null) {
            return new ResponseEntity<>("There is already a user registered with the email provided!", HttpStatus.CONFLICT);
        } else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            repository.save(user);
            return new ResponseEntity<>("User created successfully!", HttpStatus.OK);
        }
    }

    @PutMapping(path = "/user/update")
    public ResponseEntity<Optional<User>> updateInvoice(@RequestBody User u) {
        Optional<User> updatedUser = repository.findById(u.getId()).map(user -> {
            user.setName(u.getName());
            user.setSurname(u.getSurname());
            user.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
            user.setEmail(u.getEmail());
            user.setMobilePhone(u.getMobilePhone());
            user.setAddress(u.getAddress());
            user.setCity(u.getCity());
            user.setZip(u.getZip());
            user.setGender(u.getGender());
            user.setStatus(u.getStatus());
            user.setDateOfBirth(u.getDateOfBirth());
            user.setCreationDate(u.getCreationDate());
            user.setLoyCard(u.getLoyCard());
            user.setUserCreated(u.getUserCreated());
            return repository.save(user);
        });

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

//    I saw two ways for update and I commented less correct way - this is only my opinion
//    @PutMapping(path = "/user/update/{id}")
//    public ResponseEntity<Optional<User>> updateInvoice(@RequestBody User u, @PathVariable  Long id) {
//        Optional<User> updatedUser = repository.findById(id).map(user -> {
//            user.setName(u.getName());
//            user.setSurname(u.getSurname());
//            user.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
//            user.setEmail(u.getEmail());
//            user.setMobilePhone(u.getMobilePhone());
//            user.setAddress(u.getAddress());
//            user.setCity(u.getCity());
//            user.setZip(u.getZip());
//            user.setGender(u.getGender());
//            user.setStatus(u.getStatus());
//            user.setDateOfBirth(u.getDateOfBirth());
//            user.setCreationDate(u.getCreationDate());
//            user.setLoyCard(u.getLoyCard());
//            user.setUserCreated(u.getUserCreated());
//            return repository.save(user);
//        });
//
//        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//    }

    @DeleteMapping(path = "/admin/user/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody User u) {
        User user = repository.findByEmail(u.getEmail());
        if (user == null) {
            return new ResponseEntity<>("Check your login details!", HttpStatus.UNAUTHORIZED);
        } else {
            if (!bCryptPasswordEncoder.matches(u.getPassword(), user.getPassword())) {
                return new ResponseEntity<>("Check your login details!", HttpStatus.UNAUTHORIZED);
            } else {
                return new ResponseEntity<>("Login successful!", HttpStatus.OK);
            }
        }
    }

}
