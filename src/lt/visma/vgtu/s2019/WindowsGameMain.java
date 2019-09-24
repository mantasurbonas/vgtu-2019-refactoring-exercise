package lt.visma.vgtu.s2019;

import javax.swing.SwingUtilities;

/***
 * programos pradžia (t.y. GUI žaidimo).
 * 
 * Studentų dėmesiui: ši klasė per didelė, ir daro pernelyg daug nesusijusių
 * dalykų - reikia refaktorinti šią klasę į kelias mažesnes!
 *
 */
public class WindowsGameMain {

	public static void main(String[] args) throws Exception {
		Map map = new Map();
		Pacman pacman = new Pacman(10, 10);
		Ghost ghost = new Ghost(15, 12, Direction.LEFT);
		SwingUtilities.invokeAndWait(new Runnable() {

			@Override
			public void run() {
				try {
					new WindowsGameRenderer(map, pacman, ghost);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
