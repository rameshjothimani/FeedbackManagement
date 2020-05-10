package com.codingchallenge.feedbackapp.service.impl;

import com.codingchallenge.feedbackapp.db.FeedbackRepository;
import com.codingchallenge.feedbackapp.mapper.RequestMapper;
import com.codingchallenge.feedbackapp.mapper.ResponseMapper;
import com.codingchallenge.feedbackapp.model.FeedbackModel;
import com.codingchallenge.feedbackapp.request.FeedbackRequest;
import com.codingchallenge.feedbackapp.response.FeedbackResponse;
import com.codingchallenge.feedbackapp.service.FeedbackAppService;
import com.codingchallenge.feedbackapp.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/*
 * Created by Ramesh Jothimani on 09/05/2020
 *
 * */
@Service
public class FeedbackAppServiceImpl implements FeedbackAppService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private RequestMapper requestMapper;

    @Autowired
    private ResponseMapper responseMapper;

    @Autowired
    private ValidatorUtil validatorUtil;

    @Override
    public FeedbackResponse getFeedBack() {
        List<FeedbackModel> feedbackModelList = new ArrayList<>();
        feedbackRepository.findAll().forEach(feedbackModelList::add);
        return responseMapper.mapDbObjectToResponse(feedbackModelList);
    }

    @Override
    public FeedbackResponse saveFeedback(FeedbackRequest feedbackRequest) {
        validatorUtil.validateRequest(feedbackRequest);
        feedbackRepository.save(requestMapper.mapRequestToDbObject(feedbackRequest));
        return responseMapper.mapSuccessfulInsertResponse();
    }

}
