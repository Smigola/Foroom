package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import com.example.foroom.Helper.isViewDisplayed
import com.example.foroom.Helper.tap
import com.example.foroom.pages.LoginPage

import org.junit.Assert.assertTrue

class LoginSteps: CommonSteps() {
    val loginPage = LoginPage();

    fun openRegistrationPage() {
        onView(loginPage.signUpButton).tap()
    }

    fun loginAttempt(): LoginSteps {
        onView(loginPage.loginButton).tap()
        return this;
    }

    fun validateLoginScreen(): LoginSteps {
        assertTrue(loginPage.usernameInput.isViewDisplayed())
        assertTrue(loginPage.passwordInput.isViewDisplayed())
        assertTrue(loginPage.loginButton.isViewDisplayed())
        assertTrue(loginPage.signUpButton.isViewDisplayed())
        return this
    }

    fun login(username: String, password: String) {
        this
            .fillUserName(username)
            .fillPassword(password)
        this.loginAttempt()
    }

    fun checkUserExists(): Boolean {
        if (loginPage.userNameNotExsistsError.isViewDisplayed()){
            return false
        }
        return true
    }
}