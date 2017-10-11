
import { Product } from './Product';
import { Component, OnInit } from '@angular/core';
import 'rxjs/add/operator/switchMap';
import { ProductService }  from './product-service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location }  from '@angular/common';

@Component({
  selector: 'product-detail',
  templateUrl: `./product-detail-component.html`,
})
export class ProductDetailComponent {

  product: Product;
  
    constructor(
      private productService: ProductService,
      private route: ActivatedRoute,
      private location: Location
    ) {}
  
    ngOnInit(): void {
      this.route.paramMap
        .switchMap((params: ParamMap) => this.productService.getProduct(+params.get('id')))
        .subscribe(product => this.product = product);
    }
  
    goBack(): void {
      this.location.back();
    }
  
}







