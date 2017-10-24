import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
 
import { DashboardComponent }     from './dashboard.component';
import { ProductsComponent }      from './products.component';
import { ProductDetailComponent } from './product-detail.component';
import { ContactUsComponent }     from './contact-us.component';
import { AddProductComponent }    from './add-product.component';
import { DeleteProductComponent } from './delete-product.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard',  component: DashboardComponent },
  { path: 'detail/:id', component: ProductDetailComponent },
  { path: 'products',   component: ProductsComponent },
  { path: 'contact-us', component: ContactUsComponent },
  { path: 'add',        component: AddProductComponent },
  { path: 'delete',     component: DeleteProductComponent }, 
];
 
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}