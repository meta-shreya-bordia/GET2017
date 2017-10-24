import { Component, OnInit } from '@angular/core';
import { Router }            from '@angular/router';
 
import { Observable }        from 'rxjs/Observable';
import { Subject }           from 'rxjs/Subject';
 
// Observable class extensions
import 'rxjs/add/observable/of';
 
// Observable operators
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
 
import { ProductSearchService } from './product-search.service';
import { Product } from './product';
 
@Component({
  selector: 'product-search',
  templateUrl: './product-search.service.html',   
  providers: [ProductSearchService]
})
export class ProductSearchComponent implements OnInit {
  products: Observable<Product[]>;
  private searchTerms = new Subject<string>();
 
  constructor(
    private productSearchService: ProductSearchService,
    private router: Router
  ) {}
 
  // Push a search term into the observable stream.
  search(term: string): void {
    this.searchTerms.next(term);
  }
 
  /**
   * 
   * switch to new observable each time the term changes
   *    return the http search observable
   * else the observable of empty products if there was no search term
   */
  ngOnInit(): void {
    this.products = this.searchTerms
      .debounceTime(300)        // wait 300ms after each keystroke before considering the term
      .distinctUntilChanged()   // ignore if next search term is same as previous
      .switchMap(
        term => term   
        ? this.productSearchService.search(term)
        : Observable.of<Product[]>([])
      )
      .catch(error => {
        console.log(error);
        return Observable.of<Product[]>([]);
      });
  }
 
  goToDetail(product: Product): void {
    let link = ['/detail', product.id];
    this.router.navigate(link);
  }
}