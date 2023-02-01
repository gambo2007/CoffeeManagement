export class OwnerRegistration{
    constructor(
        public OwnerId: number,
        public ownerName:string,
        public email:string,
        public phoneNumber:number,
        public address:string,
        public bod:Date,
        public Login_id:number,
        public username:string,
        public password:string
    ){}
}