package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import com.example.design_system.R as designSystem
import org.hamcrest.Matchers.allOf

open class HomePage {
    val navbar = withId(R.id.navBar)
    val homeNavigationCreateChat = allOf(withId(R.id.homeNavigationCreateChat),
        isDescendantOfA(navbar))
    val profile = allOf(withId(R.id.homeNavigationProfile),
        isDescendantOfA(navbar))
    val searchChatInput = allOf(withId(designSystem.id.inputEditText),
        isDescendantOfA(withId(R.id.searchChatInput)))
    val chatTitleText = allOf(withId(designSystem.id.chatTitleTextView),
        isDescendantOfA(withId(R.id.chatsRecyclerView)))
    val openChatButton = allOf(withId(R.id.sendMessageButton),
        isDescendantOfA(withId(R.id.chatsRecyclerView)))
}