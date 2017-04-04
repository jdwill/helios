import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { SummaryComponent } from './summary/summary.component';
import { DonutComponent } from './donut/donut.component';
import { CrystalballComponent } from './crystalball/crystalball.component';
import { CreditcardComponent } from './creditcard/creditcard.component';
import { ValuePipe } from './value.pipe';

@NgModule({
  declarations: [
    AppComponent,
    SummaryComponent,
    DonutComponent,
    CrystalballComponent,
    CreditcardComponent,
    ValuePipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
