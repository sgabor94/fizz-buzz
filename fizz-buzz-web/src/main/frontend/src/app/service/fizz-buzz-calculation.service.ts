import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

export const FIZZ_BUZZ_CALCULATION_API = environment.apiUrl + '/calculate-fizz-buzz';

@Injectable()
export class FizzBuzzCalculationService {

  constructor(private httpClient: HttpClient) {
  }

  calculateFirstNFizzBuzzElement() {
    return this.httpClient.get<string[]>(FIZZ_BUZZ_CALCULATION_API + "/first-n-element");
  }

  calculateFizzBuzzFor(num: number = 1) {
    return this.httpClient.get(FIZZ_BUZZ_CALCULATION_API + "?number=" + num, {responseType: 'text'});
  }
}
