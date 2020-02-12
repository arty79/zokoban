package code.ru.view

import java.awt.Color
import java.awt.Graphics
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.JPanel
import code.ru.controller.EventListener
import code.ru.model.Direction
import java.awt.event.KeyEvent.*

/**
 * Created by arty on 27.01.2016.
 */
class Field(var view: View, var eventListener: EventListener) : JPanel() {
    override fun paint(g: Graphics) {
        g.color = Color.BLACK
        g.fillRect(0, 0, view.getWidth(), view.getHeight())
        for (it in view.getGameObjects().all) {
            it.draw(g)
        }
    }

    inner class KeyHandler : KeyAdapter() {
        override fun keyPressed(e: KeyEvent) {
            when (e.keyCode) {
                VK_LEFT -> eventListener.move(Direction.LEFT)
                VK_RIGHT -> eventListener.move(Direction.RIGHT)
                VK_UP -> eventListener.move(Direction.UP)
                VK_DOWN -> eventListener.move(Direction.DOWN)
                VK_R -> eventListener.restart()
            }
        }
    }

    init {
        val keyHandler = KeyHandler()
        addKeyListener(keyHandler)
        isFocusable = true
    }
}