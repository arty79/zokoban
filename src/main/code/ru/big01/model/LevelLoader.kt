package code.ru.big01.model

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException
import java.util.*

/**
 * Created by user on 03.02.2016.
 */
class LevelLoader(private val levels: String) {
    lateinit var player: Player
    fun getLevel(level: Int): GameObjects {
        var levl = level % 60
        if (levl == 0) {
            levl = 60
        }
        val walls: MutableSet<Wall> = HashSet<Wall>()
        val boxes: MutableSet<Box> = HashSet<Box>()
        val homes: MutableSet<Home> = HashSet<Home>()

        var countY = 0
        try {
            var lvl = 0
            var flag = false
            File(levels).forEachLine {
                if (it.contains("Maze:")) {
                    lvl = it.split(" ".toRegex()).toTypedArray()[1].toInt()
                }
                if (lvl == levl) {
                    if (flag) {
                        var countX = 0
                        for (loop in it.toCharArray()) {
                            when (loop) {
                                'X' -> {
                                    walls.add(Wall(Model.FIELD_SELL_SIZE / 2 + countX * Model.FIELD_SELL_SIZE, Model.FIELD_SELL_SIZE / 2 + countY * Model.FIELD_SELL_SIZE))
                                    countX++
                                }
                                '*' -> {
                                    boxes.add(Box(Model.FIELD_SELL_SIZE / 2 + countX * Model.FIELD_SELL_SIZE, Model.FIELD_SELL_SIZE / 2 + countY * Model.FIELD_SELL_SIZE))
                                    countX++
                                }
                                '.' -> {
                                    homes.add(Home(Model.FIELD_SELL_SIZE / 2 + countX * Model.FIELD_SELL_SIZE, Model.FIELD_SELL_SIZE / 2 + countY * Model.FIELD_SELL_SIZE))
                                    countX++
                                }
                                '@' -> {
                                    player = Player(Model.FIELD_SELL_SIZE / 2 + countX * Model.FIELD_SELL_SIZE, Model.FIELD_SELL_SIZE / 2 + countY * Model.FIELD_SELL_SIZE)
                                    countX++
                                }
                                '&' -> {
                                    boxes.add(Box(Model.FIELD_SELL_SIZE / 2 + countX * Model.FIELD_SELL_SIZE, Model.FIELD_SELL_SIZE / 2 + countY * Model.FIELD_SELL_SIZE))
                                    homes.add(Home(Model.FIELD_SELL_SIZE / 2 + countX * Model.FIELD_SELL_SIZE, Model.FIELD_SELL_SIZE / 2 + countY * Model.FIELD_SELL_SIZE))
                                    countX++
                                }
                                else -> countX++
                            }
                        }
                        countY++
                    }
                    if (it.length == 0) {
                        flag = !flag
                        countY = 0
                    }
                }
            }
        } catch (e: IOException) {
            println(e.message)
        }
        return GameObjects(walls, boxes, homes, player)
    }

}