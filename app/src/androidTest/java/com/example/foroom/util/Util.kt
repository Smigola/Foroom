package com.example.foroom.util

import com.example.foroom.presentation.ui.util.datastore.user.ForoomUserDataStore
import kotlinx.coroutines.runBlocking
import org.koin.core.context.GlobalContext


object Util {
    fun logoutUsers() {
        runBlocking {
            GlobalContext
                .get()
                .get<ForoomUserDataStore>()
                .clearUserData()
        }
    }
}