import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerRegistration } from './customer-registration';
import { CustomerService } from './customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  users:CustomerRegistration[];
  user: CustomerRegistration = new CustomerRegistration(0,"","",0,"",new Date(),0,"","");
  constructor(
   private CustomerService:CustomerService,private router: Router
  ) {}

  ngOnInit() {
    this.CustomerService.getAllUser().subscribe(data=>{
      this.users =data;
      console.log(this.users);
    },
    error => {
      console.log(error);
    })
  }
  
}