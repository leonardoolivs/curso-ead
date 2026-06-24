package br.com.auth.controllers;

import br.com.auth.dtos.UpdatePasswordRequest;
import br.com.auth.entities.User;
import br.com.auth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody User user){
        user = service.update(id, user);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<String> updatePassword(@PathVariable("id") Long id, @RequestBody UpdatePasswordRequest password){

        service.updatePassword(id, password);
        return ResponseEntity.ok("Password updated");
    }
}
