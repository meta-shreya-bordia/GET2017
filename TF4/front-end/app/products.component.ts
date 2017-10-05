import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Product } from './product';
import { ProductService } from './product.service';


@Component({
  selector: 'my-products',
  templateUrl: './product.component.html',
  styleUrls: ['./app.component.css', './product.component.css'],
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
    this.router.navigate(['/detail', this.selectedProduct.id]);
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
  goToDeleteProduct(product: Product): void{
    this.router.navigate(['/delete', this.product.id]);    
  }

  /** Get Product List */
  getProducts(): void {
    this.productService.getProducts().then(products => this.products = products);
  }
}