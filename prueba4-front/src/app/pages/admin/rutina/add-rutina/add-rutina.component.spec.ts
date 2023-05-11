import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddRutinaComponent } from './add-rutina.component';

describe('AddRutinaComponent', () => {
  let component: AddRutinaComponent;
  let fixture: ComponentFixture<AddRutinaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddRutinaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddRutinaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
