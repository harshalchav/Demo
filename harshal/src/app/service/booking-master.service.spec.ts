import { TestBed } from '@angular/core/testing';

import { BookingMasterService } from './booking-master.service';

describe('BookingMasterService', () => {
  let service: BookingMasterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookingMasterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
