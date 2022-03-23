import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SendDishComponent } from './send-dish.component';

describe('SendDishComponent', () => {
  let component: SendDishComponent;
  let fixture: ComponentFixture<SendDishComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SendDishComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SendDishComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
