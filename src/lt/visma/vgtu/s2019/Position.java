package lt.visma.vgtu.s2019;

/***
 * abstraktus duomenų tipas - "x ir y koordinatė" 2d erdvėje.
 *
 */
public class Position {
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isEqual(Position position) {
		return this.x == position.x && this.y == position.y;
	}

	public boolean isEqual(int x, int y) {
		return this.x == x && this.y == y;
	}

	public void move(Direction direction) {
		switch (direction) {
		case UP:
			y -= 1;
			break;
		case RIGHT:
			x += 1;
			break;
		case DOWN:
			y += 1;
			break;
		case LEFT:
			x -= 1;
			break;
		}
	}
}
