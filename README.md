# FeedbackManagement

The screenshots of the application is available at https://github.com/rameshjothimani/FeedbackManagement/blob/master/Customer%20Feedback%20Management%20_%20Scenarios_Screens.doc

Story 1: As any user, I want to be able to send feedback via an online form, so that my opinion is taken into account.
Acceptance criteria:
When accessing the page, a form with 3 fields appears: Name (optional), Email address (optional), Message
(mandatory).
When sucessfully submitting the form using the submit button, the system shall display a message informing of success.



--- Changes Done ---
--------------

Front End :
-----------

1. Developed a static html page which will accept the Name (optional), Email address (optional), Message (mandatory). 
   The data is converted into JSON during the form submit for the ease and then sent to the REST API to be processed

2. The service call is made by means of AJAX POST

3. The html page is designed with CSS. 

4. The Feedback page is made available in the default root URL on deployment of application (like it can be accessed with http://localhost:8080)

5. Any possible unexpected error with the unavailable resource will be redirected to 404 page which is designed and available in /resources/public/error/404.html
   and the associated image is available in /resources/public/images

6. The Corresponding CSS & JS files are available for the feedback screen is available in /resources/static/css & /resources/static/js


Back End :
----------

1. For Feedback Screen : Created a Controller (HomePageController.java) which has mapping for context root. This will return the index page whenever the user 
   tries to access the context root like http://localhost:8080

2. For Inserting Feedback : Developed a HTTP POST REST API /postfeedback/ which would expect the feedback object as a collection like below,

   {
    "name": "Ramesh",
    "email": "ramesh@test.com",
    "message": "This is a Test Feedback from screen"
   }


   name : Optional
   email : Optional
   message : mandatory

   Method : HTTP POST
   Content-Type : application/json

   E.g of API URL : http://localhost:8080/postfeedback/

3. The request will be checked if the message attribute is empty or not. If empty, HTTP 500 would be returned. (Ideally it should be HTTP
   400 - Bad request in normal cases)
   
4. If the request is valid & the insert is successful in DB, an ACK JSON like below is returned with HTTP 201 - Created 

    {
     "status": "Insert Successful !"
    }


5. For all other error cases, HTTP 500 would be returned in the response

_______________________________________________________________________________________________________________________________________
_______________________________________________________________________________________________________________________________________

Story 2: As a company administrator, I want to be able to list available feedback, so that I can decide what to do about it.
Acceptance criteria:
When accessing the page, a list appears with all feedback presently persisted. Attributes to show per submission: ID,
Date of submission, Name, Email address, Message.
Notes:
No need for authentication mechanism

--- Changes Done ---
--------------

Front End :
-----------

1. An Angular Front End application is developed, which would be used for management of Feedback which exists in the Database

2. The application calls the HTTP GET REST API - /getfeedback/ exposed in backend. The typical URL will be like        http://localhost:8080/getfeedback/

3. The Service in Angular application receives the response from REST API & maps it to the corresponding elements to display in HTML Page (in tabular format)

4. The GET request has no parameters to be passed

5. The Angular application can be deployed seperately in a Web Server

6. The application can be accessed normally through default URL http://localhost:4200/

Back End :
----------

1. Developed a HTTP GET API /getfeedback/ which would return the list of feedbacks available in the Database. The response would be like below,

    {
     "status": "OK",
     "feedbacks":[
        {
         "feedbackId": 1,
         "name": "Ramesh",
         "email": "ramesh@test.com",
         "message": "This is a Test Feedback from screen",
         "submissionDate": "2020-05-10"
       }
      ]
    }
    
2. The feedbacks would be returned as a List in the GET Response with HTTP 200 - OK.

3. If there are no feedbacks available in Database HTTP 204 - No Conent would be returned .

4. If there are any other possible errors , HTTP 500 - Internal Server Error would be returned.



Database :
----------

1. For this application H2 in-memory databse has been used to accelerate the development.

2. The contents of the db would be lost once the server is stopped

3. The DB can be accessed through URL , http://localhost:8080/h2-console/ once the SpringBoot application is launched.

4. The default password to login to database is password. The details are available in application.properties in resources folder.

Note : H2 In-memory DB is used temporarily & would not be used in a normal scenario


_______________________________________________________________________________________________________________________________________


Assumptions :
------------

1. The application is expected to do a basic CRUD

2. Micro-service approach has not been implemented, assuming that application doesn't need to have very high availability

3. Angular could be used to develop both customer feedback & management screens


_______________________________________________________________________________________________________________________________________

Potential Improvements :
------------------------

Short Term :
------------

1. Angular could be used for both Customer Feedback & Customer Feedback Management applications. If required it can be split as two different applications.

2. Add Unit tests for Front End

3. Document the REST APIs with Swagger / Open API Specification

4. Add necessary Unit tests for Back End

5. Add Custom Error Handling

6. Do not catch Generic Exception


Medium Term :
------------

1. Add Logging Framework to log to the right log files with right log level

2. Add a Unique ID like UUID in every log entry. This will help to differentiate between two different hits / users

3. Read the error messages from property file instead of hard coding or having it in java files itself

4. Implement a Data Layer

5. Connect to a real DB instead of in-memory DB

6. Integrate code quality & security scans



Long Term :
------------

1. Code review

2. Thorogh Scan of code for potential security vulnerability

3. More unit tests to cover all possible cases
