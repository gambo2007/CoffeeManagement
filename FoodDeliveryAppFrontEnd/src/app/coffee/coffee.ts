import { Menu } from "../menu/menu";

export class Coffee {
    constructor(public coffee_id: number, public coffee_name: string, public desc: string, public price: number, public menu: Menu, public img: string) {

    }
}
