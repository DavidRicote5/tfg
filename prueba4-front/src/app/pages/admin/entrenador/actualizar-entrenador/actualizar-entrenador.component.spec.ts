import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarEntrenadorComponent } from './actualizar-entrenador.component';

describe('ActualizarEntrenadorComponent', () => {
  let component: ActualizarEntrenadorComponent;
  let fixture: ComponentFixture<ActualizarEntrenadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActualizarEntrenadorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActualizarEntrenadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
