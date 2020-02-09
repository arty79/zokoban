package code.ru.big01.model

import java.awt.Color
import java.awt.Graphics

/**
 * Created by arty on 28.01.2016.
 */
class Box(x: Int, y: Int) : CollisionObject(x, y), Movable {
    override fun draw(graphics: Graphics) {
        graphics.color = Color.ORANGE
        val leftUpperCornerX: Int = x - width / 2
        val leftUpperCornerY: Int = y - height / 2
        val rightUpperCornerX: Int = x + width / 2
        val leftLowerCornerY: Int = y + height / 2
        graphics.drawRect(leftUpperCornerX, leftUpperCornerY, width, height)
        graphics.drawLine(leftUpperCornerX, leftUpperCornerY, rightUpperCornerX, leftLowerCornerY)
        graphics.drawLine(rightUpperCornerX, leftUpperCornerY, leftUpperCornerX, leftLowerCornerY)
    }

    override fun move(_x: Int, _y: Int) {
        x += _x
        y += _y
    }
}