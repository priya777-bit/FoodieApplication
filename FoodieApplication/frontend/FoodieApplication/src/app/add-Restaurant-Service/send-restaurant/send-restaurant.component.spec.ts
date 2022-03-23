import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SendRestaurantComponent } from './send-restaurant.component';

describe('SendRestaurantComponent', () => {
  let component: SendRestaurantComponent;
  let fixture: ComponentFixture<SendRestaurantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SendRestaurantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SendRestaurantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
