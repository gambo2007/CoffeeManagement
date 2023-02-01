import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Menu } from '../menu';
import { MenuService } from '../menu.service';

@Component({
  selector: 'app-update-menu',
  templateUrl: './update-menu.component.html',
  styleUrls: ['./update-menu.component.css']
})
export class UpdateMenuComponent implements OnInit {

  userFile;
  public imagePath;
  imgURL: any;

  menu: Menu = new Menu(0, "", "", "");

  constructor(private _activatedRoute: ActivatedRoute, private _menuService: MenuService, private _router: Router) { }

  ngOnInit() {
    let menuId: number = 0;
    this._activatedRoute.params.subscribe(data => {
      menuId = data.id;
      this._menuService.getMenuById(menuId).subscribe(data => {
          this.menu = data;
          this.menu.menu_Id = menuId;
          this.imgURL = this.menu.img;
      }, errorObj => {
          alert(errorObj.error.message);
      })
    })

  }

  onSelectFile(event){
    if(event.target.files.length>0){
      const file = event.target.files[0];
      this.userFile = file;
      //this.f['profile'].setValue(file);
      var mineType = event.target.files[0].type;
      if(mineType.match(/image\/*/)==null){
        alert("Only images are supported.");
        return;
      }
      var reader = new FileReader();

      this.imagePath = file;
      reader.readAsDataURL(file);
      reader.onload = (_event) =>{
        this.imgURL = reader.result;
        this.menu.img = this.imgURL;
      }
    }
  }

  onSubmit() {
    this._menuService.updateMenu(this.menu).subscribe(
      data => {
        alert("Menu successfully updated");
        this.menu.menu_name = "";
        this.menu.description = "";
        this.imgURL = "";
      },
      errorObj => {
        alert(errorObj.error.message);
      }
    )
  }

}
