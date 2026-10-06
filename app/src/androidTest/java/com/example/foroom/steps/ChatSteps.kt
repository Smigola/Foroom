package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import com.example.foroom.Helper.getText
import com.example.foroom.Helper.tap
import com.example.foroom.constants.Constants.Companion.CHAT_TITLE
import com.example.foroom.pages.ChatsPage
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

class ChatSteps {
    val chatsPage = ChatsPage()

    fun validateChatTitle(): ChatSteps {
        assertThat(chatsPage.chatTitle.getText().trim(),
            equalTo(CHAT_TITLE))
        return this
    }

    fun closeChat(): ChatSteps {
        onView(chatsPage.closeButton).tap()
        return this
    }
}