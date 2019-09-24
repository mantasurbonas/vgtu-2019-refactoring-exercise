package lt.visma.vgtu.s2019;

import java.awt.Dimension;
import java.awt.Graphics;
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
public class WindowsGameMain extends JFrame {
	Map map = new Map();
	Pacman pacman = new Pacman(10, 10);
	Ghost ghost = new Ghost(15, 12, -1, 0);
	GameRules rules = new GameRules(map, pacman, ghost);
	ElementDrawer elementDrawer = new ElementDrawer(map, pacman, ghost);

	public WindowsGameMain() throws Exception {
		super.setPreferredSize(new Dimension(1200, 600));
		super.pack();
		super.setVisible(true);
		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		super.addKeyListener(new EventKeyListener(rules));
		initTimer();
	}

	private void initTimer() {
		new Timer(300, event -> {
			rules.moveGhost();
			if (rules.isPacmanEaten())
				System.exit(0);
			repaint();
		}).start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		elementDrawer.drawMap(g, map);
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