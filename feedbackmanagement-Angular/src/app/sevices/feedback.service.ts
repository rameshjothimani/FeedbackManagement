import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Feedback } from '../common/feedback';

import { catchError, tap, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

 //private productUrl='http://localhost:8080/getfeedback/';
 private productUrl='assets/feedbacks.json';

  constructor(private http: HttpClient){}

  getFeedbacks(): Observable<Feedback[]> {
    return this.http.get<Feedback[]>(this.productUrl)
      .pipe(
        tap(data => console.log('All: ' + JSON.stringify(data))),
        catchError(this.handleError)
      );
  }


  private handleError(err: HttpErrorResponse) {    
    let errorMessage = '';
    if (err.error instanceof ErrorEvent) {      
      errorMessage = `An error occurred: ${err.error.message}`;
    } else {      
      errorMessage = `Server returned code: ${err.status}, error message is: ${err.message}`;
    }
    console.error(errorMessage);
    return throwError(errorMessage);
  }
}

interface GetFeedbackResponse{
  feedbackList : {
    feedbacks : Feedback[];
  }
}
