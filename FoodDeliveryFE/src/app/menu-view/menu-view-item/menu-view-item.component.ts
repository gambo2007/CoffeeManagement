import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Menu } from '../../menu/menu';
import { Coffee } from '../../coffee/coffee';
import { CoffeeService } from '../../coffee/coffee.service';
import { MenuService } from '../../menu/menu.service';
import { CartService } from 'src/app/cart/cart.service';
import { registerLocaleData } from '@angular/common';
import localeIt from '@angular/common/locales/it'
registerLocaleData(localeIt, 'it');

@Component({
  selector: 'app-menu-view-item',
  templateUrl: './menu-view-item.component.html',
  styleUrls: ['./menu-view-item.component.css']
})
export class MenuViewItemComponent implements OnInit {

    coffees: Coffee[] = [];
    constructor(private _activatedRoute: ActivatedRoute, private _coffeeService: CoffeeService, private _menuService: MenuService, private _router: Router, private _cartService: CartService) {
      this.cartnum = _cartService.items.length;
    }
    coffee1: Coffee[];
    cofees: Coffee[];
    menu: Menu;
    cartnum: number;

  addToCart(item: Coffee){
    this._cartService.addToCart(item);
    this.cartnum = this._cartService.items.length;
  }

  ngOnInit() {
    let menuId: number = 0;
    this._activatedRoute.params.subscribe(data => {
      menuId = data.id;

      this._menuService.getMenuById(menuId).subscribe(data => {
        this.menu = data;
        this.menu.menu_Id = menuId;
      }, errorObj => {
        alert(errorObj.error.message);
      })

      this._coffeeService.getAllCoffee().subscribe(data => {
        this.coffee1 = data;
              
        this.coffees = [];

        this.coffee1.forEach(coffee=>{
            if(this.menu.menu_name=="All"){
            this.coffees = this.coffee1;
            }else{
            if(coffee.menu.menu_Id==menuId){
                this.coffees.push(coffee);
            }
            }
        });
      },
      errorObj => {
        alert(errorObj.error.message);
      });

    });
  }
  checklogin(){
    if(sessionStorage.getItem("username") == null){
      this._router.navigateByUrl("/login")
    }
  }

}