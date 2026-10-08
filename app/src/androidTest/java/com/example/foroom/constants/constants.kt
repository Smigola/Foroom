package com.example.foroom.constants

import java.io.File
import java.time.LocalDateTime


class Constants {
    companion object {
        val USER_A = "userA"
        val USER_B = "userB"
        val PASSWORD = "pswrd123"

        val CHAT_TITLE_JOHN = "johnWeek"
        val CHAT_TITLE_COMMON = "something"
        val CHAT_TITLE_UNIQUE = "Bachana Kokoshvili"

        val CHAT_MESSAGE_DRINK = "let's go for a drink" + LocalDateTime.now()
        val CHAT_MESSAGE_QUESTION = "which module do u like the most in TA academy?" + LocalDateTime.now()
        val CHAT_MESSAGE_GREETING = "wazuuuuuuuuup" + LocalDateTime.now()
        val CHAT_MESSAGE_POLITE_GREETING = "Hello"
        val USER_LOGS = File("/data/data/com.alternator.foroom.training/shared_prefs/foroom_training.xml")

    }

}