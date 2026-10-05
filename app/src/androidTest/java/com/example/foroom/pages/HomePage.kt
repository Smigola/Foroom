package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import org.hamcrest.Matchers.allOf
import com.example.design_system.R as designSystem

class HomePage {
    val navbar = allOf(withId(R.id.navBar))
    val profile = allOf(withId(R.id.homeNavigationProfile),
        isDescendantOfA(navbar))
    val signOutButton = allOf(withId(designSystem.id.listItemTextView),
        isDescendantOfA(withId(R.id.signOutItem)))
}