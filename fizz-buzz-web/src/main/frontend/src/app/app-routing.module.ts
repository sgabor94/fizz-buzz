import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FizzBuzzCalculationComponent} from './component/business/fizz-buzz-calculation/fizz-buzz-calculation.component';
import {HomeComponent} from './component/business/home/home.component';

const routes: Routes = [
  {
    path: '', component: HomeComponent, pathMatch: 'full'
  },
  {
    path: 'fizz-buzz-calculation', component: FizzBuzzCalculationComponent, pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
