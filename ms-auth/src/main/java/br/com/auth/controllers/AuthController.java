package br.com.auth.controllers;

import br.com.auth.dtos.UserRequest;
import br.com.auth.entities.User;
import br.com.auth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService service;

    @PostMapping("/sign-in")
    public ResponseEntity<User> create(@RequestBody UserRequest request){
        User user = service.create(request);

        return ResponseEntity.created(null).body(user);
    }

}
