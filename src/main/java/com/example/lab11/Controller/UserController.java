package com.example.lab11.Controller;

import com.example.lab11.Model.User;
import com.example.lab11.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/getall")
    public ResponseEntity getAlluser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/get/by/{id}")//3
    public ResponseEntity getuserbyid(@PathVariable Integer id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/add")
    public ResponseEntity adduser(@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }else {
            userService.addNewUser(user);
            return ResponseEntity.status(201).body("user added successfully");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteuser(@PathVariable Integer id){
        userService.deleteUserById(id);
        return ResponseEntity.status(200).body("user deleted successfully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateuser(@PathVariable Integer id, @Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }else {
            userService.updateUser(user, id);
            return ResponseEntity.status(201).body("user updated successfully");
        }
    }

    @GetMapping("/get/by/date/{registration_date}")//2
    public ResponseEntity getUserGrateThanDate(@PathVariable String registration_date){
        return ResponseEntity.status(200).body(userService.getUsersByRegistrationDate(registration_date));
    }

    @GetMapping("/get/by/email/{email}")//1
    public ResponseEntity getUserByEmail(@PathVariable String email){
        return ResponseEntity.status(200).body(userService.getUserByEmail(email));
    }
}
