import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OwnerRegistration } from './owner-registration';
import { OwnerService } from './owner.service';

@Component({
  selector: 'app-owner',
  templateUrl: './owner.component.html',
  styleUrls: ['./owner.component.css']
})
export class OwnerComponent implements OnInit {
  users:OwnerRegistration[];
  user:OwnerRegistration = new OwnerRegistration(0,"","",0,"",new Date(),0,"","");

  constructor(
    private OwnerService:OwnerService,private router: Router

  ) { }

  ngOnInit() {
    this.OwnerService.getAllUser().subscribe(data=>{
      this.users =data;
      console.log(this.users);
    },
    error => {
      console.log(error);
    })
  }

}
