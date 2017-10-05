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
var common_1 = require("@angular/common");
var product_service_1 = require("./product.service");
var AddProductComponent = (function () {
    function AddProductComponent(productService, router, location) {
        this.productService = productService;
        this.router = router;
        this.location = location;
        this.defaultImgURL = './app/product-images/cart.png';
    }
    /** Add an element to list */
    AddProductComponent.prototype.add = function (img, name, price) {
        var _this = this;
        name = name.trim();
        if (name === '' || price === '') {
            return;
        }
        if (img === '') {
            img == this.defaultImgURL;
        }
        this.productService.create(this.defaultImgURL, name, +price)
            .then(function (product) {
            _this.products.push(product);
        });
    };
    /**Go back from operation */
    AddProductComponent.prototype.back = function () {
        this.location.back();
    };
    return AddProductComponent;
}());
AddProductComponent = __decorate([
    core_1.Component({
        selector: 'add-product',
        templateUrl: './add-product.component.html',
        styleUrls: ['./add-product.component.css'],
    }),
    __metadata("design:paramtypes", [product_service_1.ProductService,
        router_1.Router,
        common_1.Location])
], AddProductComponent);
exports.AddProductComponent = AddProductComponent;
//# sourceMappingURL=add-product.component.js.map