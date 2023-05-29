import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarEjercicioComponent } from './actualizar-ejercicio.component';

describe('ActualizarEjercicioComponent', () => {
  let component: ActualizarEjercicioComponent;
  let fixture: ComponentFixture<ActualizarEjercicioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActualizarEjercicioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActualizarEjercicioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
