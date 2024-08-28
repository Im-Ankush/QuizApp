package com.pr.QuizApp.Controller;


import com.pr.QuizApp.Model.Question;
import com.pr.QuizApp.Model.QuestionWrapper;
import com.pr.QuizApp.Model.Response;
import com.pr.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    private Integer id;
    private List<Response> responses;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,
                                             @RequestParam int numQ ,@RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>>getQuizById(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public  ResponseEntity<Integer>submitQuiz(@RequestBody List<Response> responses ,
                                              @PathVariable Integer id){
        return quizService.calculateResult(id,responses);
    }

}
