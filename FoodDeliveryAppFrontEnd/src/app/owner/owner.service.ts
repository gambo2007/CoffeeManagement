import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {OwnerRegistration} from './owner-registration';

@Injectable({
    providedIn: 'root'
  })
export class OwnerService{
    constructor(private _httpClient: HttpClient){
    }

    registerOwner(owner: OwnerRegistration):Observable<OwnerRegistration>{
        let url = "http://localhost:9090/owner/register";
        return this._httpClient.post<OwnerRegistration>(url,owner);
    }
    getAllUser():Observable<OwnerRegistration[]>{
        let url: string = "http://localhost:9090/owner/getall";
        return this._httpClient.get<OwnerRegistration[]>(url);
    }
}