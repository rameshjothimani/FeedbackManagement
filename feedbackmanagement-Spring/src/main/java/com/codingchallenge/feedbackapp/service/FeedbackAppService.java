package com.codingchallenge.feedbackapp.service;

import com.codingchallenge.feedbackapp.request.FeedbackRequest;
import com.codingchallenge.feedbackapp.response.FeedbackResponse;
/*
 * Created by Ramesh Jothimani on 09/05/2020
 *
 * */
public interface FeedbackAppService {
    FeedbackResponse getFeedBack();
    FeedbackResponse saveFeedback(FeedbackRequest feedbackRequest);
}
