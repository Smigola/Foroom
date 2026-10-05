package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import com.example.foroom.pages.CommonPage

open class CommonSteps {
    val commonPage = CommonPage();

    fun fillUserName(username: String): CommonSteps {
        onView(commonPage.usernameInput)
            .perform(typeText(username),
                closeSoftKeyboard())

        return this;
    }

    fun fillPassword(password: String): CommonSteps {
        onView(commonPage.passwordInput)
            .perform(typeText(password),
                closeSoftKeyboard())

        return this;
    }

}