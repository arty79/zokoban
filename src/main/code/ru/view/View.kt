package code.ru.view

import code.ru.controller.Controller
import code.ru.model.GameObjects
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.WindowConstants

class View(val controller: Controller) : JFrame() {
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

    fun getGameObjects(): GameObjects {
        return controller.getGameObjects()
    }

    fun completed(level: Int) {
        update()
        JOptionPane.showMessageDialog(this, "Level $level completed!")
        controller.startNextLevel()
    }

}