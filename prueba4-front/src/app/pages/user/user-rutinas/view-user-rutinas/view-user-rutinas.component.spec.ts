import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewUserRutinasComponent } from './view-user-rutinas.component';

describe('ViewUserRutinasComponent', () => {
  let component: ViewUserRutinasComponent;
  let fixture: ComponentFixture<ViewUserRutinasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewUserRutinasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewUserRutinasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
