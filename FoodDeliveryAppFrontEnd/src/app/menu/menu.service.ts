import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Menu } from './menu';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(private _httpClient: HttpClient){
  }

  getAllMenu(): Observable<Menu[]>  {
    let url = "http://localhost:9090/Menu/viewall";
    return this._httpClient.get<Menu[]>(url);
  }

  getMenuById(menuId: number): Observable<Menu>  {
    let url = "http://localhost:9090/Menu/viewall/"+menuId;
    return this._httpClient.get<Menu>(url);
  }

  addMenu(menu: Menu): Observable<Menu> {
    let url = "http://localhost:9090/Menu/add";
    return this._httpClient.post<Menu>(url,menu);
  }

  updateMenu(menu: Menu): Observable<Menu> {
    let url = "http://localhost:9090/Menu/update/"+menu.menu_Id;
    return this._httpClient.put<Menu>(url,menu);
  }

  deleteMenu(menuId: number): Observable<Menu> {
    let url = "http://localhost:9090/Menu/delete/"+menuId;
    return this._httpClient.delete<Menu>(url);
  }

}
