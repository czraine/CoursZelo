import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuizService } from 'src/app/QuizService/quiz.service';

interface Question {
  id: string;
  text: string;
  options: string[];
}

interface Quiz {
  id: string;
  title: string;
  questions: Question[];
}

@Component({
  selector: 'app-attempts',
  templateUrl: './attempts.component.html',
  styleUrls: ['./attempts.component.css']
})
export class AttemptComponent implements OnInit {
  quiz?: Quiz;
  studentResponses: { [questionId: string]: number } = {};  // Utilisez number si vous enregistrez des indices
  studentName: string = '';  // Nom de l'étudiant
  feedback: string = '';  // Feedback de l'étudiant

  constructor(private quizService: QuizService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    const quizId = this.route.snapshot.paramMap.get('id');
    if (quizId) {
      this.quizService.getQuizById(quizId).subscribe(
        (quiz: Quiz) => this.quiz = quiz,
        (error) => console.error('Error loading quiz:', error)
      );
    }
  }

  onAnswer(questionId: string, optionIndex: number): void {
    this.studentResponses[questionId] = optionIndex;
  }

  submitAttempt(): void {
    const attempt = {
      quizId: this.quiz?.id,
      responses: this.studentResponses,
      username: this.studentName,
      feedback: this.feedback,
      attemptDate: new Date(),
      score: this.calculateScore()  // Supposons que vous avez une fonction pour calculer le score
    };

    this.quizService.submitAttempt(attempt).subscribe(
      result => console.log('Attempt submitted successfully', result),
      error => console.error('Error submitting attempt', error)
    );
  }

  // Supposons que vous avez une méthode pour calculer le score
  private calculateScore(): number {
    let score = 0;
    // Logique de calcul du score basée sur les réponses de l'étudiant
    return score;
  }
}
