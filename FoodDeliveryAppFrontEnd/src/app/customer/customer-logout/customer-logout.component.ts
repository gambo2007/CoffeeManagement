import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from 'src/app/cart/cart.service';

@Component({
  selector: 'app-customer-logout',
  templateUrl: './customer-logout.component.html',
  styleUrls: ['./customer-logout.component.css']
})
export class CustomerLogoutComponent implements OnInit {

  constructor(private router: Router, private cartService: CartService) { 
    let choice:boolean = confirm("Do you really want to logout?");
    if(choice){
      sessionStorage.clear();
      this.cartService.clearCart();
      this.router.navigateByUrl("/");
    }else{
      this.router.navigateByUrl("customer/dashboard");
    }

  }

  ngOnInit() {
  }

}
