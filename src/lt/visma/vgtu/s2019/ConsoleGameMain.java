package lt.visma.vgtu.s2019;

import java.io.IOException;

/***
 * programos pradžia (t.y. konsolinio žaidimo pagrindinė logika) 
 *
 */
public class ConsoleGameMain {
	final private static boolean GAME_RUNNING = true;

	private static Map map = new Map();
	private static Ghost ghost = new Ghost(15, 12, -1, 0);
	private static Pacman pacman = new Pacman(10, 10);
	private static GameRules rules = new GameRules(map, pacman, ghost);
	private static GameRenderer renderer = new GameRenderer(map, pacman, ghost);

	public static void main(String[] args) throws IOException {
		while (GAME_RUNNING) {
			renderer.drawFrame();

			if (rules.isPacmanEaten())
				System.exit(0);

			rules.moveGhost();
			int command = ConsoleUserInputReader.readUserInput();
			rules.processCommand(command);
		}
	}

}
