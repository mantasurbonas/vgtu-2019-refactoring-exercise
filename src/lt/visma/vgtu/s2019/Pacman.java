package lt.visma.vgtu.s2019;

public class Pacman {
	Position position;

	public Pacman(int x, int y) {
		this.position = new Position(x, y);
	}

	public void moveTo(Position where) {
		position = where;
	}

}
