import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarRutinaComponent } from './registrar-rutina.component';

describe('RegistrarRutinaComponent', () => {
  let component: RegistrarRutinaComponent;
  let fixture: ComponentFixture<RegistrarRutinaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrarRutinaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrarRutinaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
