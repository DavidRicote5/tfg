import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPlanesComponent } from './view-planes.component';

describe('ViewPlanesComponent', () => {
  let component: ViewPlanesComponent;
  let fixture: ComponentFixture<ViewPlanesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewPlanesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewPlanesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
