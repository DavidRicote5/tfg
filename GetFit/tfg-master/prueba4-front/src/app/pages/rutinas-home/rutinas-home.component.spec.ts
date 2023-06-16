import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RutinasHomeComponent } from './rutinas-home.component';

describe('RutinasHomeComponent', () => {
  let component: RutinasHomeComponent;
  let fixture: ComponentFixture<RutinasHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RutinasHomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RutinasHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
