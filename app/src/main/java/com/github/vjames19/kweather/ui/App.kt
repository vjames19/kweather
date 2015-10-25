package com.github.vjames19.kweather.ui

import android.app.Application
import com.github.vjames19.kweather.ui.utils.DelegatesExt

/**
 * Created by vjames19 on 10/25/15.
 */
class App : Application() {
    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}