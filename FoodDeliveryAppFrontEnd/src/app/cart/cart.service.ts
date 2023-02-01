import { Injectable } from '@angular/core';
import { Coffee } from '../coffee/coffee';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})

export class CartService {
    items: Coffee[] = [];
    total: number = 0;
    
    constructor(private _activatedRoute: ActivatedRoute,  private _router: Router) { 
    }

    addToCart(item: Coffee){
        this.items.push(item);
        this.total+=item.price;
    }

    clearCart(){
        this.items = [];
        this.total = 0;
    }
}
