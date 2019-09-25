package lt.visma.vgtu.s2019;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GameEvent {
    GameRules rules;
    WindowsGameMain main;
    GameEvent(WindowsGameMain main) {
        this.main = main;
        this.rules = main.rules;
    }
    
    public void update(){
        new Timer(300, new ActionListener() {
			
                @Override
                public void actionPerformed(ActionEvent e) {
                        rules.moveGhost();
                        if (rules.isPacmanEaten())
                                System.exit(0);
                        main.repaint();
                }
        }).start();
    }
    
    
    
}
