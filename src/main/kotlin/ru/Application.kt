package main.kotlin.ru

object Application {
    var KOTLIN = "kotlin"
    @JvmStatic
    fun main(args: Array<String>) {
        val language = args[0]
        when (language) {
            KOTLIN -> KotlinService().sayHello()
            else -> {
            }
        }
    }
}