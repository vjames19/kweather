package com.github.vjames19.kweather.domain.commands

/**
 * Created by vjames19 on 10/24/15.
 */
public interface Command<T> {
    fun execute(): T
}