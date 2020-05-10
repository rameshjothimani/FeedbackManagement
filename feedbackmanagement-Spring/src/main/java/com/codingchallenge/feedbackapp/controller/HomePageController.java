package com.codingchallenge.feedbackapp.controller;

import com.codingchallenge.feedbackapp.common.CommonConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * Created by Ramesh Jothimani on 10/05/2020
 *
 * */
@Controller
public class HomePageController {
    @GetMapping(CommonConstants.URL_HOMEPAGE)
    //This class loads the index html as default page when app is accessed
    public String index() {
        return "forward:index.html";
    }
}

