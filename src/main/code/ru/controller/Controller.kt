package code.ru.controller

import code.ru.model.Direction
import code.ru.model.GameObjects
import code.ru.model.Model
import code.ru.view.View


/**
 * Created by arty on 27.01.2016.
 */
class Controller : EventListener {
    private var model: Model = Model(this)
    private var view: View = View(this)

    fun init() {
        view.init()
        model.restart()
        model.eventListener = this
    }
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

    fun getGameObjects(): GameObjects {
        return model.gameObjects
    }
}