package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import org.hamcrest.Matchers.allOf
import com.example.design_system.R as designSystem

open class ProfilePage: HomePage() {
    val signOutButton = allOf(withId(designSystem.id.listItemTextView),
        isDescendantOfA(withId(R.id.signOutItem)))
    val changePasswordButton = allOf(withId(designSystem.id.listItemTextView),
        isDescendantOfA(withId(R.id.changePasswordItem)))
    val changeLanguageButton = withId(R.id.changeLanguageItem)
    val currentLocale = allOf(withId(designSystem.id.listItemTextView),
        isDescendantOfA(changeLanguageButton))
}