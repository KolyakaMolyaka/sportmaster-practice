package com.example.sportmaster;

import com.example.sportmaster.openapi.model.QuizDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizzesService implements IQuizzesService {
    @Autowired
    private IQuizzesRepository quizzesRepository;
    @Override
    public List<QuizDTO> findAllQuizzes() {
        return quizzesRepository.findAll();
    }
}
