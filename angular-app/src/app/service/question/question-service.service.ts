import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Question } from '../../model/question/question';
import { HttpClient } from '@angular/common/http';
import { Summary } from 'src/app/model/summary/summary';

@Injectable({
  providedIn: 'root'
})
export class QuestionServiceService {

  private questionsUrl: string;
  private resultUrl: string;

  constructor(private http: HttpClient) {
    this.questionsUrl = 'http://localhost:8080/questions';
    this.resultUrl = 'http://localhost:8080/result';
  }

  public getAll(): Observable<Question[]> {
    return this.http.get<Question[]>(this.questionsUrl);
  }

  public getResult(answers: Question[]): Observable<Summary[]> {
    return this.http.post<Summary[]>(this.resultUrl, answers);
  }
}
