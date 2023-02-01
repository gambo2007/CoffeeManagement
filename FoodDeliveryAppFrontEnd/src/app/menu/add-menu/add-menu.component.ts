import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Menu } from '../menu';
import { MenuService } from '../menu.service';

@Component({
  selector: 'app-add-menu',
  templateUrl: './add-menu.component.html',
  styleUrls: ['./add-menu.component.css']
})
export class AddMenuComponent implements OnInit {

  userFile;
  public imagePath;
  imgURL: any;

  menu: Menu = new Menu(0,"","","");

  constructor(private _menuService: MenuService, private _router: Router) { }

  ngOnInit() {
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
    console.log(this.menu);
    this._menuService.addMenu(this.menu).subscribe(
      data => {
        alert("Menu successfully added");
        this.menu.menu_name = "";
        this.menu.description = "";
        this.menu.img = "";
        this.imgURL ="";
      },
      errorObj => {
        alert(errorObj.error.message);
      }
    )
  }

}
