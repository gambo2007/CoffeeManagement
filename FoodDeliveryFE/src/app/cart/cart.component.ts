import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/cart/cart.service';
import { ActivatedRoute, Router } from '@angular/router';
import { registerLocaleData } from '@angular/common';
import localeIt from '@angular/common/locales/it'
registerLocaleData(localeIt, 'it');

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  items = this.cartService.items;
  total: number = 0;
  username:string ="";
  message: string;
  
  constructor(private cartService: CartService, private _activatedRoute: ActivatedRoute,  private _router: Router) { 
    this.items = cartService.items;
    this.total = cartService.total;
  }

  ngOnInit() {
    this.username = sessionStorage.getItem("username");
    if(this.items.length<=0){
      this.message="There is no item in cart!"
    }
    else{
      this.message = "Thanks for your order!"
    }
  }

  placeOrder(){
    alert("Order Successfully");
    this.items = [];
    this.total = 0;
    this.cartService.clearCart();
  }
}
