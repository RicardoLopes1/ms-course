package br.com.rlopes.hroauth.service;

import org.springframework.stereotype.Service;

import br.com.rlopes.hroauth.entity.User;
import br.com.rlopes.hroauth.feignclients.UserFeignClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class UserService {

    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        var user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            log.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }

        log.info("Email found: " + email);
        return user;
    }
}
