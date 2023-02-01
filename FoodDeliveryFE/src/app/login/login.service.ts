import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import { User } from './User';

@Injectable({
    providedIn: 'root'
})

export class LoginService{
    constructor(private _httpClient: HttpClient){}

    authenticate(user:User):Observable<User>{
        let url="http://localhost:9090/user/login";
        return this._httpClient.post<User>(url,user)
    }

    getAllUser():Observable<User[]>{
        let url: string = "http://localhost:9090/user/getall";
        return this._httpClient.get<User[]>(url);
    }

}