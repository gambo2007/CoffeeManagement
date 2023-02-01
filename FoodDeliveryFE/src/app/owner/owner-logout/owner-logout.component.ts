import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from 'src/app/cart/cart.service';

@Component({
  selector: 'app-owner-logout',
  templateUrl: './owner-logout.component.html',
  styleUrls: ['./owner-logout.component.css']
})
export class OwnerLogoutComponent implements OnInit {

  constructor(private router: Router,private cartService: CartService) { 
    sessionStorage.clear();
    let choice:boolean = confirm("Do you really want to logout?");
    if(choice){
      sessionStorage.clear();
      this.cartService.clearCart();
      this.router.navigateByUrl("/");
    }else{
      this.router.navigateByUrl("owner/dashboard");
    }

  }

  ngOnInit() {
  }

}
