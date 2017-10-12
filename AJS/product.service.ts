import { Injectable } from '@angular/core';

import { Product } from './product';
import { PRODUCT_LIST } from './mock-products';

@Injectable()
export class ProductService{
    getProducts(): Promise<Product[]> {
        return Promise.resolve(PRODUCT_LIST);
    }
}