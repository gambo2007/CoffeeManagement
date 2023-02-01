import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-owner-dashboard',
  templateUrl: './owner-dashboard.component.html',
  styleUrls: ['./owner-dashboard.component.css']
})
export class OwnerDashboardComponent implements OnInit {
  username:string ="";
  constructor() { }

  ngOnInit() {
    this.username = sessionStorage.getItem("username");
  }

}
