import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LivreModifierComponent } from './livre-modifier.component';

describe('LivreModifierComponent', () => {
  let component: LivreModifierComponent;
  let fixture: ComponentFixture<LivreModifierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LivreModifierComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LivreModifierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
