import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  template: `
    <h1>Welcome to Barrehtopia</h1>
    <button (click)="getMessage()">Get message from server</button>
    <p id="result">{{ message }}</p>
  `
})
export class AppComponent {
  message = '';

  constructor(private http: HttpClient) {}

  getMessage() {
    this.message = 'Loading...';
    this.http.get('/api/message', { responseType: 'text' })
        .subscribe({
        next: (text) => this.message = text,
        error: () => this.message = 'Error: could not reach server'
      });
  }
}
