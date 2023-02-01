import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';
import {User} from './User';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User = new User("","","",0,"");
  constructor(
   private loginService:LoginService,private router: Router
  ) {}

  ngOnInit() {
  }


  onSubmit() {
    this.loginService.authenticate(this.user).subscribe(data =>{
      sessionStorage.setItem("username",data.username);
      sessionStorage.setItem("email",data.email);
      if(data.role ==='ROLE_CUSTOMER'){
        this.router.navigateByUrl("customer/dashboard/menu-view")
      }
      if(data.role ==='ROLE_ADMIN'){
        this.router.navigateByUrl("admin/dashboard/onwer-view")
      }
      if(data.role ==='ROLE_Owner'){
        this.router.navigateByUrl("owner/dashboard/menu")
      }
    },errorObj =>{
      alert(errorObj.error.message);
    }
    )
  }
  
}