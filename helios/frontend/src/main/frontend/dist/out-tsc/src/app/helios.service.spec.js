"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var testing_1 = require("@angular/core/testing");
var helios_service_1 = require("./helios.service");
describe('HeliosService', function () {
    beforeEach(function () {
        testing_1.TestBed.configureTestingModule({
            providers: [helios_service_1.HeliosService]
        });
    });
    it('should ...', testing_1.inject([helios_service_1.HeliosService], function (service) {
        expect(service).toBeTruthy();
    }));
});
//# sourceMappingURL=helios.service.spec.js.map