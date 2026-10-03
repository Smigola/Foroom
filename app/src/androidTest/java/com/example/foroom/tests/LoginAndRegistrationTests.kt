package com.example.foroom.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.foroom.Helper.isViewClickable
import com.example.foroom.constants.Constants.Companion.INVALID_PASSWORD
import com.example.foroom.constants.Constants.Companion.INVALID_USERNAME
import com.example.foroom.constants.Constants.Companion.PASSWORD
import com.example.foroom.constants.Constants.Companion.USERNAME
import com.example.foroom.presentation.ui.activity.ForoomActivity
import com.example.foroom.steps.HomeSteps
import org.junit.Rule
import org.junit.runner.RunWith

import com.example.foroom.steps.LoginSteps
import com.example.foroom.steps.RegistrationSteps
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class LoginAndRegistrationTests {
    lateinit var loginSteps: LoginSteps
    lateinit var registrationSteps: RegistrationSteps
    lateinit var homeSteps: HomeSteps

    @get:Rule
    val activityRule = ActivityScenarioRule(ForoomActivity::class.java);

    @Before
    fun setUp() {
        loginSteps = LoginSteps();
        registrationSteps = RegistrationSteps();
        homeSteps = HomeSteps();

        if (homeSteps.checkLogged()) {
            homeSteps.logout()
        }
        loginSteps.validateLoginScreen()
    }

    @Test
    fun registerUser() {
        loginSteps.openRegistrationPage()

        registrationSteps
            .fillUserName(USERNAME)
            .fillPassword(PASSWORD)
        registrationSteps.fillRepeatedPassword(PASSWORD)
        registrationSteps.chooseFirstAvatar()

        registrationSteps.registerAttempt()
        assertTrue(homeSteps.checkLogged())

    }

    @Test
    fun loginWithInvalidPassword() {

        loginSteps
            .fillUserName(USERNAME)
            .fillPassword(INVALID_PASSWORD)

        loginSteps
            .loginAttempt()
            .validateIncorrectPassword()
    }

    @Test
    fun loginWithInvalidPasswordAndUsername() {
        loginSteps
            .fillUserName(INVALID_USERNAME)
            .fillPassword(INVALID_PASSWORD)

        loginSteps
            .loginAttempt()
            .validateIncorrectUsername()
            .validateIncorrectPassword()
    }


}