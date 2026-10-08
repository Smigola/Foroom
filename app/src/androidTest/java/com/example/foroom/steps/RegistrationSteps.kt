package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import com.example.design_system.components.image_chooser.ImageChooserListView
import com.example.foroom.Helper.isViewDisplayed
import com.example.foroom.Helper.tap
import com.example.foroom.Helper.withIndex
import com.example.foroom.constants.Constants.Companion.PASSWORD
import com.example.foroom.pages.RegistrationPage

class RegistrationSteps: CommonSteps() {
    val registrationPage = RegistrationPage()

    fun fillRepeatedPassword(password: String): RegistrationSteps {
        onView(registrationPage.repeatPasswordInput)
            .perform(typeText(password),
                closeSoftKeyboard())
        return this;
    }

    fun registerAttempt(): RegistrationSteps {
        onView(registrationPage.signUpButton).tap()
        return this
    }

    fun chooseFirstAvatar(): RegistrationSteps {
        withIndex(registrationPage.avatarList,0).tap()

        return this
    }

    fun registerUser(username: String, password: String) {
        this
            .fillUserName(username)
            .fillPassword(password)
        this.fillRepeatedPassword(password)
        this.chooseFirstAvatar()

        this.registerAttempt()
    }

}