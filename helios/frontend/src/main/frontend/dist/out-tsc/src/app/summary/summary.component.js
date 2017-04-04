"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var helios_service_1 = require("../helios.service");
var SummaryComponent = (function () {
    function SummaryComponent(ref, apiService) {
        this.ref = ref;
        this.apiService = apiService;
        this.componentName = 'Monthly Income and Expenses';
    }
    SummaryComponent.prototype.ngOnInit = function () {
        this.loadSummaryIncomesExpenses();
        this.ref.detectChanges();
    };
    /**
     * Load the unfiltered monthly incomes & expenses
     */
    SummaryComponent.prototype.loadSummaryIncomesExpenses = function () {
        var _this = this;
        this.apiService.getIncomeAndExpensesSummary()
            .subscribe(function (summaries) {
            _this.summaries = summaries;
            console.log('Summary component loaded: ' + JSON.stringify(summaries));
        }, function (error) {
            alert('ERROR');
        });
    };
    return SummaryComponent;
}());
SummaryComponent = __decorate([
    core_1.Component({
        selector: 'app-summary',
        templateUrl: './summary.component.html',
        styleUrls: ['./summary.component.css'],
        providers: [helios_service_1.HeliosService]
    }),
    __metadata("design:paramtypes", [core_1.ChangeDetectorRef,
        helios_service_1.HeliosService])
], SummaryComponent);
exports.SummaryComponent = SummaryComponent;
//# sourceMappingURL=summary.component.js.map