import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarPlanComponent } from './actualizar-plan.component';

describe('ActualizarPlanComponent', () => {
  let component: ActualizarPlanComponent;
  let fixture: ComponentFixture<ActualizarPlanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActualizarPlanComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActualizarPlanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
