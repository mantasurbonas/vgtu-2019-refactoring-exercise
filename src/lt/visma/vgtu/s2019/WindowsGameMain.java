package lt.visma.vgtu.s2019;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

//Laimonas Janutėnas PRIF - 17/1

public class WindowsGameMain extends JFrame{


	Map map = new Map();
	Pacman pacman = new Pacman(10, 10);
	Ghost ghost = new Ghost(15, 12, -1, 0);
	GameRules rules = new GameRules(map, pacman, ghost);
	Window window = new Window(map, pacman, ghost);
	GameEvent event = new GameEvent(this);

	//Mac OS reikia nurodyti pilna direktorija
	String imageDirectory = "/Users/katinas/git/vgtu-2019-refactoring-exercise/";

	public WindowsGameMain() throws Exception {
		super.setPreferredSize(new Dimension(1200, 600));
		super.pack();
		super.setVisible(true);
		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		super.addKeyListener(new Keyboard(this));
		
		window.setWallImg(imageDirectory + "wall.png");
		window.setPacmanImg(imageDirectory + "pacman-open.png");
		window.setGhostImg(imageDirectory + "ghost.png");
		
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