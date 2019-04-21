package com.danlos.test.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("first_name")
    @Expose
    var firstName: String? = null
    @SerializedName("last_name")
    @Expose
    var lastName: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("gender")
    @Expose
    var gender: String? = null

    override fun toString(): String {
        return "id = $id\n" +
                "first name = $firstName\n" +
                "lastName = $lastName\n" +
                "email = $email\n" +
                "gender = $gender\n"
    }

}