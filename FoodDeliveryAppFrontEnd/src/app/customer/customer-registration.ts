export class CustomerRegistration{
    constructor(
        public CusId: number,
        public cusName:string,
        public email:string,
        public phoneNumber:number,
        public address:string,
        public bod:Date,
        public Login_id:number,
        public username:string,
        public password:string
    ){}
}