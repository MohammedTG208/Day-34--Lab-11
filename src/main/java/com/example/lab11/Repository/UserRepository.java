package com.example.lab11.Repository;

import com.example.lab11.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUserid(Integer id);
    //get the user by email
    @Query("select user from User user where user.email=?1")
    User getUserByEmail(String email);
    //get user by date grate then date or equal
    @Query("select user from User user where user.registrationdate>=?1")
    List<User> findUserByRegistrationdateGreaterThanEqual(String registrationdate);
}
