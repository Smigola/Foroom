package com.example.foroom.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.foroom.constants.Constants.Companion.CHAT_TITLE
import com.example.foroom.constants.Constants.Companion.NEW_PASSWORD
import com.example.foroom.constants.Constants.Companion.PASSWORD
import com.example.foroom.constants.Constants.Companion.USERNAME
import com.example.foroom.constants.Constants.Companion.LANG_LABEL
import com.example.foroom.constants.Constants.Companion.generateNewTestData
import com.example.foroom.presentation.ui.activity.ForoomActivity
import com.example.foroom.steps.ChangeLanguageSteps
import com.example.foroom.steps.ChangePasswordSteps
import com.example.foroom.steps.ChatSteps
import com.example.foroom.steps.CreateChatSteps
import com.example.foroom.steps.HomeSteps
import com.example.foroom.steps.LoginSteps
import com.example.foroom.steps.ProfileSteps
import com.example.foroom.steps.RegistrationSteps
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProfileAndChatTests{
    lateinit var loginSteps: LoginSteps
    lateinit var registrationSteps: RegistrationSteps
    lateinit var profileSteps: ProfileSteps
    lateinit var homeSteps: HomeSteps
    lateinit var chatSteps: ChatSteps
    lateinit var changePasswordSteps: ChangePasswordSteps
    lateinit var changeLanguageSteps: ChangeLanguageSteps
    lateinit var createChatSteps: CreateChatSteps

    @get:Rule
    val activityRule = ActivityScenarioRule(ForoomActivity::class.java);

    @Before
    fun setUp() {
        loginSteps = LoginSteps()
        registrationSteps = RegistrationSteps()
        profileSteps = ProfileSteps()
        homeSteps = HomeSteps()
        chatSteps = ChatSteps()
        changePasswordSteps = ChangePasswordSteps()
        changeLanguageSteps = ChangeLanguageSteps()
        createChatSteps = CreateChatSteps()

        if (homeSteps.checkLogged()) {
            profileSteps.logout()
        }
        loginSteps.validateLoginScreen()
        registerUser()
    }

    @Test
    fun changePasswordAndVerify() {
        homeSteps.openProfile()

        profileSteps.openPasswordChange()

        changePasswordSteps.changePassword(NEW_PASSWORD)

        loginSteps.validateLoginScreen()

        loginSteps
            .fillUserName(USERNAME)
            .fillPassword(PASSWORD)
        loginSteps.loginAttempt()
        Thread.sleep(5000)
        assertTrue(homeSteps.checkLogged())
    }

    @Test
    fun changeLanguage() {
        homeSteps.openProfile()

        profileSteps.openLanguageChange()
        changeLanguageSteps.setLanguageToGe()
        profileSteps.verifyLanguage(LANG_LABEL.get("GE"))

        profileSteps.openLanguageChange()
        changeLanguageSteps.setLanguageToEn()
        profileSteps.verifyLanguage(LANG_LABEL.get("EN"))

        profileSteps.openLanguageChange()
        changeLanguageSteps.setLanguageToGe()
        profileSteps.verifyLanguage(LANG_LABEL.get("GE"))
    }

    @Test
    fun createChatAndFindInList() {

        assertTrue(homeSteps.checkLogged())
        homeSteps.openCreateChat()

        createChatSteps.createNewChat()

        chatSteps
            .validateChatTitle()
            .closeChat()

        homeSteps
            .searchForChat(CHAT_TITLE)
            .validateSearchedChat(CHAT_TITLE)
    }

    fun registerUser() {
        generateNewTestData()

        loginSteps.openRegistrationPage()

        registrationSteps
            .fillUserName(USERNAME)
            .fillPassword(PASSWORD)
        registrationSteps.fillRepeatedPassword(PASSWORD)
        registrationSteps.chooseFirstAvatar()

        registrationSteps.registerAttempt()
    }

    fun login() {
        loginSteps
            .fillUserName(USERNAME)
            .fillPassword(PASSWORD)
        loginSteps.loginAttempt()
    }

}
