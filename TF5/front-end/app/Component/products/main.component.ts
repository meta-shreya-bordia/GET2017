import { Component, Input,OnInit } from '@angular/core';
import { MiniCart } from './userMiniCartDetail';
import { HomeService } from './homeService';


@Component({
selector: 'app-header',
templateUrl: './main.component.html',
styleUrls : ['./main.component.css']
})
export class MainComponent implements OnInit {
@Input() public title = "Shopping Cart";
@Input() public isUserLoggedIn: boolean;
@Input() minicart : MiniCart;
constructor(private homeservice : HomeService){}

ngOnInit(){
this.homeservice.login('abc').then((response) => {
this.minicart = response;
});
}

}