import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AttemptComponent } from './attempts.component';

describe('AttemptsComponent', () => {
  let component:AttemptComponent;
  let fixture: ComponentFixture<AttemptComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AttemptComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AttemptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});