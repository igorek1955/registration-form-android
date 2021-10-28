package com.example.registrationform

import java.io.Serializable

data class RegistrationDetails(
    val firstName: String,
    val lastName: String,
    val email: String,
    val number: String,
    val subscribe: Boolean,
    val citizenship: String
) : Serializable