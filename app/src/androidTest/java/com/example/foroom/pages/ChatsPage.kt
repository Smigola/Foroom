package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import com.example.design_system.R as designSystem
import org.hamcrest.Matchers.allOf


class ChatsPage{
    val closeButton = withId(R.id.closeButton)
    val chatTitle = allOf(withId(designSystem.id.chatNameTextView),
        isDescendantOfA(withId(R.id.chatHeaderView)))
    val messageInput = allOf(withId(designSystem.id.inputEditText),
        isDescendantOfA(withId(R.id.messageInput)))
    val sendButton = allOf(withId(R.id.sendMessageButton),
        isDescendantOfA(withId(R.id.messageInput)))
    val messageSender = allOf(withId(designSystem.id.userNameTextView),
        isDescendantOfA(withId(R.id.messageView)))
    fun sentMessage(message: String) = allOf(withId(designSystem.id.messageTextView),
       withText(message), isDescendantOfA(withId(R.id.messageView)))
    val messagesContainer = withId(R.id.messagesRecyclerView)


}