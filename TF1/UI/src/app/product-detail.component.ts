import 'rxjs/add/operator/switchMap';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location }                 from '@angular/common';

import { ProductService } from './product.service';
import { Product } from './product';

@Component({
    selector: 'product-detail',
    templateUrl: './product-detail.component.html',
    styleUrls: [ './product-detail.component.css' ],
})

export class ProductDetailComponent implements OnInit{
    product: Product;
    products: Product[];

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

    back(): void {
        this.location.back();
    }

    save(): void {
        this.productService.update(this.product)
          .then(() => this.back());
    }
}