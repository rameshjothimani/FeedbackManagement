package com.codingchallenge.feedbackapp.response;

import com.codingchallenge.feedbackapp.model.FeedbackModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeedbackResponse {

    @JsonProperty("status")
    private String responseMessage;

    @JsonProperty("feedbacks")
    private List<FeedbackModel> feedbackModelList;

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
