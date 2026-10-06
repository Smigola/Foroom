package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import com.example.design_system.R as designSystem
import org.hamcrest.Matchers.allOf

class ChangePasswordPage {
    val passwordInput = allOf(withId(designSystem.id.inputEditText),
        isDescendantOfA(withId(R.id.passwordInput)))
    val repeatPasswordInput = allOf(withId(designSystem.id.inputEditText),
        isDescendantOfA(withId(R.id.repeatPasswordInput)));
    val submitButton = withId(designSystem.id.actionButton)
}