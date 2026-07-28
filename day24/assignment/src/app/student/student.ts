import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-student',
  imports: [CommonModule],
  templateUrl: './student.html',
  styleUrl: './student.css',
})
export class Student {
  students = [
    { id: 1, name: 'Rahul', marks: 85 },
    { id: 2, name: 'Priya', marks: 28 },
    { id: 3, name: 'Amit', marks: 42 },
    { id: 4, name: 'Rekha', marks: 34 },
    { id: 5, name: 'Suresh', marks: 90 },
    { id: 6, name: 'Ananya', marks: 65 },
    { id: 7, name: 'Kiran', marks: 19 },
    { id: 8, name: 'Pooja', marks: 77 },
    { id: 9, name: 'Vikas', marks: 35 },
    { id: 10, name: 'Sneha', marks: 50 }
  ];

  getTotalStudents(): number {
    return this.students.length;
  }

  getPassCount(): number {
    return this.students.filter(s => s.marks >= 35).length;
  }

  getFailCount(): number {
    return this.students.filter(s => s.marks < 35).length;
  }
}
