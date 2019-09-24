package lt.visma.vgtu.s2019;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventKeyListener implements KeyListener {

    private GameRules rules;

    public EventKeyListener(GameRules rules) {
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
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
}
