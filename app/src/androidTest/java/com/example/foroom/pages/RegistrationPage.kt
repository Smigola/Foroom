package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matchers.allOf

import com.alternator.foroom.R
import com.example.design_system.R as designSystem


class RegistrationPage: CommonPage() {
    val repeatPasswordInput = allOf(withId(designSystem.id.inputEditText),
        isDescendantOfA(withId(R.id.repeatPasswordInput)))
    val avatarList = withId(R.id.listView)


}