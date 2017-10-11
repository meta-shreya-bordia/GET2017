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
var router_2 = require("@angular/router");
var ProductDeleteComponent = (function () {
    function ProductDeleteComponent(productService, route, location, rt) {
        this.productService = productService;
        this.route = route;
        this.location = location;
        this.rt = rt;
    }
    ProductDeleteComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.route.paramMap
            .switchMap(function (params) { return _this.productService.getProduct(+params.get('id')); })
            .subscribe(function (product) { return _this.product = product; });
    };
    ProductDeleteComponent.prototype.delete = function (product) {
        var _this = this;
        this.productService
            .delete(product.id)
            .then(function () {
            _this.rt.navigate(['/products']);
        });
    };
    ProductDeleteComponent.prototype.goBack = function () {
        this.location.back();
    };
    return ProductDeleteComponent;
}());
ProductDeleteComponent = __decorate([
    core_1.Component({
        selector: 'product-delete',
        templateUrl: "./delete-product.component.html",
    }),
    __metadata("design:paramtypes", [product_service_1.ProductService,
        router_1.ActivatedRoute,
        common_1.Location,
        router_2.Router])
], ProductDeleteComponent);
exports.ProductDeleteComponent = ProductDeleteComponent;
//# sourceMappingURL=delete-product.component.js.map