package code.ru.big01.controller;

import code.ru.big01.model.Direction


/**
 * Created by arty on 28.01.2016.
 */
open interface EventListener {
    fun move(direction: Direction)
    fun restart()
    fun startNextLevel()
    fun levelCompleted(level: Int)
}
