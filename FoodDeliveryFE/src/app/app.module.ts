import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';

import { ContactComponent } from './contact/contact.component';
import { CoffeeComponent } from './coffee/coffee.component';
import { AddCoffeeComponent } from './coffee/add-coffee/add-coffee.component';
import { ViewAllCoffeeComponent } from './coffee/view-all-coffee/view-all-coffee.component';
import { UpdateCoffeeComponent } from './coffee/update-coffee/update-coffee.component';
import { DeleteCoffeeComponent } from './coffee/delete-coffee/delete-coffee.component';
import { MenuComponent } from './menu/menu.component';
import { ViewAllMenuComponent } from './menu/view-all-menu/view-all-menu.component';
import { AddMenuComponent } from './menu/add-menu/add-menu.component';
import { UpdateMenuComponent } from './menu/update-menu/update-menu.component';
import { DeleteMenuComponent } from './menu/delete-menu/delete-menu.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { ForgotComponent } from './forgot/forgot.component';
import { ProfileComponent } from './profile/profile.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CustomerComponent } from './customer/customer.component';
import { CustomerRegistrationComponent } from './customer/customer-registration/customer-registration.component';
import { MenuViewComponent } from './menu-view/menu-view.component';
import { MenuViewItemComponent } from './menu-view/menu-view-item/menu-view-item.component';
import { CustomerDashboardComponent } from './customer/customer-dashboard/customer-dashboard.component';
import { AdminComponent } from './admin/admin.component';
import { OwnerComponent } from './owner/owner.component';
import { OwnerRegistrationComponent } from './owner/owner-registration/owner-registration.component';
import { CustomerLogoutComponent } from './customer/customer-logout/customer-logout.component';
import { AdminLogoutComponent } from './admin/admin-logout/admin-logout.component';
import { AdminDashboardComponent } from './admin/admin-dashboard/admin-dashboard.component';
import { OwnerLogoutComponent } from './owner/owner-logout/owner-logout.component';
import { OwnerDashboardComponent } from './owner/owner-dashboard/owner-dashboard.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AdminViewallaccountComponent } from './admin/admin-viewallaccount/admin-viewallaccount.component';
import { CartComponent } from './cart/cart.component';
import { AdminViewallonwerComponent } from './admin/admin-viewallonwer/admin-viewallonwer.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    CoffeeComponent,
    AddCoffeeComponent,
    ViewAllCoffeeComponent,
    UpdateCoffeeComponent,
    DeleteCoffeeComponent,
    MenuComponent,
    ViewAllMenuComponent,
    AddMenuComponent,
    UpdateMenuComponent,
    DeleteMenuComponent,
    MenuViewComponent,
    MenuViewItemComponent,
    ContactComponent,
    LoginComponent,
    ForgotComponent,
    ProfileComponent,
    CustomerComponent,
    CustomerRegistrationComponent,
    CustomerDashboardComponent,
    AdminComponent,
    OwnerComponent,
    OwnerRegistrationComponent,
    CustomerLogoutComponent,
    AdminLogoutComponent,
    AdminDashboardComponent,
    OwnerLogoutComponent,
    OwnerDashboardComponent,
    NavbarComponent,
    AdminViewallaccountComponent,
    CartComponent,
    AdminViewallonwerComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatCardModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
