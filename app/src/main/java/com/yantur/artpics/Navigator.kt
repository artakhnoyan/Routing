package com.yantur.artpics

import java.util.*

object Navigator {

    private val routers = LinkedList<Router>()

    fun addResultRouter(router: Router) = routers.add(router)

    fun removeLastResultRouter() {
        if (routers.isNotEmpty()) {
            routers.removeLast()
        }
    }

    fun getLastResultRouter(): Router? = routers.lastOrNull()
}