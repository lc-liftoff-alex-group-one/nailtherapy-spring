package com.theone.nailtherapyspring.user;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User newUser = userRepository.save(user);
        return ResponseEntity.ok(newUser);
    }

    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok((List<User>) userRepository.findAll());
    }

    public ResponseEntity<Optional<User>> getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<User> updateUser(Integer id, User updatedUser) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException((String.valueOf(id))));
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmailAddress(updatedUser.getEmailAddress());
        user.setPhoneNumber(updatedUser.getPhoneNumber());

        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    public ResponseEntity<String> deleteUser(Integer id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok("User deleted");
    }
}
