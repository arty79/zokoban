package code.ru.model

import java.awt.Color
import java.awt.Graphics

/**
 * Created by arty on 28.01.2016.
 */
class Wall(x: Int, y: Int) : CollisionObject(x, y) {
    override fun draw(graphics: Graphics) {
        graphics.color = Color.RED
        val leftUpperCornerX: Int = x - width / 2
        val leftUpperCornerY: Int = y - height / 2
        graphics.drawRect(leftUpperCornerX, leftUpperCornerY, width, height)
        graphics.fillRect(leftUpperCornerX, leftUpperCornerY, width, height)
    }
}