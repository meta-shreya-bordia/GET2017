import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Product } from './product';
import { ProductService } from './product.service';


@Component({
  selector: 'my-products',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})

export class ProductsComponent implements OnInit{
  product: Product;
  products: Product[];
  selectedProduct: Product;

  constructor(
    private productService: ProductService,
    private router: Router,
  ) { }  

  ngOnInit(): void{
    this.getProducts();
  }

  /** Set as Selected product */
  onSelect(product: Product): void {
    this.selectedProduct = product;
  }

  /** Get details for selected product */
  goToDetail(): void{
    this.router.navigate(['/detail', this.selectedProduct.id]);
  }

  /** Add a product to the product list */
  goToAddProduct():void{
    this.router.navigate(['/add']);
  }

  /**Delete Product From List */
  delete(product: Product): void {
    this.productService
        .delete(product.id)
        .then(() => {
          this.products = this.products.filter(p => p !== product);
          if (this.selectedProduct === product) { this.selectedProduct = null; }
        });
  }

  /** Get Product List */
  getProducts(): void {
    this.productService.getProducts().then(products => this.products = products);
  }
}