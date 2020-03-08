import { Component, OnInit } from '@angular/core';
import { Summary } from 'src/app/model/summary/summary';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})
export class SummaryComponent implements OnInit {

  summary: Summary[];
  constructor() { }

  ngOnInit(): void {
    this.summary = history.state.data;
    console.log(history.state);
  }

}
