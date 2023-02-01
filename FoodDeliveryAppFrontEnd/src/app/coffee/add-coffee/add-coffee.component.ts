import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Menu } from 'src/app/menu/menu';
import { MenuService } from 'src/app/menu/menu.service';
import { Coffee } from '../coffee';
import { CoffeeService } from '../coffee.service';

@Component({
  selector: 'app-add-coffee',
  templateUrl: './add-coffee.component.html',
  styleUrls: ['./add-coffee.component.css']
})
export class AddCoffeeComponent implements OnInit {
  userFile;
  public imagePath;
  imgURL: any;

  coffee: Coffee = new Coffee(0,"","",0.0, new Menu(0,"","", ""), "");

  menus: Menu[] = [];
  menu1: Menu[];

  constructor(private _menuService: MenuService, private _coffeeService: CoffeeService, private router: Router) { 
    this._menuService.getAllMenu().subscribe(
      data => {
          this.menu1 = data;
          this.menu1.forEach(menu=>{
          if(menu.menu_name!="All"){
            this.menus.push(menu);
          }
        });
      },
      errorObj => {
        alert(errorObj.error.message);
      }
    )
  }

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
        this.coffee.img = this.imgURL;
      }
    }
  }

  onSubmit() {

    let menuName = this.coffee.menu.menu_name;
    
    this.menus.forEach(menu => {
      if(menu.menu_name === menuName) {
        this.coffee.menu.menu_Id = menu.menu_Id;
        this.coffee.menu.description = menu.description;
        console.log(menu);
      }
    })

    console.log(this.coffee);
   

    
    this._coffeeService.addCoffee(this.coffee).subscribe(data => {
        alert("Menu Item added successfully");
        this.coffee = new Coffee(0, "", "", 0.0, new Menu(0,"","", ""), "");
        this.imgURL ="";
      },
     errorObj => {
        alert(errorObj.error.message);
      });
  }
}
