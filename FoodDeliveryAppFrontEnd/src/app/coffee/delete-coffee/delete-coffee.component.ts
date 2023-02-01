import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CoffeeService } from '../coffee.service';

@Component({
  selector: 'app-delete-coffee',
  templateUrl: './delete-coffee.component.html',
  styleUrls: ['./delete-coffee.component.css']
})
export class DeleteCoffeeComponent implements OnInit {

  constructor(private _activatedRoute: ActivatedRoute, private _coffeeService: CoffeeService, private _router: Router) { }
  ngOnInit() {

    let coffeeId: number = 0;
    this._activatedRoute.params.subscribe(data => {
      coffeeId = data.id;

      this._coffeeService.deleteCoffee(coffeeId).subscribe(data => {
          alert("Menu Item with id "+coffeeId+" deleted successfully")
    }, errorObj => {
      alert(errorObj.error.msg);
    })  
  })
  }

}
