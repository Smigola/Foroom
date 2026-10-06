package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import com.example.foroom.Helper.tap
import com.example.foroom.constants.Constants.Companion.NEW_PASSWORD
import com.example.foroom.constants.Constants.Companion.PASSWORD
import com.example.foroom.pages.ChangePasswordPage

class ChangePasswordSteps {
    val changePasswordPage = ChangePasswordPage()

    fun changePassword(newPassword: String) {
        onView(changePasswordPage.passwordInput)
            .perform(typeText(newPassword))

        onView(changePasswordPage.repeatPasswordInput)
            .perform(typeText(newPassword))

        onView(changePasswordPage.submitButton).tap()
        PASSWORD = NEW_PASSWORD
    }
}