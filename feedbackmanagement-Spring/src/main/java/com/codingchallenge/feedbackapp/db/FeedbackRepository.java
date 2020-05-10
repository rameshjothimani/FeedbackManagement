package com.codingchallenge.feedbackapp.db;

import com.codingchallenge.feedbackapp.model.FeedbackModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<FeedbackModel,String> {


}
