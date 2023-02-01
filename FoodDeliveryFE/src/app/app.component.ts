import { Component,OnInit } from '@angular/core';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Coffee-management-app';

  isLoggedIn$: Observable<boolean>;

  constructor() { }

  ngOnInit() {
  }

  


}
