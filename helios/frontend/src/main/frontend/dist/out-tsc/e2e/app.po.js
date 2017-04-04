"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var protractor_1 = require("protractor");
var HeliosPage = (function () {
    function HeliosPage() {
    }
    HeliosPage.prototype.navigateTo = function () {
        return protractor_1.browser.get('/');
    };
    HeliosPage.prototype.getParagraphText = function () {
        return protractor_1.element(protractor_1.by.css('app-root h1')).getText();
    };
    return HeliosPage;
}());
exports.HeliosPage = HeliosPage;
//# sourceMappingURL=app.po.js.map