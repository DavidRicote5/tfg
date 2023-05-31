import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MisRutinasActualizarComponent } from './mis-rutinas-actualizar.component';

describe('MisRutinasActualizarComponent', () => {
  let component: MisRutinasActualizarComponent;
  let fixture: ComponentFixture<MisRutinasActualizarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MisRutinasActualizarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MisRutinasActualizarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
