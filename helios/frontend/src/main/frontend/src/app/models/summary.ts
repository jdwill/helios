import { IncomeExpense } from './incomeExpense';

export class Summary {
    public month: [string, IncomeExpense];
    //public month: Object;

    constructor(
        month = ['basic', new IncomeExpense]
        //month = new Object
    ){

    }
}