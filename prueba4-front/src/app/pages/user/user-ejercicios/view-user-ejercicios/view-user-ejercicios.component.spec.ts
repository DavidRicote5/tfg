import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewUserEjerciciosComponent } from './view-user-ejercicios.component';

describe('ViewUserEjerciciosComponent', () => {
  let component: ViewUserEjerciciosComponent;
  let fixture: ComponentFixture<ViewUserEjerciciosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewUserEjerciciosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewUserEjerciciosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
