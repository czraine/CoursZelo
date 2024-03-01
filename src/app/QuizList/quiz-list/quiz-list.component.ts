import { Component } from '@angular/core';
import { QuizService } from 'src/app/QuizService/quiz.service'; 
import { Router } from '@angular/router';

@Component({
  selector: 'app-quiz-list',
 
  templateUrl: './quiz-list.component.html',
  styleUrls: ['./quiz-list.component.css']
})
export class QuizListComponent {
  quizzes: any[] = [];

  constructor(private quizService: QuizService) {}

  ngOnInit(): void {
    this.loadQuizzes();
  }

  loadQuizzes(): void {
    this.quizService.getQuizzes().subscribe(
      (data) => {
        this.quizzes = data;
      },
      (error) => {
        console.error('Error fetching quizzes', error);
      }
    );
  }

  deleteQuiz(quizId: string): void {
    this.quizService.deleteQuiz(quizId).subscribe(
      () => {
        this.quizzes = this.quizzes.filter(quiz => quiz.id !== quizId);
      },
      (error) => {
        console.error('Error deleting quiz', error);
      }
    );
  }
}
