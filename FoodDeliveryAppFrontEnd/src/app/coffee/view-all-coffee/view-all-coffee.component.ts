import { Component, OnInit } from '@angular/core';
import { Coffee } from '../coffee';
import { CoffeeService } from '../coffee.service';

@Component({
  selector: 'app-view-all-coffee',
  templateUrl: './view-all-coffee.component.html',
  styleUrls: ['./view-all-coffee.component.css']
})
export class ViewAllCoffeeComponent implements OnInit {

  coffees: Coffee[] = [];
  constructor(private _coffeeService: CoffeeService) { }

  ngOnInit() {
    this._coffeeService.getAllCoffee().subscribe(data => {
      this.coffees = data;
    },
    errorObj => {
      alert(errorObj.error.message);
    })
  }

}
