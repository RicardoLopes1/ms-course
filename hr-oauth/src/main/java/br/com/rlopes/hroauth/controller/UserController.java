package br.com.rlopes.hroauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rlopes.hroauth.entity.User;
import br.com.rlopes.hroauth.service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    @GetMapping(value="/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        try {
            var user = userService.findByEmail(email);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
