import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms'; // <-- NgModel lives here
import { RouterModule }   from '@angular/router';
import { HttpModule }    from '@angular/http';

// Imports for loading & configuring the in-memory web api

import { ProductDetailComponent } from './product-detail.component';
import { ProductsComponent } from './products.component';

import { AppComponent }  from './app.component';
import { DashboardComponent } from './dashboard.component';
import { ContactUsComponent } from './contact-us.component';

import { ProductService } from './product.service';

import { ProductSearchComponent } from './product-search.component';
import { AddProductComponent } from './add-product.component';
import { DeleteProductComponent } from './delete-product.component';

import { AppRoutingModule }     from './app-routing.module';
 
@NgModule({
  imports:      [
    BrowserModule,
    FormsModule, // <-- import the FormsModule before binding with [(ngModel)]
    AppRoutingModule,
    HttpModule,
  ],
  
  declarations: [
    AppComponent,
    ProductDetailComponent,
    ProductsComponent,
    DashboardComponent,
    ContactUsComponent,
    ProductSearchComponent,
    AddProductComponent,
    DeleteProductComponent
  ],
  
  providers: [ ProductService ],

  bootstrap: [ AppComponent ]
})

export class AppModule { }
