import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminEjerciciosComponent } from './admin-ejercicios.component';

describe('AdminEjerciciosComponent', () => {
  let component: AdminEjerciciosComponent;
  let fixture: ComponentFixture<AdminEjerciciosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminEjerciciosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminEjerciciosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
