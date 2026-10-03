package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import com.example.foroom.Helper.getText
import com.example.foroom.Helper.isViewDisplayed
import com.example.foroom.Helper.tap
import com.example.foroom.Helper.waitUntilVisible
import com.example.foroom.constants.Constants.Companion.PASSWORD_ERROR_MESSAGE
import com.example.foroom.constants.Constants.Companion.USER_ERROR_MESSAGE
import com.example.foroom.pages.LoginPage
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.anyOf
import org.hamcrest.Matchers.equalTo
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

    fun validateIncorrectPassword(): LoginSteps {
        assertTrue(loginPage.passwordError.isViewDisplayed())
        assertThat(loginPage.passwordError.getText(),
            equalTo(PASSWORD_ERROR_MESSAGE))
        return this
    }
    fun validateIncorrectUsername(): LoginSteps {
        assertTrue(loginPage.userError.isViewDisplayed())
        assertThat(loginPage.userError.getText(),
            equalTo(USER_ERROR_MESSAGE))
        return this
    }

    fun validateLoginScreen(): LoginSteps {
        assertTrue(loginPage.usernameInput.isViewDisplayed())
        assertTrue(loginPage.passwordInput.isViewDisplayed())
        assertTrue(loginPage.loginButton.isViewDisplayed())
        assertTrue(loginPage.signUpButton.isViewDisplayed())
        return this
    }

}