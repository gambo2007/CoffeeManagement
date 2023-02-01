import { Injectable } from '@angular/core';
import { Coffee } from './coffee';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CoffeeService {

  constructor(private _httpClient: HttpClient) { }

  addCoffee(coffee: Coffee): Observable<Coffee> {
    let url: string = "http://localhost:9090/coffee/add";
    return this._httpClient.post<Coffee>(url, coffee);
  }   

  getAllCoffee(): Observable<Coffee[]> {
    let url: string = "http://localhost:9090/coffee/";
    return this._httpClient.get<Coffee[]>(url);
  }   

  getCoffeeById(coffeeId: number): Observable<Coffee>  {
    let url = "http://localhost:9090/coffee/"+coffeeId;
    return this._httpClient.get<Coffee>(url);
  }

  updateCoffee(coffee: Coffee): Observable<Coffee> {
    console.log(coffee);
    let url = "http://localhost:9090/coffee/update/"+coffee.coffee_id;
    return this._httpClient.put<Coffee>(url,coffee);
  }

  deleteCoffee(coffeeId: number): Observable<Coffee> {
    let url = "http://localhost:9090/coffee/delete/"+coffeeId;
    return this._httpClient.delete<Coffee>(url);
  }
}
