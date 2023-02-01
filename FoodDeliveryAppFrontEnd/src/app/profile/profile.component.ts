import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerRegistration } from '../customer/customer-registration';
import { CustomerService } from '../customer/customer.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  users:CustomerRegistration[] = [];
  user: CustomerRegistration = new CustomerRegistration(0,"","",0,"",new Date(),0,"","");
  constructor(
   private CustomerService:CustomerService,private router: Router
  ) {}

  ngOnInit() {
    this.CustomerService.getAllUser().subscribe(data=>{
      this.users =data;
      this.users.forEach(element => {
        if(element.email == sessionStorage.getItem("email")){
          this.user = element;
        }
      });
    },
    error => {
      console.log(error);
    })
  }


}
