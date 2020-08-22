package com.example.springkotlindemo.modal

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Person(@Id @GeneratedValue var id:Int? = null,
                  @Column var firstname: String?,
                  @Column var email: String?,
                  @Column var age: Number?){
    constructor(): this(0, null, null, null){

    }
}