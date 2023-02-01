import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from 'src/app/cart/cart.service';


@Component({
  selector: 'app-admin-logout',
  templateUrl: './admin-logout.component.html',
  styleUrls: ['./admin-logout.component.css']
})
export class AdminLogoutComponent implements OnInit {

  constructor(private router: Router, private cartService: CartService) { 
    let choice:boolean = confirm("Do you really want to logout?");
    if(choice){
      sessionStorage.clear();
      this.cartService.clearCart();
      this.router.navigateByUrl("/");
    }else{
      this.router.navigateByUrl("admin/dashboard");
    }
  }

  ngOnInit() {
    
  }
}
