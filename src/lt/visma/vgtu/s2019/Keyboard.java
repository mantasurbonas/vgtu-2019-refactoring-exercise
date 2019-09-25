package lt.visma.vgtu.s2019;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
    GameRules rules;
    WindowsGameMain main;

    public Keyboard(WindowsGameMain main){
        this.rules = main.rules;
        this.main = main;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
            char command = e.getKeyChar();
            rules.processCommand(command);

            if (rules.isPacmanEaten())
                    System.exit(0);
            main.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {}			

    @Override
    public void keyPressed(KeyEvent e) {}
    
}
