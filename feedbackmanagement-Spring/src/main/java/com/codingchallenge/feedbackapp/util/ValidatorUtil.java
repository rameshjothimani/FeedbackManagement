package com.codingchallenge.feedbackapp.util;

import com.codingchallenge.feedbackapp.request.FeedbackRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class ValidatorUtil {

    public void validateRequest(FeedbackRequest feedbackRequest) {
        if (!StringUtils.isNotBlank(feedbackRequest.getMessage())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
