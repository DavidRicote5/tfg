import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminEntrenadoresComponent } from './admin-entrenadores.component';

describe('AdminEntrenadoresComponent', () => {
  let component: AdminEntrenadoresComponent;
  let fixture: ComponentFixture<AdminEntrenadoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminEntrenadoresComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminEntrenadoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
