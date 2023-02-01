import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from 'src/app/login/login.service';
import { User } from 'src/app/login/User';

@Component({
  selector: 'app-admin-viewallonwer',
  templateUrl: './admin-viewallonwer.component.html',
  styleUrls: ['./admin-viewallonwer.component.css']
})
export class AdminViewallonwerComponent implements OnInit {
  users: User[] = [];
  constructor(private _activatedRoute: ActivatedRoute, private _LoginService: LoginService, private _router: Router) { }
  userss:User[]= [];
  
ngOnInit() {
  this._LoginService.getAllUser().subscribe(
    data => {
      this.users = data;
      this.users.forEach(user=>{
        if(user.role === 'ROLE_Owner'){
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