import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarEjercicioComponent } from './registrar-ejercicio.component';

describe('RegistrarEjercicioComponent', () => {
  let component: RegistrarEjercicioComponent;
  let fixture: ComponentFixture<RegistrarEjercicioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrarEjercicioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrarEjercicioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
