import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarUserRutinasComponent } from './actualizar-user-rutinas.component';

describe('ActualizarUserRutinasComponent', () => {
  let component: ActualizarUserRutinasComponent;
  let fixture: ComponentFixture<ActualizarUserRutinasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActualizarUserRutinasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActualizarUserRutinasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
