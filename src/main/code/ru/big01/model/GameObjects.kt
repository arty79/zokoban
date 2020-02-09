package code.ru.big01.model

import java.util.*

/**
 * Created by arty on 28.01.2016.
 */
class GameObjects(walls: Set<Wall>, boxes: Set<Box>, homes: Set<Home>, player: Player) {
    private val walls: Set<Wall> = walls
    private val boxes: Set<Box> = boxes
    private val homes: Set<Home> = homes
    private val player: Player = player
    val all: Set<GameObject>
        get() {
            val allObj: MutableSet<GameObject> = HashSet<GameObject>()
            allObj.addAll(getBoxes())
            allObj.addAll(getWalls())
            allObj.addAll(getHomes())
            allObj.add(getPlayer())
            return allObj
        }

    fun getWalls(): Set<Wall> {
        return walls
    }

    fun getBoxes(): Set<Box> {
        return boxes
    }

    fun getHomes(): Set<Home> {
        return homes
    }

    fun getPlayer(): Player {
        return player
    }

}