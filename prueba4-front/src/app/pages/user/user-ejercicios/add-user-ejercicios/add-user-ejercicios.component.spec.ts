import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddUserEjerciciosComponent } from './add-user-ejercicios.component';

describe('AddUserEjerciciosComponent', () => {
  let component: AddUserEjerciciosComponent;
  let fixture: ComponentFixture<AddUserEjerciciosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddUserEjerciciosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddUserEjerciciosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
