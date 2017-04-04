import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { IncomeExpense } from '../models/incomeExpense';
import { Summary } from '../models/summary';
import { HeliosService } from '../helios.service';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css'],
  providers: [HeliosService]
})
export class SummaryComponent implements OnInit {
  public summaries: Object[];
  public componentName: string = 'Monthly Income and Expenses';


  constructor(private ref: ChangeDetectorRef, 
    private apiService: HeliosService) { }

  ngOnInit() {
    this.loadSummaryIncomesExpenses();
    this.ref.detectChanges();
  }

  /**
   * Load the unfiltered monthly incomes & expenses
   */
  loadSummaryIncomesExpenses() {
    this.apiService.getIncomeAndExpensesSummary()
      .subscribe(
        summaries => {
          this.summaries = summaries;
          console.log('Summary component loaded: ' + JSON.stringify(summaries));
        },
        error => {
          alert('ERROR');
        }
      );
  }

}
