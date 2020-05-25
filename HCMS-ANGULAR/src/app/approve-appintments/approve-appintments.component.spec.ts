import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApproveAppintmentsComponent } from './approve-appintments.component';

describe('ApproveAppintmentsComponent', () => {
  let component: ApproveAppintmentsComponent;
  let fixture: ComponentFixture<ApproveAppintmentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApproveAppintmentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApproveAppintmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
