import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewUsuariosComponent } from './view-usuarios.component';

describe('ViewUsuariosComponent', () => {
  let component: ViewUsuariosComponent;
  let fixture: ComponentFixture<ViewUsuariosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewUsuariosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewUsuariosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
