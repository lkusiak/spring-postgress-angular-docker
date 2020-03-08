import { Component, OnInit } from '@angular/core';
import { QuestionServiceService } from '../../service/question/question-service.service';
import { Question } from 'src/app/model/question/question';
import {Router} from '@angular/router';
import { Summary } from 'src/app/model/summary/summary';

@Component({
  selector: 'app-questionnaire',
  templateUrl: './questionnaire.component.html',
  styleUrls: ['./questionnaire.component.css']
})
export class QuestionnaireComponent implements OnInit {

  questions: Question[];
  currentQuestion: number;
  isLast: boolean;
  isFirst: boolean;
  model: any;

  constructor(private questionService: QuestionServiceService, private router: Router) {

  }

  ngOnInit(): void {
    this.questionService.getAll().subscribe(
      data => {
        this.questions = data;
      }
    );
    this.currentQuestion = 0;
    this.isFirst = true;
  }

  next(): void {
    this.currentQuestion += 1;
    this.isFirst = this.currentQuestion === 0;
    this.isLast = this.currentQuestion === this.questions.length - 1;
  }

  previous(): void {
    this.currentQuestion -= 1;
    this.isFirst = this.currentQuestion === 0;
    this.isLast = this.currentQuestion === this.questions.length - 1;
  }


  submit() {
    this.questionService.getResult(this.questions).subscribe(summary => {
      this.router.navigateByUrl('/summary', { state: {data : summary }});
    });
  }
}
