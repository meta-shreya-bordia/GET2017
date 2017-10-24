import { Product } from './Product';
import { Component, OnInit } from '@angular/core';
import 'rxjs/add/operator/switchMap';
import { ProductService }  from './product-service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location }  from '@angular/common';
import { Router }   from '@angular/router';

@Component({
    selector: 'product-delete',
    templateUrl: `./delete-product.component.html`,
  })

  export class ProductDeleteComponent{

    product: Product;
    products: Product[];
    selectedProduct: Product;

    constructor(
        private productService: ProductService,
        private route: ActivatedRoute,
        private location: Location,
        private rt:Router
      ) {}

      ngOnInit(): void {
        this.route.paramMap
          .switchMap((params: ParamMap) => this.productService.getProduct(+params.get('id')))
          .subscribe(product => this.product = product);
      }

   
    delete(product: Product): void {
        this.productService
            .delete(product.id)
            .then(() =>{ 
               this.rt.navigate(['/products']);
            });
      }
      
      goBack(): void {
        this.location.back();
      }

     
    
  }