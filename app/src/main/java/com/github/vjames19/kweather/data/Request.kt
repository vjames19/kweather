package com.github.vjames19.kweather.data

import android.util.Log
import java.net.URL

/**
 * Created by vjames19 on 10/24/15.
 */
public class Request(val url: String) {

    public fun run() {
        val jsonStr = URL(url).readText();
        Log.d(javaClass.simpleName, jsonStr)
    }
}