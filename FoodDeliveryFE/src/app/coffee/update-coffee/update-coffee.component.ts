import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Menu } from 'src/app/menu/menu';
import { MenuService } from 'src/app/menu/menu.service';
import { Coffee } from '../coffee';
import { CoffeeService } from '../coffee.service';

@Component({
  selector: 'app-update-coffee',
  templateUrl: './update-coffee.component.html',
  styleUrls: ['./update-coffee.component.css']
})
export class UpdateCoffeeComponent implements OnInit {

  userFile;
  public imagePath;
  imgURL: any;

  coffee: Coffee = new Coffee(0,"","",0.0,new Menu(0,"","",""),"");

  menus: Menu[] = [];
  menu1: Menu[];

  constructor(private _activatedRoute: ActivatedRoute, private _coffeeService: CoffeeService, private _menuService: MenuService, private _router: Router) { }

  ngOnInit() {
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
    let coffeeId: number = 0;
    this._activatedRoute.params.subscribe(data => {
      coffeeId = data.id;

      this._coffeeService.getCoffeeById(coffeeId).subscribe(data => {
          this.coffee = data;
          this.imgURL = this.coffee.img;
          console.log(this.coffee.menu.menu_name);
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
        this.coffee.img = this.imgURL;
      }
    }
  }

  onSubmit() {
    this._coffeeService.updateCoffee(this.coffee).subscribe(
      data => {
        alert("Menu Item successfully updated");
        this.coffee.coffee_name = "";
        this.coffee.desc = "";
        this.coffee.img = "";
        this.coffee.price = 0.0;
        this.coffee.menu = new Menu(0,"","","");
        this.imgURL = "";
      },
      errorObj => {
        alert(errorObj.error.message);
      }
    )
  }

}
