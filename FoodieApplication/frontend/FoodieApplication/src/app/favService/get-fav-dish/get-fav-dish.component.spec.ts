import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetFavDishComponent } from './get-fav-dish.component';

describe('GetFavDishComponent', () => {
  let component: GetFavDishComponent;
  let fixture: ComponentFixture<GetFavDishComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetFavDishComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetFavDishComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
