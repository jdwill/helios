import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CrystalballComponent } from './crystalball.component';

describe('CrystalballComponent', () => {
  let component: CrystalballComponent;
  let fixture: ComponentFixture<CrystalballComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CrystalballComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrystalballComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
