package lt.visma.vgtu.s2019;

import java.io.IOException;

/***
 * programos pradžia (t.y. konsolinio žaidimo pagrindinė logika) 
 *
 */
public class ConsoleGameMain {

	// TODO load letters
	private static Map map = new Map(new ElementLetterRepresentationImpl());
	private static Pacman pacman = new Pacman(10,10, new ElementLetterRepresentationImpl() );
	private static Ghost ghost = new Ghost(15, 12, -1, 0, new ElementLetterRepresentationImpl());

	public static void main(String[] args) throws IOException{

		loadImages();

		GameRules rules = new GameRules(map, pacman, ghost);
		
		GameRenderer renderer = new GameRenderer(map, pacman, ghost);
		
		while(true){
			renderer.drawFrame();
			
			if (rules.isPacmanEaten())
				System.exit(0);
			
			rules.moveGhost();
			
			int command = ConsoleUserInputReader.readUserInput();
			
			rules.processCommand(command);
		}
	}

	private static void loadImages(){
		map.wall.setImage('#');
		pacman.image.setImage('C');
		ghost.image.setImage('W');
	}

}
