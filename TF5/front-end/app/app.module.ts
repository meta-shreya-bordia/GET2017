import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule }    from '@angular/http';

import { AppComponent }  from './app.component';
import {ProductComponent} from './Component/products/product.component';
import{FormsModule} from '@angular/forms';
import{ProductService} from './Component/products/product-service';
import { ProductAppComponent }        from './Component/products/app.component';
import { RouterModule }   from '@angular/router';
import {DashboardComponent} from './Component/products/dashboard.component';
import {ContactUsComponent} from './Component/products/contact-us.component';
import {ProductDetailComponent} from './Component/products/product-detail-component';

import { ProductDetailUpdateComponent }  from './Component/products/product-detail-update.component';
import { ProductAddComponent }  from './Component/products/add-product.component';
import { ProductDeleteComponent }  from './Component/products/delete-product.component';
import { ProductSearchComponent }  from './Component/products/product-search.component';
import { CartComponent }  from './Component/products/cart.component';
import {CartService}   from './Component/products/CartService';
import { HomeComponent } from './Component/products/home-component';
import { HomeService } from './Component/products/homeService';
import { MiniCartComponent } from './Component/products/mini-cart.component';
import { MainComponent } from './Component/products/main.component';





@NgModule({
  imports:      [ BrowserModule,FormsModule,HttpModule,RouterModule.forRoot([

    {
      path:'main',
      component : MainComponent,
      children: [
      { path: 'dashboard', component: DashboardComponent},
      {
      path:'products',
      component : ProductComponent
      },
      {
      path : 'contact-us',
      component : ContactUsComponent
      },
      {
      path : 'cart',
      component : CartComponent
      }
      ]
      }

    ,
    {
      path: 'products',
      component: ProductComponent
    },
    {
      path: 'cart',
      component: CartComponent
    },
    {
      path: 'dashboard',
      component: DashboardComponent
    },
    {
      path: 'contact-us',
      component: ContactUsComponent
    },
    {
      path: 'update/:id',
      component: ProductDetailUpdateComponent
      
    },
    {
      path: 'add',
      component: ProductAddComponent
      
    },
    {
      path: 'home',
      component: HomeComponent
      
    },
    {
      path: '',
      redirectTo: '/home',
      pathMatch: 'full'
    },
    {
      path: 'detail/:id',
      component: ProductDetailComponent
    },
    {
      path: 'delete/:id',
      component: ProductDeleteComponent
    },

  ]),],
  declarations: [ AppComponent,MainComponent,ProductComponent,HomeComponent,ProductAppComponent,DashboardComponent,ProductSearchComponent,CartComponent,ContactUsComponent,ProductDetailComponent,ProductAddComponent,ProductDetailUpdateComponent,ProductDeleteComponent,MiniCartComponent],
  bootstrap:    [ ProductAppComponent ],
  providers:    [ProductService, CartService,HomeService ]
})


export class AppModule { }
