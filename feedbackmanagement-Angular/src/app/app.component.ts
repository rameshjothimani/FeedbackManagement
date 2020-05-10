import { Component, OnInit } from '@angular/core';
import { Feedback } from './common/feedback';
import { FeedbackService } from './sevices/feedback.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'angular-feedback';
  feedbacks : Feedback[] = [];
  
  ngOnInit(){
    this.listFeedbacks();

    this.feedbackservice.getFeedbacks().subscribe({
      //this.products refers to the class variable and not the local variable if used in below fashion
     next : feedbacks => {
       this.feedbacks = feedbacks;       
     },     
    });

  }
  constructor(private feedbackservice : FeedbackService){}

  listFeedbacks(){
    this.feedbackservice.getFeedbacks().subscribe;
    data => {
      console.log(data);
    }
  }
}
