package org.mma.training.java.springboot.docker.repository;

import org.mma.training.java.springboot.docker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
