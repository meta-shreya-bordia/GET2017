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
var CartService_1 = require("./CartService");
var CartComponent = (function () {
    function CartComponent(cartServices) {
        this.cartServices = cartServices;
    }
    CartComponent.prototype.ngOnInit = function () {
        this.getCartProduct();
    };
    CartComponent.prototype.getCartProduct = function () {
        var _this = this;
        this.cartServices.getCartProducts().then(function (products) { return _this.products = products; });
    };
    CartComponent.prototype.deleteFromCart = function (product) {
        for (var i = 0; i < this.products.length; i++) {
            if (this.products[i] == product) {
                this.products.splice(i, 1);
            }
        }
    };
    return CartComponent;
}());
CartComponent = __decorate([
    core_1.Component({
        selector: 'cart',
        templateUrl: './cart.component.html'
    }),
    __metadata("design:paramtypes", [CartService_1.CartService])
], CartComponent);
exports.CartComponent = CartComponent;
//# sourceMappingURL=cart.component.js.map