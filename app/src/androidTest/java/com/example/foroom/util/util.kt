package com.example.foroom.util

import com.example.foroom.constants.Constants.Companion.faker

class util {
    fun generateUsername(): String {
        return faker.name().username()
    }

}