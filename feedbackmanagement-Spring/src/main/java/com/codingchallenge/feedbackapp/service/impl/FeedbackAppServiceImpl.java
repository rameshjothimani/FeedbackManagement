package com.codingchallenge.feedbackapp.service.impl;

import com.codingchallenge.feedbackapp.db.FeedbackRepository;
import com.codingchallenge.feedbackapp.mapper.RequestMapper;
import com.codingchallenge.feedbackapp.mapper.ResponseMapper;
import com.codingchallenge.feedbackapp.model.FeedbackModel;
import com.codingchallenge.feedbackapp.request.FeedbackRequest;
import com.codingchallenge.feedbackapp.response.FeedbackResponse;
import com.codingchallenge.feedbackapp.service.FeedbackAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FeedbackAppServiceImpl implements FeedbackAppService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private RequestMapper requestMapper;

    @Autowired
    private ResponseMapper responseMapper;

    List<FeedbackRequest> responseList = new ArrayList<>(Arrays.asList(
            new FeedbackRequest("Ramesh", "100", "TestFeedback"),
            new FeedbackRequest("Arun", "200", "Arun - TestFeedback")));

    @Override
    public FeedbackResponse getFeedBack() {
        List<FeedbackModel> feedbackModelList = new ArrayList<>();
        feedbackRepository.findAll()
                .forEach(feedbackModelList::add);

        return responseMapper.mapDbObjectToResponse(feedbackModelList);
    }

    @Override
    public FeedbackRequest filterFeedBackByName(String name) {
        return responseList.stream().filter(t -> t.getName().equals(name)).findFirst().get();
    }

    @Override
    public FeedbackResponse saveFeedback(FeedbackRequest feedbackRequest) {
        feedbackRepository.save(requestMapper.mapRequestToDbObject(feedbackRequest));
        return responseMapper.mapSuccessfulInsertResponse();
    }

}
