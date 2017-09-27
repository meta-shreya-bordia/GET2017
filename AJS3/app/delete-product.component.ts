import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Product } from './product';
import { ProductService } from './product.service';

@Component({
  selector: 'delete-product',
  template: `<h2>Product deleted successfully</h2>`,
})

export class DeleteProductComponent{
  products: Product[];
  selectedProduct: Product;

  constructor(
    private productService: ProductService,
    private router: Router,
    private location: Location,
  ) { }  

  /**Delete set product.
   * If it is the selected product, unset the selected product pointer  */
  delete(product: Product): void {
    this.productService
        .delete(product.id)
        .then(() => {
          this.products = this.products.filter(p => p !== product);
          if (this.selectedProduct === product) { this.selectedProduct = null; }
        });
  }
}