"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var ValuePipe = (function () {
    function ValuePipe() {
    }
    ValuePipe.prototype.transform = function (value, args) {
        var keyArr = Object.keys(value), dataArr = [], keyName = args[0];
        console.log('Key Name: ' + args[0]);
        console.log('Keys: ' + Object.keys(value));
        keyArr.forEach(function (key) {
            value[key][keyName] = key;
            dataArr.push(value[key]);
        });
        if (args[1]) {
            dataArr.sort(function (a, b) {
                return a[keyName] > b[keyName] ? 1 : -1;
            });
        }
        return dataArr;
    };
    return ValuePipe;
}());
ValuePipe = __decorate([
    core_1.Pipe({
        name: 'value'
    })
], ValuePipe);
exports.ValuePipe = ValuePipe;
//# sourceMappingURL=value.pipe.js.map