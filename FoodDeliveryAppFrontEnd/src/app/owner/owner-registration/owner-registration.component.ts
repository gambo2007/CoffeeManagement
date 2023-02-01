import { Component, OnInit } from '@angular/core';
import { OwnerRegistration } from '../owner-registration';
import { OwnerService } from '../owner.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-owner-registration',
  templateUrl: './owner-registration.component.html',
  styleUrls: ['./owner-registration.component.css']
})
export class OwnerRegistrationComponent implements OnInit {
  owner: OwnerRegistration = new OwnerRegistration(0,"","",0,"",new Date(),0,"","");
  constructor(private _ownerService: OwnerService,private _router: Router) { }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.owner);
    this._ownerService.registerOwner(this.owner).subscribe(
      data => {
        alert("Owner successfully registered");
        sessionStorage.setItem("cusName",data.ownerName);
        sessionStorage.setItem("email",data.email);
        sessionStorage.setItem("address",data.address);
        this.owner.ownerName = "";
        this.owner.email = "";
        this.owner.address = "";
        this.owner.bod = new Date();
        this.owner.username = "";
        this.owner.password = "";
        this._router.navigateByUrl("/dashboard/login");
      },
      errorObj => {
        alert(errorObj.error.message);
      }
    )
  }
}
