"use strict";
var InMemoryDataService = (function () {
    function InMemoryDataService() {
    }
    InMemoryDataService.prototype.createDb = function () {
        var PRODUCT_LIST = [
            { id: 11, name: 'Reebok Shoes', price: 110.11, img: './app/product-images/shoes1.jpg', },
            { id: 12, name: 'Nike Shoes', price: 130.33, img: './app/product-images/shoes2.jpg' },
            { id: 13, name: 'Bata Shoes', price: 110.88, img: './app/product-images/shoes3.jpg' },
            { id: 14, name: 'Clarks Shoes', price: 110.91, img: './app/product-images/shoes4.jpg' },
            { id: 15, name: 'Jimmy Cho Shoes', price: 1780.11, img: './app/product-images/shoes5.jpg', },
            { id: 16, name: 'Adidas Shoes', price: 110.99, img: './app/product-images/shoes6.jpg' },
            { id: 17, name: 'Liberty Shoes', price: 1090.1, img: './app/product-images/shoes7.jpg' },
            { id: 18, name: 'Woodland Shoes', price: 10.10, img: './app/product-images/shoes8.jpg' },
            { id: 19, name: 'Converse Shoes', price: 999.99, img: './app/product-images/shoes9.jpg' }
        ];
        return { PRODUCT_LIST: PRODUCT_LIST };
    };
    return InMemoryDataService;
}());
exports.InMemoryDataService = InMemoryDataService;
//# sourceMappingURL=in-memory-data.service.js.map