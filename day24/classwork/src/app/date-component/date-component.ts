import { Component } from '@angular/core';

@Component({
  selector: 'app-date-component',
  standalone: false,
  templateUrl: './date-component.html',
  styleUrl: './date-component.css',
})
export class DateComponent {
  name: string = "welcome to angular";
  date: Date = new Date();
}
