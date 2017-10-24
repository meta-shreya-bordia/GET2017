import { Component } from '@angular/core';

import { Product } from './product';

@Component({
  selector: 'my-app',

  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ],
})

export class AppComponent{
  logo = './product-images/cart.png';
  title = 'Shop Them All';
}