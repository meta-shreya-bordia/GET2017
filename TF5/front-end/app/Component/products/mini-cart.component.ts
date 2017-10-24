import { HomeService } from "./homeService";
import { Component, OnInit } from "@angular/core";
import { MiniCart } from "./userMiniCartDetail";
import { Router } from "@angular/router";

@Component({
    selector: 'mini-cart',
    templateUrl: './mini-cart.component.html',
    providers: [HomeService]
    })

    export class MiniCartComponent implements OnInit{
      minicart :MiniCart;  
      constructor(
        private homeService: HomeService,
        private router: Router) {}

    ngOnInit(): void {
        this.minicart=this.homeService.minicart;
       
    }

    }
    