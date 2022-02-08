import {Component, OnInit} from '@angular/core';
import {FizzBuzzCalculationService} from '../../../service/fizz-buzz-calculation.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-fizz-buzz-calculation',
  templateUrl: './fizz-buzz-calculation.component.html',
  styleUrls: ['./fizz-buzz-calculation.component.scss']
})
export class FizzBuzzCalculationComponent implements OnInit {

  MAX_INTEGER = 2147483647;

  result: string;
  numberForCalculate: number

  calculateForm = new FormGroup({});

  get f() {
    return this.calculateForm.controls;
  }

  constructor(private fizzBuzzCalculationService: FizzBuzzCalculationService,
              private formBuilder: FormBuilder) {
    this.calculateForm = formBuilder.group({
      ['numberForCalculate']: ['', [Validators.min(1), Validators.max(this.MAX_INTEGER)]]
    });
  }

  ngOnInit(): void { // NOSONAR
  }

  calculateNumberFizzBuzz(num: number) {
    this.fizzBuzzCalculationService.calculateFizzBuzzFor(num).subscribe(
      result => {
        this.result = result;
      },
      error => {
        console.error('Error occurred', error);
        alert("Error occurred");
      }
    );
  }

  showValidationMessage() {
    alert('Please give a valid number between 1 and ' + this.MAX_INTEGER);
    this.numberForCalculate = 1;
  }
}
