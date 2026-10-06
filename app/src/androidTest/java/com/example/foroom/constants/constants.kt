package com.example.foroom.constants

import com.example.foroom.util.util
import net.datafaker.Faker
import java.time.LocalTime


class Constants {
    companion object {
        val faker = Faker()
        var USERNAME: String = util().generateUsername()
            private set
        var PASSWORD = faker.internet().password()
        val NEW_PASSWORD = faker.internet().password()
        val CHAT_TITLE = "Bachana Kokoshvili " + LocalTime.now()
        val LANG_LABEL = mapOf("GE" to "ენის შეცვლა",
            "EN" to "Change Language")

        fun generateNewTestData() {
            USERNAME = util().generateUsername()
        }
    }

}