import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEjercicioComponent } from './add-ejercicio.component';

describe('AddEjercicioComponent', () => {
  let component: AddEjercicioComponent;
  let fixture: ComponentFixture<AddEjercicioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEjercicioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddEjercicioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
