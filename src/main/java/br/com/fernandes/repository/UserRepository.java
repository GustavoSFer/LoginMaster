package br.com.fernandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fernandes.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
