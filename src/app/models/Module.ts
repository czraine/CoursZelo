export class Module {
    ModuleId!: string;
    moduleName!: string;
    Credit!: number;
  }
export interface Question {
  idQuestion: string;
  text: string;
  options: string[];
  correctAnswerIndex: number;
  feedback: string;

}

export interface Quiz {
  id: string;
  title: string;
  questions: Question[];
    createdDate : Date;
    creator: String;
    status: String;
    maxAttempts: number;
    showAnswers : boolean;
  showScore: boolean;
  passMark: number;
    scheduleDate : Date;
durationInSeconds: number;
  randomizeQuestions: boolean;
}

export interface Attempt {
  idAttempt?: string; // Optionnel car il sera défini par le backend lors de la création
  quizId: string;
  username: string;
  attemptDate?: Date; // Optionnel pour la même raison
  responses: Map<string, string>; // Clé: ID de la question, Valeur: réponse donnée
  score?: number; // Peut être calculé côté backend
}
