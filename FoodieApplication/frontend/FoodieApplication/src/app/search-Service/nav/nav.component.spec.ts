import { ComponentFixture, TestBed } from '@angular/core/testing';

<<<<<<<< HEAD:FoodieApplication/frontend/FoodieApplication/src/app/search-Service/nav/nav.component.spec.ts
import { NavComponent } from './nav.component';

describe('NavComponent', () => {
  let component: NavComponent;
  let fixture: ComponentFixture<NavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavComponent ]
========
import { ViewDishComponent } from './view-dish.component';

describe('ViewDishComponent', () => {
  let component: ViewDishComponent;
  let fixture: ComponentFixture<ViewDishComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewDishComponent ]
>>>>>>>> c7255009cf9e2407eb1546240a46198fe3fc1eba:FoodieApplication/frontend/FoodieApplication/src/app/rest_management/view-dish/view-dish.component.spec.ts
    })
    .compileComponents();
  });

  beforeEach(() => {
<<<<<<<< HEAD:FoodieApplication/frontend/FoodieApplication/src/app/search-Service/nav/nav.component.spec.ts
    fixture = TestBed.createComponent(NavComponent);
========
    fixture = TestBed.createComponent(ViewDishComponent);
>>>>>>>> c7255009cf9e2407eb1546240a46198fe3fc1eba:FoodieApplication/frontend/FoodieApplication/src/app/rest_management/view-dish/view-dish.component.spec.ts
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
