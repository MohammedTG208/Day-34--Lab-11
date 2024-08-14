package com.example.lab11.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

//    user_id
//• username
//• password
//• email
//• registration_date
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;
    @NotNull(message = "the user name is requires")
    @Size(max = 20,message = "the max length 20 char")
    @Column(columnDefinition = "varchar(20) not null")
    private String username;
    @Pattern(regexp = "^(.{0,7}|[^0-9]*|[^A-Z]*|[^a-z]*|[a-zA-Z0-9]*)+$", message = "Enter valid Password")
    @Column(columnDefinition = "varchar(30) not null")
    private String password;
    @NotNull(message = "The email is requires")
    @Column(columnDefinition = "varchar(35) not null unique")
    private String email;
    @NotNull(message = "the registration date cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date not null")
    private String registrationdate ;
}
