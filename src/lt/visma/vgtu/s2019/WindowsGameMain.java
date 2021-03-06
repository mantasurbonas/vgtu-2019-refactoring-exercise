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

	private BufferedImage pacmanImg;
	private BufferedImage ghostImg;
	private BufferedImage wallImg;

	Map map = new Map();
	Pacman pacman = new Pacman(10,10 );
	Ghost ghost = new Ghost(15, 12, -1, 0);
	GameRules rules = new GameRules(map, pacman, ghost);
	
	public WindowsGameMain() throws Exception {
		super.setPreferredSize(new Dimension(1200, 600));
		super.pack();
		super.setVisible(true);
		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		pacmanImg = ImageIO.read(new FileInputStream("pacman-open.png"));
		ghostImg = ImageIO.read(new FileInputStream("ghost.png"));
		wallImg = ImageIO.read(new FileInputStream("wall.png"));
		
		super.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char command = e.getKeyChar();
				rules.processCommand(command);
				
				if (rules.isPacmanEaten())
					System.exit(0);
				
				repaint();
			}
			
			@Override
			public void keyReleased(KeyEvent e) {}			
			
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		new Timer(300, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rules.moveGhost();
				if (rules.isPacmanEaten())
					System.exit(0);
				repaint();
			}
		}).start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for (int y=0; y<map.getHeight(); y++) {
			for (int x=0; x<map.getWidth();x++) {
				drawElement(g, x, y);
			}
		}
	}
	
	private void drawElement(Graphics g, int x, int y) {
		Image image = getImage(x, y);
		if (image != null)
			g.drawImage(image, 50+x*20, 50+y*20, 20, 20, null);
	}
	
	private Image getImage(int x, int y) {
		if (pacman.position.x == x && pacman.position.y == y) 
			return pacmanImg;
		
		if (ghost.position.x == x && ghost.position.y == y)
			return ghostImg;
			
		int element = map.getMapElement(y, x);
		
		if (element == 0)
			return null;

		return wallImg;
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
