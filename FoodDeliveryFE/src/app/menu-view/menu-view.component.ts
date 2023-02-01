import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Menu } from '../menu/menu';
import { MenuService } from '../menu/menu.service';
import { CartService } from 'src/app/cart/cart.service';


@Component({
  selector: 'app-menu-view',
  templateUrl: './menu-view.component.html',
  styleUrls: ['./menu-view.component.css']
})
export class MenuViewComponent implements OnInit {
  username: string ="";
  public menus: Menu[];
  cartnum: number;

  constructor(private _menuService: MenuService,private router:Router, private _cartService: CartService) {
   
  }

  ngOnInit() {
    this.cartnum = this._cartService.items.length;
    console.log(this._cartService.items.length);
    this._menuService.getAllMenu().subscribe(
      data => {
        this.menus = data;
        for(let i=0; i<this.menus.length; i++){
          console.log(this.menus[i]);
        }
      },

      error => {
        console.log(error);
      }
    )
  }
  
}
