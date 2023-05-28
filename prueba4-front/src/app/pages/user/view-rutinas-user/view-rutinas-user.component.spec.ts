import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRutinasUserComponent } from './view-rutinas-user.component';

describe('ViewRutinasUserComponent', () => {
  let component: ViewRutinasUserComponent;
  let fixture: ComponentFixture<ViewRutinasUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewRutinasUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewRutinasUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
