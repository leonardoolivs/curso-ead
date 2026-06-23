package br.com.auth.entities;

import br.com.auth.entities.enums.UserStatus;
import br.com.auth.entities.enums.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_USER")
public class User {

    private Long userId;
    private String username;
    private String email;
    private String password;
    private String fullName;
    private UserStatus userStatus;
    private UserType userType;
    private String phoneNumber;
    private String cpf;
    private String imageUrl;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;

}
