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
var router_1 = require("@angular/router");
var product_service_1 = require("./product.service");
var ProductsComponent = (function () {
    function ProductsComponent(productService, router) {
        this.productService = productService;
        this.router = router;
    }
    ProductsComponent.prototype.ngOnInit = function () {
        this.getProducts();
    };
    /** Set as Selected product */
    ProductsComponent.prototype.onSelect = function (product) {
        this.selectedProduct = product;
        this.router.navigate(['/detail', this.selectedProduct.id]);
    };
    /** Get details for selected product */
    ProductsComponent.prototype.goToDetail = function () {
        this.router.navigate(['/detail', this.selectedProduct.id]);
    };
    /** Add a product to the product list */
    ProductsComponent.prototype.goToAddProduct = function () {
        this.router.navigate(['/add']);
    };
    /**Delete Product From List */
    ProductsComponent.prototype.goToDeleteProduct = function (product) {
        this.router.navigate(['/delete', this.product.id]);
    };
    /** Get Product List */
    ProductsComponent.prototype.getProducts = function () {
        var _this = this;
        this.productService.getProducts().then(function (products) { return _this.products = products; });
    };
    return ProductsComponent;
}());
ProductsComponent = __decorate([
    core_1.Component({
        selector: 'my-products',
        templateUrl: './product.component.html',
        styleUrls: ['./app.component.css', './product.component.css'],
    }),
    __metadata("design:paramtypes", [product_service_1.ProductService,
        router_1.Router])
], ProductsComponent);
exports.ProductsComponent = ProductsComponent;
//# sourceMappingURL=products.component.js.map