import { Component, OnInit, NgZone } from '@angular/core';
import { Summary } from './models/summary';
import { HeliosService } from './helios.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [HeliosService]
})
export class AppComponent implements OnInit {
  title = 'Helios';
  summaries: Summary[];

  constructor(private zone: NgZone,
    private apiService: HeliosService) {}

  ngOnInit() {
    this.loadSummaryIncomesExpenses();
  }

  /**
   * Load the unfiltered monthly incomes & expenses
   */
  loadSummaryIncomesExpenses() {
    this.apiService.getIncomeAndExpensesSummary()
      .subscribe(
        summaries => {
          this.zone.run(() => {
            this.summaries = summaries;
            console.log('Summary component loaded: ' + JSON.stringify(summaries));
          });
        });
  }
}