package com.example.foroom.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.foroom.constants.Constants.Companion.CHAT_MESSAGE_DRINK
import com.example.foroom.constants.Constants.Companion.CHAT_MESSAGE_GREETING
import com.example.foroom.constants.Constants.Companion.CHAT_MESSAGE_POLITE_GREETING
import com.example.foroom.constants.Constants.Companion.CHAT_MESSAGE_QUESTION
import com.example.foroom.constants.Constants.Companion.CHAT_TITLE_COMMON
import com.example.foroom.constants.Constants.Companion.CHAT_TITLE_JOHN
import com.example.foroom.constants.Constants.Companion.CHAT_TITLE_UNIQUE
import com.example.foroom.constants.Constants.Companion.PASSWORD
import com.example.foroom.constants.Constants.Companion.USER_A
import com.example.foroom.constants.Constants.Companion.USER_B
import com.example.foroom.constants.Constants.Companion.USER_LOGS
import com.example.foroom.presentation.ui.activity.ForoomActivity
import com.example.foroom.steps.ChatSteps
import com.example.foroom.steps.CreateChatSteps
import com.example.foroom.steps.HomeSteps
import com.example.foroom.steps.LoginSteps
import com.example.foroom.steps.ProfileSteps
import com.example.foroom.steps.RegistrationSteps
import com.example.foroom.util.Util
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChatsTests {
    lateinit var loginSteps: LoginSteps
    lateinit var registrationSteps: RegistrationSteps
    lateinit var profileSteps: ProfileSteps
    lateinit var homeSteps: HomeSteps
    lateinit var chatSteps: ChatSteps
    lateinit var createChatSteps: CreateChatSteps

    init {
        Util.logoutUsers()
    }

    @get:Rule
    val activityRule = ActivityScenarioRule(ForoomActivity::class.java);

    @Before
    fun setUp() {

        loginSteps = LoginSteps()
        registrationSteps = RegistrationSteps()
        profileSteps = ProfileSteps()
        homeSteps = HomeSteps()
        chatSteps = ChatSteps()
        createChatSteps = CreateChatSteps()

        if (!USER_LOGS.exists() || !USER_LOGS.readText().contains("userA")) {
            prepareLocalTestData()
        }

    }

    @Test
    fun sendMessageInChatAndValidateItStays() {
        loginSteps
            .validateLoginScreen()
            .login(USER_A,PASSWORD)

        homeSteps
            .searchForChat(CHAT_TITLE_JOHN)
            .openChat()

        chatSteps.validateChatTitle(CHAT_TITLE_JOHN)

        chatSteps
            .sendMessage(CHAT_MESSAGE_DRINK)
            .verifyMessageSent(CHAT_MESSAGE_DRINK)

        chatSteps.closeChat()
        homeSteps.openChat()
        chatSteps.verifyMessageSent(CHAT_MESSAGE_DRINK)
    }

    @Test
    fun askQuestionInChatAndValidateIsSent() {
        loginSteps
            .validateLoginScreen()
            .login(USER_A,PASSWORD)

        homeSteps
            .searchForChat(CHAT_TITLE_UNIQUE)
            .openChat()

        chatSteps.validateChatTitle(CHAT_TITLE_UNIQUE)

        chatSteps
            .sendMessage(CHAT_MESSAGE_QUESTION)
            .verifyMessageSent(CHAT_MESSAGE_QUESTION)
    }

    @Test
    fun sendMessagesAndValidateWithDifferentUsers() {
        loginSteps
            .validateLoginScreen()
            .login(USER_A,PASSWORD)

        homeSteps
            .searchForChat(CHAT_TITLE_COMMON)
            .openChat()

        chatSteps.validateChatTitle(CHAT_TITLE_COMMON)

        chatSteps
            .sendMessage(CHAT_MESSAGE_GREETING)
            .verifyMessageSent(CHAT_MESSAGE_GREETING)
        chatSteps.sendMessage(CHAT_MESSAGE_POLITE_GREETING, times = 25)

        chatSteps.closeChat()
        profileSteps.logout()

        loginSteps.login(USER_B, PASSWORD)
        homeSteps
            .searchForChat(CHAT_TITLE_COMMON)
            .openChat()

        chatSteps.scrollToAMessageAndVerify(CHAT_MESSAGE_GREETING)
        chatSteps.sendMessage(CHAT_MESSAGE_GREETING)
        chatSteps.closeChat()

        profileSteps.logout()

        loginSteps.login(USER_A, PASSWORD)
        chatSteps
            .searchForChat(CHAT_TITLE_COMMON)
            .openChat()
        chatSteps.verifyMessageSent(CHAT_MESSAGE_GREETING)

    }

    fun prepareLocalTestData() {
        loginSteps.openRegistrationPage()
        registrationSteps.registerUser(USER_A,PASSWORD)

        createChatSteps.createChats(listOf(
            CHAT_TITLE_JOHN,CHAT_TITLE_COMMON,CHAT_TITLE_UNIQUE))

        profileSteps.logout()

        loginSteps.openRegistrationPage()
        registrationSteps.registerUser(USER_B, PASSWORD)
        profileSteps.logout()
    }

}
