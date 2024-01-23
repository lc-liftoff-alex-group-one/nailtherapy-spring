package com.theone.nailtherapyspring.user;

import com.theone.nailtherapyspring.service.Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Users", description = "User management API endpoints")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Operation(
            summary = "Retrieve all users",
            description = "RResponds with a list of User objects with id, firstName, lastName, emailAddress, and phoneNumber.",
            tags = { "users", "get" }
    )
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(
            summary = "Retrieve an user by id",
            description = "Get an user object by specifying its id.  Responds with a User object with id, firstName, lastName, emailAddress, and phoneNumber.",
            tags = { "users", "get" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = User.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/{id}")
    public ResponseEntity<ResponseEntity<Optional<User>>> getUserById(@PathVariable Integer id) {
        ResponseEntity<Optional<User>> user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Save a new user",
            description = "Save a new user object.  Responds with the new User object with id, firstName, lastName, emailAddress, and phoneNumber.",
            tags = { "users", "post" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = User.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User newUser = userRepository.save(user);
        return ResponseEntity.ok(newUser);
    }

    @Operation(
            summary = "Update a service",
            description = "Update an user object by specifying its id.  Responds with the updated User object with id, firstName, lastName, emailAddress, and phoneNumber.",
            tags = { "users", "put" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = User.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @Operation(
            summary = "Delete an user by id",
            description = "Delete a user object by specifying its id.",
            tags = { "users", "delete" }
    )
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "User id " + id + " deleted";
    }
}
