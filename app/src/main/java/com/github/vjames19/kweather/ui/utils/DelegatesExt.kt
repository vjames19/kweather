package com.github.vjames19.kweather.ui.utils

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by vjames19 on 10/25/15.
 */

public object DelegatesExt {
    fun notNullSingleValue<T : Any>():
            ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
}
private class NotNullSingleValueVar<T : Any>() : ReadWriteProperty<Any?, T> {
    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("${property.name} not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalArgumentException("${property.name} already initialized")
    }

}