package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import org.hamcrest.Matchers.allOf
import com.example.design_system.R as designSystem

open class CommonPage {

    val usernameInput = allOf(withId(designSystem.id.inputEditText),
        isDescendantOfA(withId(R.id.userNameInput)))

    val passwordInput = allOf(withId(designSystem.id.inputEditText),
        isDescendantOfA(withId(R.id.passwordInput)))

    val signUpButton = withId(R.id.signUpButton)
}

