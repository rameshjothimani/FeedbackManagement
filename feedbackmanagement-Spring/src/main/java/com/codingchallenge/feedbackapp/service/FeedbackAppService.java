package com.codingchallenge.feedbackapp.service;

import com.codingchallenge.feedbackapp.request.FeedbackRequest;
import com.codingchallenge.feedbackapp.response.FeedbackResponse;

public interface FeedbackAppService {
    FeedbackResponse getFeedBack();

    FeedbackRequest filterFeedBackByName(String name);

    FeedbackResponse saveFeedback(FeedbackRequest feedbackRequest);
}
