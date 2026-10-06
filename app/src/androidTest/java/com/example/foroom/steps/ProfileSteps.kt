package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import com.example.foroom.Helper.getText
import com.example.foroom.Helper.tap
import com.example.foroom.pages.ProfilePage
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

class ProfileSteps {
    val profilePage = ProfilePage()

    fun logout(): ProfileSteps {
        onView(profilePage.profile)
            .perform().tap()

        onView(profilePage.signOutButton)
            .perform().tap()
        return this;
    }

    fun openPasswordChange() {
        onView(profilePage.changePasswordButton).tap()
    }

    fun openLanguageChange() {
        onView(profilePage.changeLanguageButton).tap()
    }

    fun verifyLanguage(locale: String?) {
        assertThat(locale, equalTo(
            profilePage.currentLocale.getText()
        ))
    }

}