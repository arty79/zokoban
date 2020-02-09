package code.ru.big01.controller

import code.ru.big01.model.Direction
import code.ru.big01.model.GameObjects
import code.ru.big01.model.Model
import code.ru.big01.view.View


/**
 * Created by arty on 27.01.2016.
 */
object Controller : EventListener {
    private val model: Model = Model(this)
    private val view: View = View(this)
    val gameObjects = model.gameObjects
    override fun move(direction: Direction) {
        model.move(direction)
        view.update()
    }

    override fun restart() {
        model.restart()
        view.update()
    }

    override fun startNextLevel() {
        model.startNextLevel()
        view.update()
    }

    override fun levelCompleted(level: Int) {
        view.completed(level)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        view.init()
        model.restart()
    }
}