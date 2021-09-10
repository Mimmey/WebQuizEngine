package com.mimmey.engine.business.services;

import com.mimmey.engine.business.entities.Quiz;
import com.mimmey.engine.persistence.QuizRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public void deleteById(Integer id) {
        this.quizRepository.deleteById(id);
    }

    public Page<Quiz> getAllQuizzes(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return quizRepository.findAll(paging);
    }

    public Optional<Quiz> findById(Integer id) {
        return this.quizRepository.findById(id);
    }

    public Quiz save(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }
}
