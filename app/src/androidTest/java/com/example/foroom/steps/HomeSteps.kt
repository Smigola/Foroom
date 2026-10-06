package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import com.example.foroom.Helper.getText
import com.example.foroom.Helper.isViewDisplayed
import com.example.foroom.Helper.tap
import com.example.foroom.constants.Constants.Companion.CHAT_TITLE
import com.example.foroom.pages.HomePage
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

class HomeSteps {
    val homepage = HomePage()

    fun checkLogged(): Boolean {
        if (homepage.profile.isViewDisplayed()) {
            return true
        }
        return false
    }

    fun openProfile() {
        onView(homepage.profile).tap()
    }

    fun openCreateChat() {
        onView(homepage.homeNavigationCreateChat).tap()
    }

    fun searchForChat(chatTitle: String): HomeSteps {
        onView(homepage.searchChatInput)
            .perform(typeText(chatTitle))

        return this
    }

    fun validateSearchedChat(chatTitle: String): HomeSteps {
        assertThat(homepage.chatTitleText.getText(),
            equalTo(chatTitle))

        return this
    }

}