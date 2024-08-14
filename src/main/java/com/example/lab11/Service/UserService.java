package com.example.lab11.Service;

import com.example.lab11.Api.APiException;
import com.example.lab11.Model.User;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public List<User> getAllUser(){
        if(userRepository.findAll().isEmpty()){
            throw new APiException("the DB is empty");
        }
        return userRepository.findAll();
    }

    public void addNewUser(User user){
        userRepository.save(user);
    }

    public User getUserById(Integer id){
        if (userRepository.findUserByUserid(id)==null){
            throw new APiException("user not found");
        }
        return userRepository.findUserByUserid(id);
    }

    public void deleteUserById(Integer id){
        if (userRepository.findUserByUserid(id)==null){
            throw new APiException("user not found");
        }
        userRepository.deleteById(id);
    }

    public User getUserByEmail(String email){
        if (userRepository.getUserByEmail(email)==null){
            throw new APiException("user not found");
        }
        return userRepository.getUserByEmail(email);
    }

    public void updateUser(User user,Integer id){
        if (userRepository.findUserByUserid(id)==null){
            throw new APiException("user not found");
        }else {
            User oldUser = userRepository.findUserByUserid(id);
            oldUser.setEmail(user.getEmail());
            oldUser.setPassword(user.getPassword());
            oldUser.setUsername(user.getUsername());
            userRepository.save(oldUser);
        }
    }

    public List<User> getUsersByRegistrationDate(String regesterDate){
        if (userRepository.findUserByRegistrationdateGreaterThanEqual(regesterDate)==null){
            throw new APiException("user not found");
        }
        return userRepository.findUserByRegistrationdateGreaterThanEqual(regesterDate);
    }
}
