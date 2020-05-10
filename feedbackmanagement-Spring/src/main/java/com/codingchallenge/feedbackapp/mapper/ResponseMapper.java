package com.codingchallenge.feedbackapp.mapper;

import com.codingchallenge.feedbackapp.model.FeedbackModel;
import com.codingchallenge.feedbackapp.response.FeedbackResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseMapper {

    public FeedbackResponse mapSuccessfulInsertResponse() {
        FeedbackResponse feedbackResponse = new FeedbackResponse();
        feedbackResponse.setResponseMessage("Insert Successful !");
        return feedbackResponse;
    }

    public FeedbackResponse mapDbObjectToResponse(List<FeedbackModel> feedbackModelList) {
        FeedbackResponse feedbackResponse = new FeedbackResponse();
        feedbackResponse.setResponseMessage("OK");
        feedbackResponse.setFeedbackModelList(feedbackModelList);

        return feedbackResponse;
    }
}
