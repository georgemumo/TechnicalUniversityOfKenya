package com.apk.george.models

class User {
    var password:String=""
    var confirmpassword:String=""
    var email:String=""
    var userId:String=""
    constructor(userId:String,password:String,confirmpassword:String,email:String){
        this.email=email
        this.confirmpassword=confirmpassword
        this.password=password
        this.userId=userId
    }
    constructor()
}