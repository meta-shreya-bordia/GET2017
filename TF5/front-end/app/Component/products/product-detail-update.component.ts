
import { Product } from './Product';
import { Component, OnInit } from '@angular/core';
import 'rxjs/add/operator/switchMap';
import { ProductService }  from './product-service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location }  from '@angular/common';

@Component({
  selector: 'product-update',
  templateUrl: `./product-detail-update-component.html`,
})
export class ProductDetailUpdateComponent {

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

    save(): void {
        this.productService.update(this.product)
          .then(() => this.goBack());
      }
  
    goBack(): void {
      this.location.back();
    }
  
}







