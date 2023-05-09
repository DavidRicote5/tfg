import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarRutinaComponent } from './actualizar-rutina.component';

describe('ActualizarRutinaComponent', () => {
  let component: ActualizarRutinaComponent;
  let fixture: ComponentFixture<ActualizarRutinaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActualizarRutinaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActualizarRutinaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
