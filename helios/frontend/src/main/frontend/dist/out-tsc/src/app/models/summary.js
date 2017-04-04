"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var incomeExpense_1 = require("./incomeExpense");
var Summary = (function () {
    //public month: Object;
    function Summary(month
        //month = new Object
    ) {
        if (month === void 0) { month = ['basic', new incomeExpense_1.IncomeExpense]; }
    }
    return Summary;
}());
exports.Summary = Summary;
//# sourceMappingURL=summary.js.map