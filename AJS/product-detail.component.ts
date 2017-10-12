import { Component, Input } from '@angular/core';
import { Product } from './product';

@Component({
    selector: 'product-detail',

    template: `
    
    `,
})

export class ProductDetailComponent{
    @Input() product: Product;
}