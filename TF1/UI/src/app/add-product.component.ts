import { Component, OnInit } from '@angular/core';
import { Router }            from '@angular/router';
import { Location }          from '@angular/common';

import { Product } from './product';
import { ProductService } from './product.service';

@Component({
  selector: 'add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css' ],
})

export class AddProductComponent{
  product: Product;
  products: Product[];
  defaultImgURL =  './app/product-images/cart.png';  

  constructor(
    private productService: ProductService,
    private router: Router,
    private location: Location,
  ) { }  

  /** Add an element to list */
  add(img: string, name: string, price: string): void {
    name = name.trim();
    if (name==='' || price==='') { 
      return; 
    }

    if(img===''){
      img == this.defaultImgURL;
    } 
    
    this.productService.create(this.defaultImgURL, name, +price)
      .then(product => {
        this.products.push(product);
      });
  }

  /**Go back from operation */
  back(): void{
    this.location.back();
  }
}