import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRutinasComponent } from './view-rutinas.component';

describe('ViewRutinasComponent', () => {
  let component: ViewRutinasComponent;
  let fixture: ComponentFixture<ViewRutinasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewRutinasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewRutinasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
