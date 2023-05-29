import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewEjerciciosUserComponent } from './view-ejercicios-user.component';

describe('ViewEjerciciosUserComponent', () => {
  let component: ViewEjerciciosUserComponent;
  let fixture: ComponentFixture<ViewEjerciciosUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewEjerciciosUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewEjerciciosUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
