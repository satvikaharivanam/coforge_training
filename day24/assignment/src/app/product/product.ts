import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-product',
  imports: [CommonModule],
  templateUrl: './product.html',
  styleUrl: './product.css',
})
export class Product {
  products = [
    { id: 101, name: 'Wireless Headphones', category: 'Electronics', price: 14999 },
    { id: 102, name: 'Wireless Mouse', category: 'Electronics', price: 899 },
    { id: 103, name: 'Mechanical Keyboard', category: 'Electronics', price: 2499 },
    { id: 104, name: 'Ergonomic Chair', category: 'Furniture', price: 7500 },
    { id: 105, name: 'Study Desk', category: 'Furniture', price: 4500 },
    { id: 106, name: 'USB-C Hub', category: 'Electronics', price: 1299 }
  ];
}
