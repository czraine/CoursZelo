import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  private baseUrl = 'http://localhost:8099/api/Quiz'; 

  

  constructor(private http: HttpClient) {}

  createQuiz(quizData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/addQuiz`, quizData);
  }

  updateQuiz(quizData: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/UpdateQuiz`, quizData);
  }

  deleteQuiz(quizId: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/Delete/${quizId}`);
  }

  getQuiz(quizId: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/retrieve-all/${quizId}`);
  }

  getQuizzes(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/retrieve-all`);
  }

  addQuestionToQuiz(quizId: string, questionData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/addQuestion/${quizId}`, questionData);
  }
  getQuizById(quizId: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/retrieve/${quizId}`); // Corrected URL path
  }


  submitAttempt(attempt: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/submitAttempt`, attempt);
  }



}
