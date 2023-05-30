import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddUserRutinasComponent } from './add-user-rutinas.component';

describe('AddUserRutinasComponent', () => {
  let component: AddUserRutinasComponent;
  let fixture: ComponentFixture<AddUserRutinasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddUserRutinasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddUserRutinasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
