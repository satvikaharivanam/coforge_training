import { Component } from '@angular/core';

@Component({
  selector: 'app-employee-component',
  standalone: false,
  templateUrl: './employee-component.html',
  styleUrl: './employee-component.css',
})
export class EmployeeComponent {
  result : string;

  constructor() {
    this.result = "";
  }

  saveEmployee(data : any) {
    this.result =
      "Employee Saved Successfully!" +
      " Employee ID: " + data.eid +
      " Employee Name: " + data.ename +
      " Employee Salary: " + data.esalary +
      " Employee Dno: " + data.dno;
  }
}
