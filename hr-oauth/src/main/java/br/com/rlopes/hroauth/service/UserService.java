package br.com.rlopes.hroauth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.rlopes.hroauth.entity.User;
import br.com.rlopes.hroauth.feignclients.UserFeignClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private UserFeignClient userFeignClient;

    // this is a didactic example, in a real world scenario, you should use loadUserByUsername method
    public User findByEmail(String email) {
        var user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            log.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }

        log.info("Email found: " + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userFeignClient.findByEmail(username).getBody();
        if (user == null) {
            log.error("Email not found: " + username);
            throw new UsernameNotFoundException("Email not found");
        }

        log.info("Email found: " + username);
        return user;
    }
}
