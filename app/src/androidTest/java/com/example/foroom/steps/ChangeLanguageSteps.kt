package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import com.example.foroom.Helper.tap
import com.example.foroom.pages.ChangeLanguagePage

class ChangeLanguageSteps {
    val changeLanguagePage = ChangeLanguagePage()

    fun setLanguageToGe() {
        onView(changeLanguagePage.buttonGe).tap()
    }

    fun setLanguageToEn() {
        onView(changeLanguagePage.buttonEn).tap()
    }
}