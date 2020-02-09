package code.ru.big01.view

import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.WindowConstants
import code.ru.big01.controller.Controller

class View(controller: Controller) : JFrame() {
    private val controller: Controller = controller
    val gameObjects = controller.gameObjects
    private var field = Field(this, controller)


    fun init() {
        add(field)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        setSize(500, 500)
        setLocationRelativeTo(null)
        title = "Сокобан"
        isVisible = true
    }

    fun update() {
        field.repaint()
    }



    fun completed(level: Int) {
        update()
        JOptionPane.showMessageDialog(this, "Level $level completed!")
        controller.startNextLevel()
    }

}