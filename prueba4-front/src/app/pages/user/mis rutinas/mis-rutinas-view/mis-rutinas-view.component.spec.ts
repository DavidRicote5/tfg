import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MisRutinasViewComponent } from './mis-rutinas-view.component';

describe('MisRutinasViewComponent', () => {
  let component: MisRutinasViewComponent;
  let fixture: ComponentFixture<MisRutinasViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MisRutinasViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MisRutinasViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
