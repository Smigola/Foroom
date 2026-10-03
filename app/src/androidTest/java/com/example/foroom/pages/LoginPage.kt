package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import com.example.design_system.R as designSystem
import org.hamcrest.Matchers.allOf

class LoginPage: CommonPage(){
    val loginButton = withId(R.id.logInButton)

    val passwordError = allOf(withId(designSystem.id.descriptionTextView),
        isDescendantOfA(withId(R.id.passwordInput))
    )
    val userError = allOf(withId(designSystem.id.descriptionTextView),
        isDescendantOfA(withId(R.id.userNameInput))
    )
}

