package com.mimmey.engine.business.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
public class Completion {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "quiz_id")
    @NotNull
    private Integer quizId;

    @Column(name = "completed_at")
    @NotNull
    private Timestamp completedAt;

    public Completion(User user, int quizId) {
        this.user = user;
        this.quizId = quizId;
        this.completedAt = new Timestamp(System.currentTimeMillis());
    }
}
