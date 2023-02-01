import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from 'src/app/login/login.service';
import { User } from 'src/app/login/User';
@Component({
  selector: 'app-admin-viewallaccount',
  templateUrl: './admin-viewallaccount.component.html',
  styleUrls: ['./admin-viewallaccount.component.css']
})
export class AdminViewallaccountComponent implements OnInit {
  users: User[] = [];
  constructor(private _activatedRoute: ActivatedRoute, private _LoginService: LoginService, private _router: Router) { }
  userss:User[]=[];
  
ngOnInit() {
  this._LoginService.getAllUser().subscribe(
    data => {
      this.users = data;
      this.users.forEach(user=>{
        if(user.role === 'ROLE_CUSTOMER'){
          this.userss.push(user);
        }
      })
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