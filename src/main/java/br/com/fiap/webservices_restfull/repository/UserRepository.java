package br.com.fiap.webservices_restfull.repository;

import br.com.fiap.webservices_restfull.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

    User findByUserId(int userId);

    List<User> listAllUsers();

    User save(User user);

    User update(User user);

    void remove(int userId);

}
