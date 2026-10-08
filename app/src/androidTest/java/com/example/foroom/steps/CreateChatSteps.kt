package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import com.example.foroom.Helper.tap
import com.example.foroom.Helper.withIndex
import com.example.foroom.pages.ChatsPage
import com.example.foroom.pages.CreateChatPage

class CreateChatSteps: ChatSteps() {
    val createChatPage = CreateChatPage()

    fun createNewChat(chatTitle: String) {
        onView(createChatPage.chatNameInput)
            .perform(typeText(chatTitle), closeSoftKeyboard())

        withIndex(createChatPage.imageList, 0).tap()

        onView(createChatPage.createChatButton).tap()
    }

    fun createChats(chatTitles: List<String>) {
        chatTitles.forEach { chatTitle ->
            super.openCreateChat()
            this.createNewChat(chatTitle)
            super.closeChat()
        }
    }



}