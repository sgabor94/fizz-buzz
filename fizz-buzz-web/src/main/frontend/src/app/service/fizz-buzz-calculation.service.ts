import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

export const FIZZ_BUZZ_CALCULATION_API = environment.apiUrl + '/calculate-fizz-buzz';

@Injectable()
export class FizzBuzzCalculationService {

  constructor(private httpClient: HttpClient) {
  }

  getFizzBuzz() {
    return this.httpClient.get(FIZZ_BUZZ_CALCULATION_API, {responseType: 'text'});
  }
}
