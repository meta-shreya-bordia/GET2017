import { Injectable } from '@angular/core';

import { Product } from './Product';
import { PRODUCTS } from './mock-products';


import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';



@Injectable()
export class ProductService {
    // URL to web api
    private headers = new Headers({'Content-Type': 'application/json'});
    private productsUrl:string;
   constructor(private http: Http) { }
    getProducts(): Promise<Product[]> {
      this.productsUrl = 'http://localhost:8080/shoppinghibernate/rest/product/list'; 
        return this.http.get(this.productsUrl)
        .toPromise()
        .then(response => response.json() as Product[])
        .catch(this.handleError);
    } // stub

    getProduct(id: number): Promise<Product> {
      this.productsUrl = 'http://localhost:8080/shoppinghibernate/rest/product/get'; 
        const url = `${this.productsUrl}/${id}`;
        return this.http.get(url)
        .toPromise()
        .then(response => response.json() as Product)
        .catch(this.handleError);
      }

      update(product: Product): Promise<Product> {
        this.productsUrl = 'http://localhost:8080/shoppinghibernate/rest/product/edit'
        const url = `${this.productsUrl}/${product.id}`;
        return this.http
          .put(url, JSON.stringify(product), {headers: this.headers})
          .toPromise()
          .then(() => product)
          .catch(this.handleError);
      }

      create(name: string , price: string): Promise<Product> {
        this.productsUrl = 'http://localhost:8080/shoppinghibernate/rest/product/add'
        return this.http
          .post(this.productsUrl, JSON.stringify({name: name,price:price}), {headers: this.headers})
          .toPromise()
          .then(res => res.json() as Product)
          .catch(this.handleError);
      }

      delete(id: number): Promise<void> {
        this.productsUrl = 'http://localhost:8080/shoppinghibernate/rest/product/delete';
        const url = `${this.productsUrl}/${id}`;
        return this.http.delete(url, {headers: this.headers})
          .toPromise()
          .then(() => null)
          .catch(this.handleError);
      }

     private handleError(error: any): Promise<any> {
       console.error('An error occurred', error); // for demo purposes only
       return Promise.reject(error.message || error);
     }


}


