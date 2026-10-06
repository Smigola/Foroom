package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import org.hamcrest.Matchers.allOf
import com.example.design_system.R as designSystem


class ChangeLanguagePage: ProfilePage() {

    val buttonGe = allOf(withId(R.id.languageButtonGeo),
        isDescendantOfA(withId(designSystem.id.contentContainer)))
    val buttonEn = allOf(withId(R.id.languageButtonEng),
        isDescendantOfA(withId(designSystem.id.contentContainer)))
}