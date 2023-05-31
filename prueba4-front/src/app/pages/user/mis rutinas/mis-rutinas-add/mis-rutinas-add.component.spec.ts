import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MisRutinasAddComponent } from './mis-rutinas-add.component';

describe('MisRutinasAddComponent', () => {
  let component: MisRutinasAddComponent;
  let fixture: ComponentFixture<MisRutinasAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MisRutinasAddComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MisRutinasAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
