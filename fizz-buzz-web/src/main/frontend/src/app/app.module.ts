import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './component/util/header/header.component';
import {FizzBuzzCalculationComponent} from './component/business/fizz-buzz-calculation/fizz-buzz-calculation.component';
import {FizzBuzzCalculationService} from './service/fizz-buzz-calculation.service';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    FizzBuzzCalculationComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    FizzBuzzCalculationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
