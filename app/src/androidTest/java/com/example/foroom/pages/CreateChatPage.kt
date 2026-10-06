package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import com.example.design_system.R as designSystem
import org.hamcrest.Matchers.allOf

class CreateChatPage: HomePage() {
    val chatNameInput = allOf(withId(designSystem.id.inputEditText),
        isDescendantOfA(withId(R.id.chatNameInput)))
    val imageList = withId(R.id.chatImageChooser)
    val createChatButton = withId(R.id.createChatButton)
}