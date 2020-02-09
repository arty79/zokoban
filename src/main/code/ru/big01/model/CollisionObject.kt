package code.ru.big01.model

/**
 * Created by arty on 28.01.2016.
 */
abstract class CollisionObject(x: Int, y: Int) : GameObject(x, y) {
    fun isCollision(gameObject: GameObject, direction: Direction?): Boolean {
        var newX: Int = this.x
        var newY: Int = this.y
        when (direction) {
            Direction.UP -> newY -= Model.FIELD_SELL_SIZE
            Direction.DOWN -> newY += Model.FIELD_SELL_SIZE
            Direction.LEFT -> newX -= Model.FIELD_SELL_SIZE
            Direction.RIGHT -> newX += Model.FIELD_SELL_SIZE
        }
        return newX == gameObject.x && newY == gameObject.y
    }
}