package lt.visma.vgtu.s2019;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/***
 * programos pradžia (t.y. GUI žaidimo).
 * 
 *  Studentų dėmesiui: ši klasė per didelė, ir daro pernelyg daug nesusijusių dalykų - reikia refaktorinti šią klasę į kelias mažesnes!
 *
 */
public class WindowsGameMain extends JFrame{
        private String imageDirectory = "/Users/katinas/NetBeansProjects/vgtu-2019-refactoring-exercise/pacman/src/pacman/"; //Mac OS reikia nurodyti pilna direktorija

	Map map = new Map(imageDirectory + "wall.png");
	Pacman pacman = new Pacman(10, 10, imageDirectory + "pacman-open.png");
	Ghost ghost = new Ghost(15, 12, -1, 0, imageDirectory + "ghost.png");
	GameRules rules = new GameRules(map, pacman, ghost);
        Window window = new Window(map, pacman, ghost);
        GameEvent event = new GameEvent(this);
	
	public WindowsGameMain() throws Exception {
		super.setPreferredSize(new Dimension(1200, 600));
		super.pack();
		super.setVisible(true);
		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		super.addKeyListener(new Keyboard(rules)); 
		event.update();
		
	}
        
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for (int y=0; y<map.getHeight(); y++) {
			for (int x=0; x<map.getWidth();x++) {
				window.drawElement(g, x, y);
			}
		}
	}

	public static void main(String[] args) throws Exception {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                        try {
                            new WindowsGameMain();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                }
            });
	}

}