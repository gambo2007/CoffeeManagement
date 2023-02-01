import { Component, OnInit } from '@angular/core';
import { Menu } from '../menu';
import { MenuService } from '../menu.service';

@Component({
  selector: 'app-view-all-menu',
  templateUrl: './view-all-menu.component.html',
  styleUrls: ['./view-all-menu.component.css']
})
export class ViewAllMenuComponent implements OnInit {

  private menus: Menu[];
  

  constructor(private _menuService: MenuService) {
  }

  ngOnInit() {
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
