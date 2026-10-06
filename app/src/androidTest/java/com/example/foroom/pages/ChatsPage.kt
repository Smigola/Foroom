package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import com.example.design_system.R as designSystem
import org.hamcrest.Matchers.allOf


class ChatsPage{
    val closeButton = withId(R.id.closeButton)
    val chatTitle = allOf(withId(designSystem.id.chatNameTextView),
        isDescendantOfA(withId(R.id.chatHeaderView)))

}