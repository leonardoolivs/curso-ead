package br.com.auth.entities;

import br.com.auth.entities.enums.UserStatus;
import br.com.auth.entities.enums.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_USER")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "username", unique = true)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank
    @Size(max = 50)
    @Column(name = "password")
    private String password;

    @NotBlank
    @Size(max = 100)
    @Column(name = "full_name")
    private String fullName;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private UserStatus userStatus;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "image_url")
    private String imageUrl;

    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "last_update_date")
    private LocalDateTime lastUpdateDate;

}
