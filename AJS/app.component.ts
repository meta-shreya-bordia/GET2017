import { Component, OnInit } from '@angular/core';

import { Product } from './product';
import { ProductService } from './product.service';

@Component({
  selector: 'my-app',
  providers: [ProductService],
  
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ],
})

export class AppComponent implements OnInit{
  title = 'Product List';
  products: Product[];
  selectedProduct: Product;

  constructor(private productService: ProductService) { }  

  onSelect(product: Product): void {
    this.selectedProduct = product;
  }

  getProductsSlowly(): void {
    this.productService.getProducts().then(products => this.products = products);
  }

  ngOnInit(): void{
    this.getProductsSlowly();
  }
}