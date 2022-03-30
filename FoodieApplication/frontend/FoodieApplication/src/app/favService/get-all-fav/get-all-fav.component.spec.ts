import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllFavComponent } from './get-all-fav.component';

describe('GetAllFavComponent', () => {
  let component: GetAllFavComponent;
  let fixture: ComponentFixture<GetAllFavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllFavComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllFavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
