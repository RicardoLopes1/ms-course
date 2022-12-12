package br.com.rlopes.hruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rlopes.hruser.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
