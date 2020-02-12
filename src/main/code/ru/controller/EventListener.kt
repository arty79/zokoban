package code.ru.controller;

import code.ru.model.Direction


/**
 * Created by arty on 28.01.2016.
 */
interface EventListener {
    fun move(direction: Direction)
    fun restart()
    fun startNextLevel()
    fun levelCompleted(level: Int)
}
