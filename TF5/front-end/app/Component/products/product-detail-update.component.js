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
var ProductDetailUpdateComponent = (function () {
    function ProductDetailUpdateComponent(productService, route, location) {
        this.productService = productService;
        this.route = route;
        this.location = location;
    }
    ProductDetailUpdateComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.route.paramMap
            .switchMap(function (params) { return _this.productService.getProduct(+params.get('id')); })
            .subscribe(function (product) { return _this.product = product; });
    };
    ProductDetailUpdateComponent.prototype.save = function () {
        var _this = this;
        this.productService.update(this.product)
            .then(function () { return _this.goBack(); });
    };
    ProductDetailUpdateComponent.prototype.goBack = function () {
        this.location.back();
    };
    return ProductDetailUpdateComponent;
}());
ProductDetailUpdateComponent = __decorate([
    core_1.Component({
        selector: 'product-update',
        templateUrl: "./product-detail-update-component.html",
    }),
    __metadata("design:paramtypes", [product_service_1.ProductService,
        router_1.ActivatedRoute,
        common_1.Location])
], ProductDetailUpdateComponent);
exports.ProductDetailUpdateComponent = ProductDetailUpdateComponent;
//# sourceMappingURL=product-detail-update.component.js.map