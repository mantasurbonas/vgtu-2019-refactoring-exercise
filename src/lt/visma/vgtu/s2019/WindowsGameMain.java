package lt.visma.vgtu.s2019;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;

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

	private Map map = new Map(new ElementImageRepresentationImpl());
	private Pacman pacman = new Pacman(10,10, new ElementImageRepresentationImpl() );
	private Ghost ghost = new Ghost(15, 12, -1, 0, new ElementImageRepresentationImpl());
	private GameRules rules = new GameRules(map, pacman, ghost);
	private Canvas canvas;
	
	public WindowsGameMain() throws Exception {
		setupGameWindow();
		loadImages();
		canvas = new Canvas(map, 20);
		canvas.loadEntities(new Canvas.Entities(pacman, ghost));
		setupEventListeners();

		initializeGameTimer();
	}

	private void loadImages() throws IOException {
		map.wall.setImage(ImageIO.read(new FileInputStream("wall.png")));
		pacman.image.setImage(ImageIO.read(new FileInputStream("pacman-open.png")));
		ghost.image.setImage(ImageIO.read(new FileInputStream("ghost.png")));
	}

	private void initializeGameTimer() {
		new Timer(300, actionListener -> {
			rules.moveGhost();
			if (rules.isPacmanEaten())
				System.exit(0);
			repaint();
		}).start();
	}

	private void setupEventListeners() {
		super.addKeyListener(new GameKeyListener(rules));
	}

	private void setupGameWindow() {
		super.setPreferredSize(new Dimension(1200, 600));
		super.pack();
		super.setVisible(true);
		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		canvas.draw(g);
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