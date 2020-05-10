package com.codingchallenge.feedbackapp.response;

import com.codingchallenge.feedbackapp.model.FeedbackModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeedbackResponse {

    private String responseMessage;

    @JsonProperty("feedbackList")
    private List<FeedbackModel> feedbackModelList;

    FeedbackModel[] feedbackModels;

    public FeedbackModel[] getFeedbackModels() {
        return feedbackModels;
    }

    public void setFeedbackModels(FeedbackModel[] feedbackModels) {
        this.feedbackModels = feedbackModels;
    }



    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public List<FeedbackModel> getFeedbackModelList() {
        return feedbackModelList;
    }

    public void setFeedbackModelList(List<FeedbackModel> feedbackModelList) {
        this.feedbackModelList = feedbackModelList;
    }
}
