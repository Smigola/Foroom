package com.example.foroom.constants

import net.datafaker.Faker


class Constants {
    companion object {
        val faker = Faker()
        val USERNAME = faker.name().username()
        val PASSWORD = faker.internet().password()
        val INVALID_PASSWORD = faker.internet().password()
        val INVALID_USERNAME = faker.name().username()
        val PASSWORD_ERROR_MESSAGE = "Incorrect password"
        val USER_ERROR_MESSAGE = "Username does not exist"
    }
}