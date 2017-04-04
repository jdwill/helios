import { TestBed, inject } from '@angular/core/testing';

import { HeliosService } from './helios.service';

describe('HeliosService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HeliosService]
    });
  });

  it('should ...', inject([HeliosService], (service: HeliosService) => {
    expect(service).toBeTruthy();
  }));
});
