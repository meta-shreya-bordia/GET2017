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
var router_1 = require("@angular/router");
var CartService_1 = require("./CartService");
var ProductComponent = (function () {
    function ProductComponent(router, productService, cartService) {
        this.router = router;
        this.productService = productService;
        this.cartService = cartService;
        this.products = [];
    }
    ProductComponent.prototype.getProducts = function () {
        var _this = this;
        this.productService.getProducts().then(function (products) { _this.products = products; console.log(products); });
    };
    ProductComponent.prototype.ngOnInit = function () {
        this.getProducts();
    };
    ProductComponent.prototype.onSelect = function (product) {
        this.selectedProduct = product;
        this.router.navigate(['/detail', this.selectedProduct.id]);
    };
    ProductComponent.prototype.onUpdate = function (product) {
        this.selectedProduct = product;
        this.router.navigate(['/update', this.selectedProduct.id]);
    };
    ProductComponent.prototype.onDelete = function (product) {
        this.selectedProduct = product;
        this.router.navigate(['/delete', this.selectedProduct.id]);
    };
    ProductComponent.prototype.addToCart = function (product) {
        this.cartService.addProductToCart(product);
        alert("product has been added to the cart");
    };
    return ProductComponent;
}());
ProductComponent = __decorate([
    core_1.Component({
        selector: 'my-products',
        templateUrl: "./product.component.html",
    }),
    __metadata("design:paramtypes", [router_1.Router,
        product_service_1.ProductService,
        CartService_1.CartService])
], ProductComponent);
exports.ProductComponent = ProductComponent;
//# sourceMappingURL=product.component.js.map