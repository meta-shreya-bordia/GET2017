"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var platform_browser_1 = require("@angular/platform-browser");
var forms_1 = require("@angular/forms"); // <-- NgModel lives here
var http_1 = require("@angular/http");
// Imports for loading & configuring the in-memory web api
var product_detail_component_1 = require("./product-detail.component");
var products_component_1 = require("./products.component");
var app_component_1 = require("./app.component");
var dashboard_component_1 = require("./dashboard.component");
var contact_us_component_1 = require("./contact-us.component");
var product_service_1 = require("./product.service");
var product_search_component_1 = require("./product-search.component");
var add_product_component_1 = require("./add-product.component");
var delete_product_component_1 = require("./delete-product.component");
var app_routing_module_1 = require("./app-routing.module");
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    core_1.NgModule({
        imports: [
            platform_browser_1.BrowserModule,
            forms_1.FormsModule,
            app_routing_module_1.AppRoutingModule,
            http_1.HttpModule,
        ],
        declarations: [
            app_component_1.AppComponent,
            product_detail_component_1.ProductDetailComponent,
            products_component_1.ProductsComponent,
            dashboard_component_1.DashboardComponent,
            contact_us_component_1.ContactUsComponent,
            product_search_component_1.ProductSearchComponent,
            add_product_component_1.AddProductComponent,
            delete_product_component_1.DeleteProductComponent
        ],
        providers: [product_service_1.ProductService],
        bootstrap: [app_component_1.AppComponent]
    })
], AppModule);
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map