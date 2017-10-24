import { Component } from '@angular/core';
import {Product} from './Product';
import { ProductService } from './product-service';
import { HomeService } from './homeService';
import { MiniCart } from './userMiniCartDetail';
import { Router } from '@angular/router';

@Component({
    selector: 'my-home',
    templateUrl: './homeComponent.html',
    styleUrls: [ './homeComponent.css' ],
})
export class HomeComponent {
 title = 'blah blah';
 products: Product[] = [];
  minicart:MiniCart;
 constructor(
    private productService: ProductService , private homeService : HomeService,
    private router:Router) { 
        
    }

    getProducts(): void {
        this.productService.getProducts().then(products=>{this.products=products;  });
      }

      getMiniCart():MiniCart{
        return this.minicart;
      }
 
      ngOnInit(): void {
        this.getProducts();
      }

      login(userName:string):void{
        this.homeService.login(userName).then(minicart=>{this.minicart=minicart;
        console.log(minicart.totalPrice);
        console.log(minicart.totalProduct);
        console.log(minicart.user);
       
        });
        this.router.navigate(['main/dashboard']);
      }
}