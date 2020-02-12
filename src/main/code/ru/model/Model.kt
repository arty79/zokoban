package code.ru.model

import code.ru.controller.EventListener
import code.ru.model.Direction.*


/**
 * Created by arty on 27.01.2016.
 */
class Model(var eventListener: EventListener) {
    companion object {
        const val FIELD_SELL_SIZE = 20
    }
    private var currentLevel = 1
    private var levelLoader: LevelLoader = getLevelLoader()
    var gameObjects: GameObjects = levelLoader.getLevel(currentLevel)
    private fun getLevelLoader(): LevelLoader {
        val path = javaClass.classLoader.getResource("res/levels.txt").path
        return LevelLoader(path)
    }

    fun restartLevel(level: Int) {
        gameObjects = levelLoader.getLevel(level)
    }

    fun restart() {
        restartLevel(currentLevel)
    }

    fun startNextLevel() {
        currentLevel++
        restart()
    }

    fun move(direction: Direction) {
        val player: Player = gameObjects.player
        var newX = 0
        var newY = 0
        if (checkWallCollision(player, direction)) {
            return
        }
        if (checkBoxCollision(direction)) {
            return
        }
        when (direction) {
            UP -> newY = -FIELD_SELL_SIZE
            DOWN -> newY = FIELD_SELL_SIZE
            LEFT -> newX = -FIELD_SELL_SIZE
            RIGHT -> newX = FIELD_SELL_SIZE
        }
        player.move(newX, newY)
        checkCompletion()
    }

    fun checkWallCollision(gameObject: CollisionObject, direction: Direction): Boolean {
        val walls: Set<Wall> = gameObjects.walls
        for (wall in walls) {
            if (gameObject.isCollision(wall, direction)) return true
        }
        return false
    }

    private fun checkBoxCollision(direction: Direction): Boolean {
        val flag = false
        val player: Player = gameObjects.player
        val boxes: Set<Box> = gameObjects.boxes
        for (box in boxes) {
            if (player.isCollision(box, direction)) {
                for (anotherBox in boxes) {
                    if (checkWallCollision(box, direction)) {
                        return true
                    } else if (box.isCollision(anotherBox, direction)) {
                        return true
                    }
                }
                var newX = 0
                var newY = 0
                when (direction) {
                    UP -> newY = -FIELD_SELL_SIZE
                    DOWN -> newY = FIELD_SELL_SIZE
                    LEFT -> newX = -FIELD_SELL_SIZE
                    RIGHT -> newX = FIELD_SELL_SIZE
                }
                box.move(newX, newY)
                return false
            }
        }
        return flag
    }

    private fun checkCompletion() {
        var count = 0
        val boxes: Set<Box> = gameObjects.boxes
        val homes: Set<Home> = gameObjects.homes
        for (box in boxes) {
            for (home in homes) {
                if (box.y === home.y && box.x === home.x) count++
            }
        }
        if (count == boxes.size) eventListener.levelCompleted(currentLevel)
    }
}