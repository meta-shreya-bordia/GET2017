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
var DeleteProductComponent = (function () {
    function DeleteProductComponent(productService, router, location) {
        this.productService = productService;
        this.router = router;
        this.location = location;
    }
    /**Delete set product.
     * If it is the selected product, unset the selected product pointer  */
    DeleteProductComponent.prototype.delete = function (product) {
        var _this = this;
        this.productService
            .delete(product.id)
            .then(function () {
            _this.products = _this.products.filter(function (p) { return p !== product; });
            if (_this.selectedProduct === product) {
                _this.selectedProduct = null;
            }
        });
    };
    return DeleteProductComponent;
}());
DeleteProductComponent = __decorate([
    core_1.Component({
        selector: 'delete-product',
        template: "<h2>Product deleted successfully</h2>",
    }),
    __metadata("design:paramtypes", [product_service_1.ProductService,
        router_1.Router,
        Location])
], DeleteProductComponent);
exports.DeleteProductComponent = DeleteProductComponent;
//# sourceMappingURL=delete-product.component.js.map