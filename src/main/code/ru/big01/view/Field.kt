package code.ru.big01.view

import java.awt.Color
import java.awt.Graphics
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.JPanel
import code.ru.big01.controller.EventListener
import code.ru.big01.model.Direction

/**
 * Created by arty on 27.01.2016.
 */
class Field(view: View, private var eventListener: EventListener) : JPanel() {
    private val view = view

    override fun paint(g: Graphics) {
        g.color = Color.BLACK
        g.fillRect(0, 0, view.getWidth(), view.getHeight())
        for (it in view.gameObjects.all) {
            it.draw(g)
        }
    }

    inner class KeyHandler : KeyAdapter() {
        override fun keyPressed(e: KeyEvent) {
            when (e.keyCode) {
                KeyEvent.VK_LEFT -> eventListener.move(Direction.LEFT)
                KeyEvent.VK_RIGHT -> eventListener.move(Direction.RIGHT)
                KeyEvent.VK_UP -> eventListener.move(Direction.UP)
                KeyEvent.VK_DOWN -> eventListener.move(Direction.DOWN)
                KeyEvent.VK_R -> eventListener.restart()
            }
        }
    }

    init {
        val keyHandler = KeyHandler()
        addKeyListener(keyHandler)
        isFocusable = true
    }
}