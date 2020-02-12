package code.ru.model

import java.awt.Graphics

/**
 * Created by arty on 27.01.2016.
 */
abstract class GameObject(var x: Int, var y: Int,
                          var width: Int = Model.FIELD_SELL_SIZE,
                          var height: Int = Model.FIELD_SELL_SIZE) {
    abstract fun draw(graphics: Graphics)
}