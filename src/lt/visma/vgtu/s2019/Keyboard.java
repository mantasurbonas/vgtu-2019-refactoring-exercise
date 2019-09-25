/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.visma.vgtu.s2019;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author katinas
 */
public class Keyboard implements KeyListener{
    GameRules rules;

    public Keyboard(GameRules rules) {
        this.rules = rules;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
            char command = e.getKeyChar();
            rules.processCommand(command);

            if (rules.isPacmanEaten())
                    System.exit(0);
    }

    @Override
    public void keyReleased(KeyEvent e) {}			

    @Override
    public void keyPressed(KeyEvent e) {}
    
}
