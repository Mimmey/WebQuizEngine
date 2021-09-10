package com.mimmey.engine.presentation;

import com.mimmey.engine.business.entities.*;
import com.mimmey.engine.business.services.CompletionService;
import com.mimmey.engine.business.services.QuizService;
import com.mimmey.engine.presentation.auxiliaryentities.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.*;
import java.util.*;

@RestController
public class QuizEngineController {

    @Autowired
    QuizService quizService;

    @Autowired
    CompletionService completionService;

    @GetMapping("api/quizzes/{id}")
    public Quiz getQuiz(@PathVariable int id) {
        return quizService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("api/quizzes")
    public Page<Quiz> getAllQuizzes(@RequestParam(defaultValue = "0") Integer page,
                                    @RequestParam(defaultValue = "10") Integer pageSize) {
        return quizService.getAllQuizzes(page, pageSize);
    }

    @PostMapping("api/quizzes")
    public Quiz createQuiz(@Valid @RequestBody Quiz quiz, @AuthenticationPrincipal User user) {
        quiz.setUser(user);
        return quizService.save(quiz);
    }

    @PostMapping("api/quizzes/{id}/solve")
    public Response solveQuiz(@PathVariable int id, @RequestBody Answer answer, @AuthenticationPrincipal User user) {
        Optional<Quiz> optionalQuiz = quizService.findById(id);

        if (optionalQuiz.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (Arrays.equals(optionalQuiz.get().getAnswer(), answer.getAnswer())) {
            completionService.save(new Completion(user, id));
            return new Response(true);
        }

        return new Response(false);
    }

    @DeleteMapping("api/quizzes/{id}")
    public ResponseEntity<?> deleteQuiz(@PathVariable Integer id, @AuthenticationPrincipal User user) {
        Quiz quiz = quizService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (quiz.getUser().getId() == user.getId()) {
            quizService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
