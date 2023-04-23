import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminRutinasComponent } from './admin-rutinas.component';

describe('AdminRutinasComponent', () => {
  let component: AdminRutinasComponent;
  let fixture: ComponentFixture<AdminRutinasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminRutinasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminRutinasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
