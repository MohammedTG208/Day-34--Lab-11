package com.example.lab11.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
//    post_id
//• category_id
//• title
//• content
//• user_id
//• publish_date
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "category id can not be null")
    @Column(columnDefinition = "varchar(100) not null")
    private int categoryid;
    @NotNull(message = "title cannot be null")
    @Size(min = 5,max = 45, message = "max size for title is 45 and min is 5 try again")
    @Column(columnDefinition = "varchar(45) not null")
    private String title;
    @NotNull(message = "content can not be null")
    @Size(min = 5,max = 200,message = "content max 200 and min 5 chares")
    @Column(columnDefinition = "varchar(200) not null")
    private String content;
    @NotNull(message = "user id can not be null")
    @Positive(message = "Enter positive numbers only try again")
    @Column(columnDefinition = "int not null")
    private int user_id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date default(CURRENT_TIMESTAMP) not null")
    private String postdate;
}
