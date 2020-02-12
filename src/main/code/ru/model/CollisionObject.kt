package code.ru.model

import code.ru.model.Direction.*
import code.ru.model.Model.Companion.FIELD_SELL_SIZE

/**
 * Created by arty on 28.01.2016.
 */
abstract class CollisionObject(x: Int, y: Int) : GameObject(x, y) {
    fun isCollision(gameObject: GameObject, direction: Direction?): Boolean {
        var newX: Int = this.x
        var newY: Int = this.y
        when (direction) {
            UP -> newY -= FIELD_SELL_SIZE
            DOWN -> newY += FIELD_SELL_SIZE
            LEFT -> newX -= FIELD_SELL_SIZE
            RIGHT -> newX += FIELD_SELL_SIZE
        }
        return newX == gameObject.x && newY == gameObject.y
    }
}