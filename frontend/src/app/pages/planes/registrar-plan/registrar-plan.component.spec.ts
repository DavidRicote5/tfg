import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarPlanComponent } from './registrar-plan.component';

describe('RegistrarPlanComponent', () => {
  let component: RegistrarPlanComponent;
  let fixture: ComponentFixture<RegistrarPlanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrarPlanComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrarPlanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
