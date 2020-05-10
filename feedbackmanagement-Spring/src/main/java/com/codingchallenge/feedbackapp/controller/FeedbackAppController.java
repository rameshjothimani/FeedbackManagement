package com.codingchallenge.feedbackapp.controller;

import com.codingchallenge.feedbackapp.request.FeedbackRequest;
import com.codingchallenge.feedbackapp.response.FeedbackResponse;
import com.codingchallenge.feedbackapp.service.FeedbackAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ComponentScan("com.codingchallenge.feedbackapp")
@EntityScan("com.codingchallenge.feedbackapp.model")
@EnableJpaRepositories("com.codingchallenge.feedbackapp.db")
@CrossOrigin
public class FeedbackAppController {

    @Autowired
    private FeedbackAppService feedbackAppService;

    @CrossOrigin
    @GetMapping("/getfeedback")
    public ResponseEntity<FeedbackResponse> getFeedback() {
        FeedbackResponse feedbackResponse = new FeedbackResponse();
        try {
            feedbackResponse = feedbackAppService.getFeedBack();
            if (feedbackResponse.getFeedbackModelList().isEmpty()) {
                return new ResponseEntity<>(feedbackResponse, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(feedbackResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(feedbackResponse, HttpStatus.OK);
    }

    @GetMapping("/feedback/{name}")
    public FeedbackRequest getFeedbackByName(@PathVariable String name) {
        return feedbackAppService.filterFeedBackByName(name);
    }

    @PostMapping("/postfeedback")
    public ResponseEntity<FeedbackResponse> postFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        FeedbackResponse feedbackResponse = new FeedbackResponse();
        try {
            feedbackResponse = feedbackAppService.saveFeedback(feedbackRequest);
        } catch (Exception e) {
            return new ResponseEntity<>(feedbackResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(feedbackResponse, HttpStatus.OK);
    }

}