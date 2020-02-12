package code.ru.model

import java.awt.Color
import java.awt.Graphics

/**
 * Created by arty on 28.01.2016.
 */
class Player(x: Int, y: Int) : CollisionObject(x, y), Movable {
    override fun draw(graphics: Graphics) {
        graphics.color = Color.YELLOW
        val leftUpperCornerX: Int = x - width / 2
        val leftUpperCornerY: Int = y - height / 2
        graphics.drawOval(leftUpperCornerX, leftUpperCornerY, width, height)
        graphics.fillOval(leftUpperCornerX, leftUpperCornerY, width, height)
    }

    override fun move(_x: Int, _y: Int) {
        x += _x
        y += _y
    }
}