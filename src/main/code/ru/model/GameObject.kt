package code.ru.model

import java.awt.Graphics

/**
 * Created by arty on 27.01.2016.
 */
abstract class GameObject {
    var x: Int
    var y: Int
    var width: Int
    var height: Int

    abstract fun draw(graphics: Graphics)

    constructor(x: Int, y: Int) {
        this.x = x
        this.y = y
        width = Model.FIELD_SELL_SIZE
        height = Model.FIELD_SELL_SIZE
    }

    constructor(x: Int, y: Int, width: Int, height: Int) {
        this.x = x
        this.y = y
        this.width = width
        this.height = height
    }
}