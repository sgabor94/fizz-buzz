import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './component/util/header/header.component';
import {FizzBuzzCalculationComponent} from './component/business/fizz-buzz-calculation/fizz-buzz-calculation.component';
import {FizzBuzzCalculationService} from './service/fizz-buzz-calculation.service';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AlertService} from './service/util/alert.service';
import {AlertComponent} from './component/util/alert/alert.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    FizzBuzzCalculationComponent,
    AlertComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [
    FizzBuzzCalculationService,
    AlertService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
