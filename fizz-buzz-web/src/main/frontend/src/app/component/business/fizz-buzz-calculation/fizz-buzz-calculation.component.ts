import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {FizzBuzzCalculationService} from '../../../service/fizz-buzz-calculation.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AlertService} from '../../../service/util/alert.service';

@Component({
  selector: 'app-fizz-buzz-calculation',
  templateUrl: './fizz-buzz-calculation.component.html',
  styleUrls: ['./fizz-buzz-calculation.component.scss']
})
export class FizzBuzzCalculationComponent implements OnInit {

  MAX_INTEGER = 2147483647;

  result: string;
  numberForCalculate: number = 1;

  firstNElement: string[] = [];

  calculateForm = new FormGroup({});
  formBuilder: FormBuilder = new FormBuilder();

  get f() {
    return this.calculateForm.controls;
  }

  constructor(private fizzBuzzCalculationService: FizzBuzzCalculationService,
              private cdRef: ChangeDetectorRef,
              private alertService: AlertService) {

  }

  ngOnInit(): void {
    this.calculateForm = this.formBuilder.group({
      ['numberForCalculate']: ['', [Validators.min(1), Validators.max(this.MAX_INTEGER)]]
    });
  }

  ngAfterViewChecked() {
    this.cdRef.detectChanges();
  }

  calculateFirstNFizzBuzzElement() {
    this.fizzBuzzCalculationService.calculateFirstNFizzBuzzElement().subscribe(
      data => {
        this.firstNElement = data;
      },
      error => {
        this.alertService.handleError(error);
      }
    );
  }

  calculateNumberFizzBuzz(num: number) {
    if (num != null) {
      this.fizzBuzzCalculationService.calculateFizzBuzzFor(-2).subscribe(
        data => {
          this.result = data as string;
        },
        error => {
          this.alertService.handleError(error);
        }
      );
    } else {
      this.showValidationMessage();
    }
  }

  showValidationMessage() {
    alert('Please give a valid number between 1 and ' + this.MAX_INTEGER);
    this.numberForCalculate = 1;
  }
}
