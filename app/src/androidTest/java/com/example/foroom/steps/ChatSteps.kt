package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.example.foroom.Helper.getText
import com.example.foroom.Helper.isViewDisplayed
import com.example.foroom.Helper.swiper
import com.example.foroom.Helper.tap
import com.example.foroom.pages.ChatsPage
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

open class ChatSteps: HomeSteps() {
    val chatsPage = ChatsPage()

    fun validateChatTitle(chatTitle: String): ChatSteps {
        assertThat(chatsPage.chatTitle.getText().trim(),
            equalTo(chatTitle))
        return this
    }

    fun sendMessage(message: String, times: Int = 1): ChatSteps {

        for (i in 1..times) {
            onView(chatsPage.messageInput)
                .perform(typeText(message), closeSoftKeyboard())

            onView(chatsPage.sendButton).tap()
        }
        return this
    }

    fun verifyMessageSent(message: String): ChatSteps {
        assertThat(chatsPage.sentMessage(message).getText(),
            equalTo(message))

        return this
    }

    fun scrollUp() {
        val inst = getInstrumentation()
        val height = inst.targetContext.resources.displayMetrics.heightPixels

        swiper(
            start = (height * 0.75f).toInt(),
            end = (height * 0.25f).toInt(),
            delay = 300
        )
    }

    fun scrollToAMessageAndVerify(message: String) {
        repeat(20) {
            try {
                if (chatsPage.sentMessage(message).isViewDisplayed()) {
                    verifyMessageSent(message)
                    return
                }
            } catch (e: NoMatchingViewException) { }

            scrollUp()
        }
    }

    fun closeChat(): ChatSteps {
        onView(chatsPage.closeButton).tap()
        return this
    }
}