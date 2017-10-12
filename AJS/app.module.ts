import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms'; // <-- NgModel lives here
import { ProductDetailComponent } from './product-detail.component';

import { AppComponent }  from './app.component';

@NgModule({
  imports:      [ BrowserModule,
    FormsModule // <-- import the FormsModule before binding with [(ngModel)]
  ],
  declarations: [ AppComponent,
    ProductDetailComponent
  ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
