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
var helios_service_1 = require("./helios.service");
var AppComponent = (function () {
    function AppComponent(zone, apiService) {
        this.zone = zone;
        this.apiService = apiService;
        this.title = 'Helios';
    }
    AppComponent.prototype.ngOnInit = function () {
        this.loadSummaryIncomesExpenses();
    };
    /**
     * Load the unfiltered monthly incomes & expenses
     */
    AppComponent.prototype.loadSummaryIncomesExpenses = function () {
        var _this = this;
        this.apiService.getIncomeAndExpensesSummary()
            .subscribe(function (summaries) {
            _this.zone.run(function () {
                _this.summaries = summaries;
                console.log('Summary component loaded: ' + JSON.stringify(summaries));
            });
        });
    };
    return AppComponent;
}());
AppComponent = __decorate([
    core_1.Component({
        selector: 'app-root',
        templateUrl: './app.component.html',
        styleUrls: ['./app.component.css'],
        providers: [helios_service_1.HeliosService]
    }),
    __metadata("design:paramtypes", [core_1.NgZone,
        helios_service_1.HeliosService])
], AppComponent);
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map