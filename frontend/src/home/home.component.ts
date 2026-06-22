import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

interface Product {
    id: number;
    name: string;
    description: string;
    pricePerKg: number;
    imageUrl: string;
}

@Component({
    selector: 'app-home',
    standalone: true,
    imports: [CommonModule],
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
    products: Product[] = [];

    constructor(private http: HttpClient) {}

    ngOnInit() {
        this.http.get<Product[]>('/api/products').subscribe({
            next: (data) => this.products = data,
            error: () => console.error('Could not load products')
        });
    }
}