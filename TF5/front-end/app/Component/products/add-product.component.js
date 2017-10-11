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
require("rxjs/add/operator/switchMap");
var product_service_1 = require("./product-service");
var router_1 = require("@angular/router");
var common_1 = require("@angular/common");
var ProductAddComponent = (function () {
    function ProductAddComponent(productService, route, location) {
        this.productService = productService;
        this.route = route;
        this.location = location;
    }
    ProductAddComponent.prototype.getProducts = function () {
        var _this = this;
        this.productService.getProducts().then(function (products) { return _this.products = products; });
    };
    ProductAddComponent.prototype.ngOnInit = function () {
        this.getProducts();
    };
    ProductAddComponent.prototype.goBack = function () {
        this.location.back();
    };
    ProductAddComponent.prototype.add = function (name, price) {
        var _this = this;
        name = name.trim();
        if (!name || !price) {
            return;
        }
        this.productService.create(name, price)
            .then(function (product) {
            _this.products.push(product);
        }).then(function () { return _this.goBack(); });
    };
    return ProductAddComponent;
}());
ProductAddComponent = __decorate([
    core_1.Component({
        selector: 'product-add',
        templateUrl: "./add-product.component.html",
    }),
    __metadata("design:paramtypes", [product_service_1.ProductService,
        router_1.ActivatedRoute,
        common_1.Location])
], ProductAddComponent);
exports.ProductAddComponent = ProductAddComponent;
//# sourceMappingURL=add-product.component.js.map