import { Component, Input, Output, EventEmitter } from '@angular/core';

interface Question {
  idQuestion: string;
  text: string;
  options: string[];
  selectedOptionIndex?: number;  // Ajouté pour suivre l'option sélectionnée
  feedback: string;
}

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent {
  @Input() question!: Question;
  @Output() optionSelected = new EventEmitter<{idQuestion: string, selectedOptionIndex: number, feedback: string}>();

  onOptionSelected(optionIndex: number): void {
    // Assurez-vous d'inclure le feedback si c'est pertinent au moment de la sélection de l'option
    this.optionSelected.emit({
      idQuestion: this.question.idQuestion,
      selectedOptionIndex: optionIndex,
      feedback: this.question.feedback
    });
  }
}
