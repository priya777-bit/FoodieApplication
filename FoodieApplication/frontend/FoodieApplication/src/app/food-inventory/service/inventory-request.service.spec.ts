import { TestBed } from '@angular/core/testing';

import { InventoryRequestService } from './inventory-request.service';

describe('InventoryRequestService', () => {
  let service: InventoryRequestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InventoryRequestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
