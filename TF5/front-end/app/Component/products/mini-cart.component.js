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
var homeService_1 = require("./homeService");
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var MiniCartComponent = (function () {
    function MiniCartComponent(homeService, router) {
        this.homeService = homeService;
        this.router = router;
    }
    MiniCartComponent.prototype.ngOnInit = function () {
        this.minicart = this.homeService.minicart;
    };
    return MiniCartComponent;
}());
MiniCartComponent = __decorate([
    core_1.Component({
        selector: 'mini-cart',
        templateUrl: './mini-cart.component.html',
        providers: [homeService_1.HomeService]
    }),
    __metadata("design:paramtypes", [homeService_1.HomeService,
        router_1.Router])
], MiniCartComponent);
exports.MiniCartComponent = MiniCartComponent;
//# sourceMappingURL=mini-cart.component.js.map