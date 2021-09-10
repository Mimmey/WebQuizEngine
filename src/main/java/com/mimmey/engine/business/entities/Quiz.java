package com.mimmey.engine.business.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@Table(name = "quizzes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Title must not be empty")
    private String title;

    @NotBlank(message = "Text must not be empty")
    private String text;

    @NotNull
    @Size(min = 2, message = "Number of options should be equals or more than 2")
    private String[] options;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int[] answer;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Quiz() {
        this.answer = new int[]{};
    }
}
