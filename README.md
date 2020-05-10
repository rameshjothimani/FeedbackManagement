# FeedbackManagement

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



Story 2: As a company administrator, I want to be able to list available feedback, so that I can decide what to do about it.
Acceptance criteria:
When accessing the page, a list appears with all feedback presently persisted. Attributes to show per submission: ID,
Date of submission, Name, Email address, Message.
Notes:
No need for authentication mechanism
