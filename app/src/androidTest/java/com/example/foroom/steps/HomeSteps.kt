package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import com.example.foroom.Helper.isViewDisplayed
import com.example.foroom.Helper.tap
import com.example.foroom.pages.HomePage

class HomeSteps {
    val homePage = HomePage()

    fun logout(): HomeSteps {
        onView(homePage.profile)
            .perform().tap()

        onView(homePage.signOutButton)
            .perform().tap()
        return this;
    }

    fun checkLogged(): Boolean {
        if (homePage.profile.isViewDisplayed()) {
            return true
        }
        return false
    }
}