import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LivreTableComponent } from './livre-table.component';

describe('LivreTableComponent', () => {
  let component: LivreTableComponent;
  let fixture: ComponentFixture<LivreTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LivreTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LivreTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
