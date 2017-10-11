"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var product_service_1 = require("./product-service");
var homeService_1 = require("./homeService");
var router_1 = require("@angular/router");
var HomeComponent = (function () {
    function HomeComponent(productService, homeService, router) {
        this.productService = productService;
        this.homeService = homeService;
        this.router = router;
        this.title = 'blah blah';
        this.products = [];
    }
    HomeComponent.prototype.getProducts = function () {
        var _this = this;
        this.productService.getProducts().then(function (products) { _this.products = products; });
    };
    HomeComponent.prototype.getMiniCart = function () {
        return this.minicart;
    };
    HomeComponent.prototype.ngOnInit = function () {
        this.getProducts();
    };
    HomeComponent.prototype.login = function (userName) {
        var _this = this;
        this.homeService.login(userName).then(function (minicart) {
            _this.minicart = minicart;
            console.log(minicart.totalPrice);
            console.log(minicart.totalProduct);
            console.log(minicart.user);
        });
        this.router.navigate(['main/dashboard']);
    };
    return HomeComponent;
}());
HomeComponent = __decorate([
    core_1.Component({
        selector: 'my-home',
        templateUrl: './homeComponent.html',
        styleUrls: ['./homeComponent.css'],
    }),
    __metadata("design:paramtypes", [product_service_1.ProductService, homeService_1.HomeService,
        router_1.Router])
], HomeComponent);
exports.HomeComponent = HomeComponent;
//# sourceMappingURL=home-component.js.map