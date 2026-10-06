package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import com.example.foroom.Helper.tap
import com.example.foroom.Helper.withIndex
import com.example.foroom.constants.Constants.Companion.CHAT_TITLE
import com.example.foroom.pages.CreateChatPage

class CreateChatSteps {
    val createChatPage = CreateChatPage()

    fun createNewChat() {
        onView(createChatPage.chatNameInput)
            .perform(typeText(CHAT_TITLE), closeSoftKeyboard())

        withIndex(createChatPage.imageList, 0).tap()

        onView(createChatPage.createChatButton).tap()
    }



}