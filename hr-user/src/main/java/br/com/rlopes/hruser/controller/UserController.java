package br.com.rlopes.hruser.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rlopes.hruser.entity.User;
import br.com.rlopes.hruser.exception.NotFoundException;
import br.com.rlopes.hruser.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user = userRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("User not found!"));

        return ResponseEntity.ok(user);
    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        var user = userRepository.findByEmail(email);
        if(user == null) {
            throw new NotFoundException("User not found!");
        }

        return ResponseEntity.ok(user);
    }
}
