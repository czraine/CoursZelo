import { Component } from '@angular/core';
import { QuizService } from 'src/app/QuizService/quiz.service'; 
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-quiz',
  templateUrl: './create-quiz.component.html',
  styleUrls: ['./create-quiz.component.css']
})
export class CreateQuizComponent {
   quiz: any = {
    title: '',
    questions: [
      {
        text: 'Example Question?',
        options: ['Option 1', 'Option 2'],
        correctAnswerIndex: null, // or the index of the correct option
      }
    ],
    createdDate: new Date(), // Assuming handling on the frontend for simplicity
    creator: '', // This should be set based on the logged-in user or similar
    status: 'Draft', // Default status
    maxAttempts: 1,
    showAnswers: false,
    showScore: false,
    passMark: 0,
    scheduleDate: new Date(), // Set a default or use a date picker in the UI
    durationInSeconds: 0,
    randomizeQuestions: false
  };

  constructor(private quizService: QuizService, private router: Router) {}

  addQuestion(): void {
    const newQuestion = {
      text: '',
      options: [''], // Initially, there's one option for the new question
      correctAnswerIndex: null // Placeholder for the correct answer index
    };
    this.quiz.questions.push(newQuestion);
  }

  addOption(questionIndex: number): void {
    this.quiz.questions[questionIndex].options.push('');
  }

  saveQuiz(): void {
    this.quizService.createQuiz(this.quiz).subscribe(response => {
      console.log('Quiz saved successfully', response);
      this.router.navigate(['/quiz-list']);
    }, error => {
      console.error('Error saving quiz', error);
    });
  }
  // Function to handle answer selected event
  handleAnswer(questionIndex: number, selectedOptionIndex: number): void {
    // Here you can implement the logic to handle the selected answer
    console.log('Question Index:', questionIndex);
    console.log('Selected Option Index:', selectedOptionIndex);
    // Update the quiz object with the selected answer
    this.quiz.questions[questionIndex].selectedAnswerIndex = selectedOptionIndex;
  }


}



