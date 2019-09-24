package lt.visma.vgtu.s2019;

/***
 * Užtikrina žaidimo taisyklių laikymąsi: Pacmano judėjimą per žemėlapį pagal
 * vartotojo komandas vaiduokliuko judėjimą nustato, ar žaidimas jau baigtas (ar
 * vaiduokliukas suvalgė pacmaną)
 * 
 */
public class GameRules {

	private Ghost ghost;
	private Pacman pacman;
	private Map map;

	public GameRules(Map map, Pacman pacman, Ghost ghost) {
		this.map = map;
		this.pacman = pacman;
		this.ghost = ghost;
	}

	public boolean isPacmanEaten() {
		return pacman.position.x == ghost.position.x && ghost.position.y == pacman.position.y;
	}

	public void processCommand(int command) {
		if (isEndGameCommand(command))
			System.exit(0);

		movePacman(command);
	}

	public void moveGhost() {
		Position ghostDesiredPosition = ghost.getDesiredPosition();

		if (map.isEmpty(ghostDesiredPosition))
			ghost.setPosition(ghostDesiredPosition);
		else
			ghost.changeDirection();
	}

	private boolean isEndGameCommand(int command) {
		return command == 'q';
	}

	private void movePacman(int command) {
		Position pacmanDesiredPosition = changePositionByUserCommand(pacman.position, command);

		if (map.isEmpty(pacmanDesiredPosition))
			pacman.moveTo(pacmanDesiredPosition);
	}

	private Position changePositionByUserCommand(Position oldPosition, int command) {
		Position desiredPosition = new Position(oldPosition.x, oldPosition.y);

		switch (command) {
		case 'a':
			desiredPosition.moveLeft();
			break;
		case 'd':
			desiredPosition.moveRight();
			break;
		case 'w':
			desiredPosition.moveUp();
			break;
		case 's':
			desiredPosition.moveDown();
			break;
		}
		return desiredPosition;
	}
}
