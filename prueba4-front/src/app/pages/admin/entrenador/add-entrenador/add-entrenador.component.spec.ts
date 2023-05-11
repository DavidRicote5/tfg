import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEntrenadorComponent } from './add-entrenador.component';

describe('AddEntrenadorComponent', () => {
  let component: AddEntrenadorComponent;
  let fixture: ComponentFixture<AddEntrenadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEntrenadorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddEntrenadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
