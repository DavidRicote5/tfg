import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewEntrenadoresComponent } from './view-entrenadores.component';

describe('ViewEntrenadoresComponent', () => {
  let component: ViewEntrenadoresComponent;
  let fixture: ComponentFixture<ViewEntrenadoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewEntrenadoresComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewEntrenadoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
