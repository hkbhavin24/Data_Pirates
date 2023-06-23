package com.example.datapirates.SQLDatabase

class LoginModel {

    var id = 0
    lateinit var fname:String
    lateinit var lname:String
    lateinit var email:String
    lateinit var password:String
    lateinit var cpassword:String

    constructor(
        id: Int,
        fname: String,
        lname: String,
        email: String,
        password: String,
        cpassword: String
    ) {
        this.id = id
        this.fname = fname
        this.lname = lname
        this.email = email
        this.password = password
        this.cpassword = cpassword
    }

    constructor()


}