import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-employee-component',
  imports: [CommonModule],
  templateUrl: './employee-component.html',
  styleUrl: './employee-component.css',
})
export class EmployeeComponent {
  employeeId: number = 101;
  name: string = 'satvika h';
  department: string = 'testing';
  salary: number = 65000;

  isVisible: boolean = true;

  toggleVisibility() {
    this.isVisible = !this.isVisible;
  }
}
