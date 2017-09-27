import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Product } from './product';
import { ProductService } from './product.service';

@Injectable()
export class AddProductService {
  //To make persistent data changes to server data
  private headers = new Headers({'Content-Type': 'application/json'});
  // URL to web api: Get in-memory product list
  private productsUrl = 'api/PRODUCT_LIST';  

  constructor(
      private http: Http,
      private productService: ProductService
    ) { }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

  /***OLD METHOD CLASS */
  create(name: string, price: number): Promise<Product> {
    return this.http
      .post(this.productsUrl, JSON.stringify({name: name, price: price}), {headers: this.headers})
      .toPromise()
      .then(res => res.json().data as Product)
      .catch(this.handleError);
  }
}