package br.com.fiap.webservices_restfull.controller;

import br.com.fiap.webservices_restfull.entity.User;
import br.com.fiap.webservices_restfull.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("{userName}")
    public User findByUserName(@PathVariable String userName) {
        return userRepository.findByUserName(userName);
    }

    @GetMapping("{userId}")
    public User findByUserId(@PathVariable int userId) {
        return userRepository.findByUserId(userId);
    }

    @GetMapping
    public List<User> list() {
        return userRepository.listAllUsers();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("{userName}, {userPassword}, {userPhone}, {userEmail}")
    public User update(
            @RequestBody User user,
            @PathVariable String userName,
            @PathVariable String userPassword,
            @PathVariable String userPhone,
            @PathVariable String userEmail) {
        user.setUserName(userName);
        user.setUserName(userPassword);
        user.setUserName(userPhone);
        user.setUserName(userEmail);
        return userRepository.update(user);
    }

    @DeleteMapping("{userId}")
    public void remove(@PathVariable int userId) {
        userRepository.remove(userId);
    }

}
