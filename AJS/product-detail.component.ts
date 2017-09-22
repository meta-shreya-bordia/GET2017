import { Component } from '@angular/core';

@Component({
  selector: 'product-detail',
  template: `
  <div *ngIf="hero">
    <h2>{{product.name}} details!</h2>
    <div><label>id: </label>{{product.id}}</div>
    <div>
      <label>name: </label>
      <input [(ngModel)]="product.name" placeholder="name"/>
    </div>
    <div>
        <label>price: {{product.price}}</label>
    </div>
  </div>
`,
})
export class ProductDetailComponent {
}