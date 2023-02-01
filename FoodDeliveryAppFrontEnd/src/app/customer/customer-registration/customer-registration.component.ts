import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../customer.service';
import { Router } from '@angular/router';
import {CustomerRegistration} from '../customer-registration';
@Component({
  selector: 'app-customer-registration',
  templateUrl: './customer-registration.component.html',
  styleUrls: ['./customer-registration.component.css']
})
export class CustomerRegistrationComponent implements OnInit {
  customer: CustomerRegistration = new CustomerRegistration(0,"","",0,"",new Date(),0,"","");
  constructor(private _customerService: CustomerService,private _router: Router) { }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.customer);
    this._customerService.registerCustomer(this.customer).subscribe(
      data => {
        alert("Customer successfully registered");
        this.customer.cusName = "";
        this.customer.email = "";
        this.customer.address = "";
        this.customer.bod = new Date();
        this.customer.username = "";
        this.customer.password = "";
        this._router.navigateByUrl("/dashboard/login");
      },
      errorObj => {
        alert(errorObj.error.message);
      }
    )
  }
}
