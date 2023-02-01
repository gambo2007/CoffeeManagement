import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer-dashboard',
  templateUrl: './customer-dashboard.component.html',
  styleUrls: ['./customer-dashboard.component.css']
})
export class CustomerDashboardComponent implements OnInit {
  username: string ="";
  constructor() { }

  ngOnInit() {
    this.username = sessionStorage.getItem("username");
  }

}
