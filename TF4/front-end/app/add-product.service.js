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
var http_1 = require("@angular/http");
require("rxjs/add/operator/toPromise");
var product_service_1 = require("./product.service");
var AddProductService = (function () {
    function AddProductService(http, productService) {
        this.http = http;
        this.productService = productService;
        //To make persistent data changes to server data
        this.headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        // URL to web api: Get in-memory product list
        this.productsUrl = 'api/PRODUCT_LIST';
    }
    AddProductService.prototype.handleError = function (error) {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    };
    /***OLD METHOD CLASS */
    AddProductService.prototype.create = function (name, price) {
        return this.http
            .post(this.productsUrl, JSON.stringify({ name: name, price: price }), { headers: this.headers })
            .toPromise()
            .then(function (res) { return res.json().data; })
            .catch(this.handleError);
    };
    return AddProductService;
}());
AddProductService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http,
        product_service_1.ProductService])
], AddProductService);
exports.AddProductService = AddProductService;
//# sourceMappingURL=add-product.service.js.map