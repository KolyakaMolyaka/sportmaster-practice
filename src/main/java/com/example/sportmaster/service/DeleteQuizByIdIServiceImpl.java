package com.example.sportmaster.service;

import com.example.sportmaster.service.IDeleteQuizByIdService;

public class DeleteQuizByIdIServiceImpl implements IDeleteQuizByIdService {
    public boolean quizzesQuizIdDelete(Integer quizId) {
        // deleting quiz
        boolean deleteOperation = false;
        if (1 == quizId) deleteOperation = true;
        return deleteOperation;
    }
}
