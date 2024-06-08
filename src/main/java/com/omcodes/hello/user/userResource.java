package com.omcodes.hello.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class userResource {

    @Autowired
    private userDaoServices services;

    @GetMapping("/user")
    public List<User> retrieveAllUsers() {
        return services.findAll();
    }

    @GetMapping("/user/{id}")
    public User getMethodName(@PathVariable int id) {
        User user = services.find(id);
        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }
        return user;
    }

    @PostMapping(value = "/user", consumes = "application/json")
    public ResponseEntity<Object> postMethodName(@RequestBody User us) {
        User saved = services.save(us);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping("/user/{id}")
    public void deleteMethodName(@PathVariable int id) {
        User user = services.deleteUserById(id);
        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }
    }

}
