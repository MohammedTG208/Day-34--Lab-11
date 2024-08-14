package com.example.lab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer comment_id;
    @NotNull(message = "user id can not be null")
    @Positive(message = "Enter positive numbers only for user id try again")
    @Column(columnDefinition = "int not null")
    private int user_id;
    @NotNull(message = "post id can not be null")
    @Positive(message = "Enter positive numbers only for post id try again")
    @Column(columnDefinition = "int not null")
    private int post_id;
    @NotNull(message = "content can not be null")
    @Size(min = 5,max = 200,message = "content min 5 and max 200 chars")
    @Column(columnDefinition = "varchar(200) not null")
    private String content;
}
