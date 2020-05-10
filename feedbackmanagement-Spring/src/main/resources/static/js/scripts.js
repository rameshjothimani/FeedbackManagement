function validate(){
  
  var name = document.getElementById("name").value; 
  var email = document.getElementById("email").value;
  var message = document.getElementById("message").value;
  var error_message = document.getElementById("error_message");
  
  error_message.style.padding = "10px";
  
  var text;
  if(name.length !=0 && name.length < 5){
    text = "Please Enter valid Name";
    error_message.innerHTML = text;
    return false;
  }
  if(email.length != 0 && (email.indexOf("@") == -1 || email.length < 6)){
    text = "Please Enter valid Email";
    error_message.innerHTML = text;
    return false;
  }
  if(message.length <= 30){
    text = "Message should be a minimum of 30 Characters";
    error_message.innerHTML = text;
    return false;
  }
  var requestData = $('form#feedbackForm').serializeObject();
  submitFeedback(requestData);
  return true;
}

function submitFeedback(requestData) {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
       if (this.readyState == 4 && this.status == 200) {
           text = "Feedback submitted successfully";
           success_message.innerHTML = text;
       } else{
          text = "Technical error occurred";
          error_message.innerHTML = text;
       }
  };
  xhttp.open("POST", "http://localhost:8080/postfeedback/", true);
  xhttp.setRequestHeader("Content-type", "application/json");
  xhttp.send(JSON.stringify(requestData));
}