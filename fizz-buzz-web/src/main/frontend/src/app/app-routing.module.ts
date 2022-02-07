import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FizzBuzzCalculationComponent} from './component/business/fizz-buzz-calculation/fizz-buzz-calculation.component';

const routes: Routes = [
  {
    path: 'fizz-buzz-calculation', component: FizzBuzzCalculationComponent, pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
