import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRestuarantComponent } from './view-restuarant.component';

describe('ViewRestuarantComponent', () => {
  let component: ViewRestuarantComponent;
  let fixture: ComponentFixture<ViewRestuarantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewRestuarantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewRestuarantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
