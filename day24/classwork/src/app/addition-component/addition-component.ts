import { Component } from '@angular/core';
import { CalculatorService } from '../calculator-service';

@Component({
  selector: 'app-addition-component',
  standalone: false,
  templateUrl: './addition-component.html',
  styleUrl: './addition-component.css',
})
export class AdditionComponent {

  // Addition
  addNum1: number = 0;
  addNum2: number = 0;
  additionResult: string = "";

  // Subtraction
  subNum1: number = 0;
  subNum2: number = 0;
  subtractionResult: string = "";

  constructor(private calculatorService: CalculatorService) {}

  getAddition() {
    this.additionResult =
      "Addition : " + this.calculatorService.add(this.addNum1, this.addNum2);
  }

  getSubtraction() {
    this.subtractionResult =
      "Subtraction : " + this.calculatorService.sub(this.subNum1, this.subNum2);
  }
}