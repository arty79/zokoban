package code.ru.big01.model

import java.awt.Color
import java.awt.Graphics

/**
 * Created by arty on 28.01.2016.
 */
class Home(x: Int, y: Int) : GameObject(x, y, Model.FIELD_SELL_SIZE, Model.FIELD_SELL_SIZE) {
    override fun draw(graphics: Graphics) {
        graphics.color = Color.GREEN
        graphics.drawOval(x, y, width / 10, height/ 10)
    }
}