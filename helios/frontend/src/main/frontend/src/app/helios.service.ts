import { Injectable } from '@angular/core';
import { Headers, Http, Response, RequestOptions } from '@angular/http';

//RxJs
import { Observable } from 'rxjs/Rx';
import 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';

//Models
import { Summary } from './models/summary';
import { IncomeExpense } from './models/incomeExpense';

@Injectable()
export class HeliosService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private baseUrl = 'http://localhost:9000/';
  options = new RequestOptions({ headers: this.headers });

  constructor(private http: Http) { }

  getIncomeAndExpensesSummary(): Observable<Summary[]>{
    return this.http.get(this.baseUrl + 'getIncomeAndExpensesSummary/')
      .map((res: Response) => res.json())
        .do(data => console.log('Transaction Summary[] data: ' + JSON.stringify(data)));
        //.catch(console.log('Error calling GetIncomeAndExpensesSummary API'));
  }
}
