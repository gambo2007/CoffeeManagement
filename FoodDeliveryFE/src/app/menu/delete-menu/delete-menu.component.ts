import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MenuService } from '../menu.service';

@Component({
  selector: 'app-delete-menu',
  templateUrl: './delete-menu.component.html',
  styleUrls: ['./delete-menu.component.css']
})
export class DeleteMenuComponent implements OnInit {

  constructor(private _activatedRoute: ActivatedRoute, private _menuService: MenuService, private _router: Router) { }
  ngOnInit() {

    let menuId: number = 0;
    this._activatedRoute.params.subscribe(data => {
      menuId = data.id;

      this._menuService.deleteMenu(menuId).subscribe(data => {
          alert("Menu with id "+ menuId+" deleted successfully");
      }, errorObj => {
        alert(errorObj.error.msg);
      })  
    })
  }
}
