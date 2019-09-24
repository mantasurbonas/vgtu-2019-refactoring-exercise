package lt.visma.vgtu.s2019;

import java.io.IOException;

/***
 * programos pradžia (t.y. konsolinio žaidimo pagrindinė logika)
 *
 */
public class ConsoleGameMain {

	public static void main(String[] args) throws IOException {
		Map map = new Map();
		Pacman pacman = new Pacman(13, 10);
		Ghost ghost = new Ghost(15, 10, Direction.LEFT);
		GameRules rules = new GameRules(map, pacman, ghost);
		GameRenderer renderer = new GameRenderer(map, pacman, ghost);
		while (!rules.isPacmanEaten()) {
			renderer.drawFrame();
			rules.moveGhost();
			Command command = ConsoleUserInputReader.readUserInput();
			rules.processCommand(command);
		}
		rules.endGame();
	}

}
