import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarUserEjerciciosComponent } from './actualizar-user-ejercicios.component';

describe('ActualizarUserEjerciciosComponent', () => {
  let component: ActualizarUserEjerciciosComponent;
  let fixture: ComponentFixture<ActualizarUserEjerciciosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActualizarUserEjerciciosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActualizarUserEjerciciosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
