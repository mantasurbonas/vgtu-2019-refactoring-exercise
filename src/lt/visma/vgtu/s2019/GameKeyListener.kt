package lt.visma.vgtu.s2019

import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import kotlin.system.exitProcess

class GameKeyListener(private val rules: GameRules) : KeyListener {

    override fun keyTyped(e: KeyEvent) {
        val command = e.keyChar
        rules.processCommand(command.toInt())

        if (rules.isPacmanEaten)
            exitProcess(0)

        //repaint()
    }

    override fun keyReleased(e: KeyEvent) {}

    override fun keyPressed(e: KeyEvent) {}
}