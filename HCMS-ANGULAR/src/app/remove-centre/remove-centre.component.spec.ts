import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RemoveCentreComponent } from './remove-centre.component';

describe('RemoveCentreComponent', () => {
  let component: RemoveCentreComponent;
  let fixture: ComponentFixture<RemoveCentreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RemoveCentreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RemoveCentreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
