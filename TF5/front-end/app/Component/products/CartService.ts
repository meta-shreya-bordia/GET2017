import { Injectable } from '@angular/core';
import { Product } from './Product';

@Injectable()
export class CartService {

    static products : Product[] = [];
    
    getCartProducts() : Promise<Product[]>{
        console.log(CartService.products);
        return Promise.resolve(CartService.products);
    }

    addProductToCart(product : Product){
        
        CartService.products.push(product);
        console.log(CartService.products);
    }
}