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
var userMiniCartDetail_1 = require("./userMiniCartDetail");
var homeService_1 = require("./homeService");
var MainComponent = (function () {
    function MainComponent(homeservice) {
        this.homeservice = homeservice;
        this.title = "Shopping Cart";
    }
    MainComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.homeservice.login('abc').then(function (response) {
            _this.minicart = response;
        });
    };
    return MainComponent;
}());
__decorate([
    core_1.Input(),
    __metadata("design:type", Object)
], MainComponent.prototype, "title", void 0);
__decorate([
    core_1.Input(),
    __metadata("design:type", Boolean)
], MainComponent.prototype, "isUserLoggedIn", void 0);
__decorate([
    core_1.Input(),
    __metadata("design:type", userMiniCartDetail_1.MiniCart)
], MainComponent.prototype, "minicart", void 0);
MainComponent = __decorate([
    core_1.Component({
        selector: 'app-header',
        templateUrl: './main.component.html',
        styleUrls: ['./main.component.css']
    }),
    __metadata("design:paramtypes", [homeService_1.HomeService])
], MainComponent);
exports.MainComponent = MainComponent;
//# sourceMappingURL=main.component.js.map