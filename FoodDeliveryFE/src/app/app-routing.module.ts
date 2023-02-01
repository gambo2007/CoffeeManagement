import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { ForgotComponent } from './forgot/forgot.component';
import { CustomerComponent } from './customer/customer.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
//import { AuthGuard } from './auth/auth.guard';
import { CustomerRegistrationComponent } from './customer/customer-registration/customer-registration.component';
import { MenuViewComponent } from './menu-view/menu-view.component';
import { MenuViewItemComponent } from './menu-view/menu-view-item/menu-view-item.component';
import { AddCoffeeComponent } from './coffee/add-coffee/add-coffee.component';
import { DeleteCoffeeComponent } from './coffee/delete-coffee/delete-coffee.component';
import { CoffeeComponent } from './coffee/coffee.component';
import { UpdateCoffeeComponent } from './coffee/update-coffee/update-coffee.component';
import { ViewAllCoffeeComponent } from './coffee/view-all-coffee/view-all-coffee.component';
import { AddMenuComponent } from './menu/add-menu/add-menu.component';
import { MenuComponent } from './menu/menu.component';
import { DeleteMenuComponent } from './menu/delete-menu/delete-menu.component';
import { UpdateMenuComponent } from './menu/update-menu/update-menu.component';
import { ViewAllMenuComponent } from './menu/view-all-menu/view-all-menu.component';
import { CustomerDashboardComponent } from './customer/customer-dashboard/customer-dashboard.component';
import { AdminComponent } from './admin/admin.component';
import { AdminDashboardComponent } from './admin/admin-dashboard/admin-dashboard.component';
import { OwnerRegistrationComponent } from './owner/owner-registration/owner-registration.component';
import { AdminLogoutComponent } from './admin/admin-logout/admin-logout.component';
import { CustomerLogoutComponent } from './customer/customer-logout/customer-logout.component';
import { OwnerComponent } from './owner/owner.component';
import { OwnerDashboardComponent } from './owner/owner-dashboard/owner-dashboard.component';
import { OwnerLogoutComponent } from './owner/owner-logout/owner-logout.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AdminViewallaccountComponent } from './admin/admin-viewallaccount/admin-viewallaccount.component';
import { CartComponent } from './cart/cart.component';
import { AdminViewallonwerComponent } from './admin/admin-viewallonwer/admin-viewallonwer.component';



const routes: Routes = [
  {path: '', redirectTo:"dashboard/menu-view",pathMatch:"full"},
  {path: 'dashboard', component: NavbarComponent,
    children:[
      {path: 'home', component: HomeComponent},
      {path: 'about', component: AboutComponent},
      {path: 'contact', component: ContactComponent},
      {path: 'login', component: LoginComponent},
      {path: 'forgot', component: ForgotComponent},
      {path: 'customer/register', component: CustomerRegistrationComponent},
      {path: 'owner/register', component: OwnerRegistrationComponent},
      {path: 'profile', component: ProfileComponent},
      {path: 'cart', component: CartComponent},
      {path: 'menu-view', component: MenuViewComponent,
        children: [
          {path: 'menu-view-item/:id', component: MenuViewItemComponent},
        ]
      },
    ]
    },

  {path: 'customer', component: CustomerComponent,
  children: [
    {path: 'dashboard', component: CustomerDashboardComponent,
      children: [
        {path: 'cart', component: CartComponent},
        {path: 'menu-view', component: MenuViewComponent,
          children: [
            {path: 'menu-view-item/:id', component: MenuViewItemComponent},
                    ]
        },
        {path: 'home', component: HomeComponent},
        {path: 'about', component: AboutComponent},
        {path: 'contact', component: ContactComponent},
        {path: 'profile', component: ProfileComponent},
        {path: 'logout', component: CustomerLogoutComponent},
                 ]
    }
  ]
  },

  {path: 'admin', component: AdminComponent,
    children: [
      {path: 'dashboard', component: AdminDashboardComponent,
      children: [
        {path: 'cart', component: CartComponent},
        {path: 'menuitem', component: CoffeeComponent,
          children: [
            {path: 'view-all-menuitem', component: ViewAllCoffeeComponent},
            {path: 'add-menuitem', component: AddCoffeeComponent},
            {path: 'view-all-menuitem/update-menuitem/:id', component: UpdateCoffeeComponent},
            {path: 'view-all-menuitem/delete-menuitem/:id', component: DeleteCoffeeComponent},
          ]
        },
          {path: 'menu', component: MenuComponent,
            children: [
              {path: 'view-all-menu', component: ViewAllMenuComponent},
              {path: 'add-menu', component: AddMenuComponent},
              {path: 'view-all-menu/update-menu/:id', component: UpdateMenuComponent},
              {path: 'view-all-menu/delete-menu/:id', component: DeleteMenuComponent},

          ]
        },
        {path: 'menu-view', component: MenuViewComponent,
        children: [
          {path: 'menu-view-item/:id', component: MenuViewItemComponent},
        ]
      },
        {path: 'view', component: AdminViewallaccountComponent},
          {path: 'account-view', component: AdminViewallaccountComponent,
            children: [
              {path: 'account-view-item/:id', component: AdminViewallaccountComponent},
          ]
        },
          {path: 'onwer-view', component: AdminViewallonwerComponent,
            children: [
              {path: 'owner-view-item/:id', component: AdminViewallonwerComponent},
          ]
        },
          {path: 'profile', component: ProfileComponent},
          {path: 'logout', component: AdminLogoutComponent},
      ]
    
    },
    ]
  },


  {path: 'owner', component: OwnerComponent,
    children: [
      {path: 'dashboard', component: OwnerDashboardComponent,
        children: [
        {path: 'cart', component: CartComponent},
        {path: 'menuitem', component: CoffeeComponent,
          children: [
            {path: 'view-all-menuitem', component: ViewAllCoffeeComponent},
            {path: 'add-menuitem', component: AddCoffeeComponent},
            {path: 'view-all-menuitem/update-menuitem/:id', component: UpdateCoffeeComponent},
            {path: 'view-all-menuitem/delete-menuitem/:id', component: DeleteCoffeeComponent},
          ]
        },
          {path: 'menu', component: MenuComponent,
            children: [
              {path: 'view-all-menu', component: ViewAllMenuComponent},
              {path: 'add-menu', component: AddMenuComponent},
              {path: 'view-all-menu/update-menu/:id', component: UpdateMenuComponent},
              {path: 'view-all-menu/delete-menu/:id', component: DeleteMenuComponent},

          ]
        },
          {path: 'menu-view', component: MenuViewComponent,
            children: [
              {path: 'menu-view-item/:id', component: MenuViewItemComponent},
          ]
        },
          {path: 'profile', component: ProfileComponent},
          {path: 'logout', component: OwnerLogoutComponent},
      ]
    
    },
    ]
  },

  {path: 'menuitem', component: CoffeeComponent,
    children: [
      {path: 'view-all-menuitem', component: ViewAllCoffeeComponent},
      {path: 'add-menuitem', component: AddCoffeeComponent},
      {path: 'update-menuitem/:id', component: UpdateCoffeeComponent},
      {path: 'delete-menuitem/:id', component: DeleteCoffeeComponent},
    ]
  },

  {path: 'menu', component: MenuComponent,
    children: [
      {path: 'view-all-menu', component: ViewAllMenuComponent},
      {path: 'add-menu', component: AddMenuComponent},
      {path: 'update-menu/:id', component: UpdateMenuComponent},
      {path: 'delete-menu/:id', component: DeleteMenuComponent},

    ]
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
