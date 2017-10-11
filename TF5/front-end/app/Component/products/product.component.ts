import { Component } from '@angular/core';
import { ProductService } from './product-service';
import {Product} from './Product';
import { Router } from '@angular/router';
import { CartService } from './CartService';


@Component({
    selector: 'my-products',
    templateUrl: `./product.component.html`,
    
  })

  export class ProductComponent {
   
    products: Product[] = [];
    selectedProduct: Product;
    
    constructor(
      private router: Router,
      private productService: ProductService
    ,private cartService : CartService) { }
    
     getProducts(): void {
       this.productService.getProducts().then(products=>{this.products=products; console.log(products) });
     }

     ngOnInit(): void {
       this.getProducts();
     }
    
     onSelect(product: Product): void {
       this.selectedProduct = product;
       this.router.navigate(['/detail', this.selectedProduct.id]);
     }

     onUpdate(product: Product): void {
      this.selectedProduct = product;
      this.router.navigate(['/update', this.selectedProduct.id]);
    }

    onDelete(product: Product):void{
      this.selectedProduct = product;
      this.router.navigate(['/delete', this.selectedProduct.id]);
    }

    addToCart(product : Product) : void {
      this.cartService.addProductToCart(product);
      alert("product has been added to the cart");
  }


    
   
     
}