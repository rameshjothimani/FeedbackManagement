package com.codingchallenge.feedbackapp.mapper;

import com.codingchallenge.feedbackapp.model.FeedbackModel;
import com.codingchallenge.feedbackapp.request.FeedbackRequest;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RequestMapper {

    public FeedbackModel mapRequestToDbObject(FeedbackRequest feedbackRequest) {

        FeedbackModel feedbackModel = new FeedbackModel();
        feedbackModel.setName(feedbackRequest.getName());
        feedbackModel.setEmail(feedbackRequest.getEmail());
        feedbackModel.setMessage(feedbackRequest.getMessage());
        feedbackModel.setSubmissionDate(new Date());

        return feedbackModel;

    }
}
