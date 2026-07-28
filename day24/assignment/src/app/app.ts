import { Component, signal } from '@angular/core';
//import { RouterOutlet } from '@angular/router';
import { EmployeeComponent } from './employee-component/employee-component';
import { Student } from './student/student';
import { Product } from './product/product';
import { EmployeeForm } from './employee-form/employee-form';

@Component({
  selector: 'app-root',
  imports: [EmployeeComponent, Student, Product, EmployeeForm],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('angular-assignment');
}
