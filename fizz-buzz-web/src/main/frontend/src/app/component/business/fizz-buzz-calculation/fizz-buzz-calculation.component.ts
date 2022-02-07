import {Component, OnInit} from '@angular/core';
import {FizzBuzzCalculationService} from '../../../service/fizz-buzz-calculation.service';

@Component({
  selector: 'app-fizz-buzz-calculation',
  templateUrl: './fizz-buzz-calculation.component.html',
  styleUrls: ['./fizz-buzz-calculation.component.scss']
})
export class FizzBuzzCalculationComponent implements OnInit {

  result: string;

  constructor(private fizzBuzzCalculationService: FizzBuzzCalculationService) {
  }

  ngOnInit(): void {
    this.initFizzBuzz();
  }

  initFizzBuzz() {
    this.fizzBuzzCalculationService.getFizzBuzz().subscribe(
      result => {
        this.result = result;
      },
      error => {
        console.error('Error occurred', error);
        alert("Error occurred");
      }
    );
  }

}
