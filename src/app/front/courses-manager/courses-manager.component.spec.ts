import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursesManagerComponent } from './courses-manager.component';

describe('CoursesManagerComponent', () => {
  let component: CoursesManagerComponent;
  let fixture: ComponentFixture<CoursesManagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoursesManagerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CoursesManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
