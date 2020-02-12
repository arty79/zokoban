package code.ru.model

import java.util.*

/**
 * Created by arty on 28.01.2016.
 */
class GameObjects(val walls: Set<Wall>, val boxes: Set<Box>, val homes: Set<Home>, val player: Player) {
    val all: Set<GameObject>
        get() {
            val allObj: MutableSet<GameObject> = HashSet<GameObject>()
            allObj.addAll(boxes)
            allObj.addAll(walls)
            allObj.addAll(homes)
            allObj.add(player)
            return allObj
        }
}