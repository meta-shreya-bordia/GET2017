import { Product } from './Product';
import { Component, OnInit } from '@angular/core';
import 'rxjs/add/operator/switchMap';
import { ProductService }  from './product-service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location }  from '@angular/common';

@Component({
    selector: 'product-add',
    templateUrl: `./add-product.component.html`,
  })

  export class ProductAddComponent{

    product: Product;
    products:Product[];
    
      constructor(
        private productService: ProductService,
        private route: ActivatedRoute,
        private location: Location
      ) {}

      getProducts():void{
        this.productService.getProducts().then(products => this.products = products);
      }
    
      ngOnInit(): void {
        this.getProducts();
      }

      goBack(): void {
        this.location.back();
      }
    
      
    

    add(name: string, price: string): void {
        name = name.trim();
        if (!name || !price) { return; }
        this.productService.create(name, price)
        .then(product => {
        this.products.push(product);
        }).then(() => this.goBack());
        }
  }