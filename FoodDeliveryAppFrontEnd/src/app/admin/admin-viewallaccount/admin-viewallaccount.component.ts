import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerRegistration } from 'src/app/customer/customer-registration';
import { CustomerService } from 'src/app/customer/customer.service';
import { LoginService } from 'src/app/login/login.service';
import { User } from 'src/app/login/User';
@Component({
  selector: 'app-admin-viewallaccount',
  templateUrl: './admin-viewallaccount.component.html',
  styleUrls: ['./admin-viewallaccount.component.css']
})
export class AdminViewallaccountComponent implements OnInit {
  users: User[] = [];
  constructor(private _activatedRoute: ActivatedRoute, private _LoginService: LoginService,private CustomerService:CustomerService ,private _router: Router) { }
  userss:User[]=[];
  
  customers:CustomerRegistration[] = [];
  customer: CustomerRegistration = new CustomerRegistration(0,"","",0,"",new Date(),0,"","");

  


ngOnInit() {
  this._LoginService.getAllUser().subscribe(
    data => {
      this.users = data;
      this.users.forEach(user=>{
        if(user.role === 'ROLE_CUSTOMER'){
          this.userss.push(user);
          console.log(this.userss);
        }
      })
    }),

    this.CustomerService.getAllUser().subscribe(data=>{
      this.customers =data;
      this.customers.forEach(element => {
        if(element.email == sessionStorage.getItem("email")){
          this.customer = element;
        }
      });
    },

    error => {
      console.log(error);
    }
  )
}
deleteAcc(){
  alert("The function is under developing");
}

}