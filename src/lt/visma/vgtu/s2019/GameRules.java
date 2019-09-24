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
		return ghost.position.isEqual(pacman.position);
	}

	public void processCommand(Command command) {
		if (isEndGameCommand(command))
			endGame();
		movePacman(command);
	}

	public void endGame() {
		System.exit(0);
	}

	public void moveGhost() {
		Position ghostDesiredPosition = ghost.getDesiredPosition();

		if (map.isEmpty(ghostDesiredPosition))
			ghost.setPosition(ghostDesiredPosition);
		else
			ghost.changeDirection();
	}

	private boolean isEndGameCommand(Command command) {
		return command == Command.QUIT;
	}

	private void movePacman(Command command) {
		Position pacmanDesiredPosition = pacman.getPositionIfMoved(command.getDirection());

		if (map.isEmpty(pacmanDesiredPosition))
			pacman.setPosition(pacmanDesiredPosition);
	}
}
