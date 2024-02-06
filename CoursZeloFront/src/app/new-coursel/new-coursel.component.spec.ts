import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewCourselComponent } from './new-coursel.component';

describe('NewCourselComponent', () => {
  let component: NewCourselComponent;
  let fixture: ComponentFixture<NewCourselComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewCourselComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NewCourselComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
