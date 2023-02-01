import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {CustomerRegistration} from './customer-registration';

@Injectable({
    providedIn: 'root'
  })
export class CustomerService{
    constructor(private _httpClient: HttpClient){
    }

    registerCustomer(customer: CustomerRegistration):Observable<CustomerRegistration>{
        let url = "http://localhost:9090/customer/register";
        return this._httpClient.post<CustomerRegistration>(url,customer);
    }
    getAllUser():Observable<CustomerRegistration[]>{
        let url: string = "http://localhost:9090/customer/getall";
        return this._httpClient.get<CustomerRegistration[]>(url);
    }

}