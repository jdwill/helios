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
var http_1 = require("@angular/http");
require("rxjs/Rx");
require("rxjs/add/operator/map");
require("rxjs/add/operator/catch");
require("rxjs/add/operator/toPromise");
var HeliosService = (function () {
    function HeliosService(http) {
        this.http = http;
        this.headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        this.baseUrl = 'http://localhost:9000/';
        this.options = new http_1.RequestOptions({ headers: this.headers });
    }
    HeliosService.prototype.getIncomeAndExpensesSummary = function () {
        return this.http.get(this.baseUrl + 'getIncomeAndExpensesSummary/')
            .map(function (res) { return res.json(); })
            .do(function (data) { return console.log('Transaction Summary[] data: ' + JSON.stringify(data)); });
        //.catch(console.log('Error calling GetIncomeAndExpensesSummary API'));
    };
    return HeliosService;
}());
HeliosService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http])
], HeliosService);
exports.HeliosService = HeliosService;
//# sourceMappingURL=helios.service.js.map