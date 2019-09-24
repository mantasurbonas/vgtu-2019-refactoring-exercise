package lt.visma.vgtu.s2019;

import java.io.IOException;

/***
 * programos pradžia (t.y. konsolinio žaidimo pagrindinė logika)
 *
 */
public class ConsoleGameMain {

	public static void main(String[] args) throws IOException {
		Map map = new Map();
		Pacman pacman = new Pacman(10, 10);
		Ghost ghost = new Ghost(15, 12, -1, 0);
		GameRules rules = new GameRules(map, pacman, ghost);

		GameRenderer renderer = new GameRenderer(map, pacman, ghost);

		while (true) {
			renderer.drawFrame();

			if (rules.isPacmanEaten())
				System.exit(0);

			rules.moveGhost();

			int command = ConsoleUserInputReader.readUserInput();

			rules.processCommand(command);
		}
	}

}
