package com.codingchallenge.feedbackapp.mapper;

import com.codingchallenge.feedbackapp.model.FeedbackModel;
import com.codingchallenge.feedbackapp.response.FeedbackResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * Created by Ramesh Jothimani on 09/05/2020
 *
 * */

@Component
public class ResponseMapper {

    //Return a default successful ACK message if requested operation is OK
    public FeedbackResponse mapSuccessfulInsertResponse() {
        FeedbackResponse feedbackResponse = new FeedbackResponse();
        feedbackResponse.setResponseMessage("Insert Successful !");
        return feedbackResponse;
    }

    //Map the feedbacks from DB to the Response Object
    public FeedbackResponse mapDbObjectToResponse(List<FeedbackModel> feedbackModelList) {
        FeedbackResponse feedbackResponse = new FeedbackResponse();
        feedbackResponse.setResponseMessage("OK");
        feedbackResponse.setFeedbackModelList(feedbackModelList);
        return feedbackResponse;
    }
}
