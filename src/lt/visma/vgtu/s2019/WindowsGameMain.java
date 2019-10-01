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
import java.util.ArrayList;

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

	private Map map = new Map();
	private Pacman pacman = new Pacman(10,10 );
	private Ghost ghost = new Ghost(15, 12, -1, 0);
    private ElementsDrawer elementsDrawer = new ElementsDrawer(map,pacman,ghost);
	private GameRules rules = new GameRules(map, pacman, ghost);

	private WindowsGameMain() throws Exception {
		super.setPreferredSize(new Dimension(1200, 600));
		super.pack();
		super.setVisible(true);
		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		super.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char command = e.getKeyChar();
				rules.processCommand(command);
				repaint();
			}
			
			@Override
			public void keyReleased(KeyEvent e) {}			
			
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		new Timer(300, e -> {
			rules.moveGhost();
			repaint();
		}).start();
	}

	@Override
	public void repaint(long time, int x, int y, int width, int height) {
		if (rules.isPacmanEaten())
			System.exit(0);
		super.repaint(time, x, y, width, height);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for (int y=0; y<map.getHeight(); y++) {
			for (int x=0; x<map.getWidth();x++) {
				elementsDrawer.drawElement(g, x, y);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeAndWait(() -> {
			try {
				new WindowsGameMain();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
