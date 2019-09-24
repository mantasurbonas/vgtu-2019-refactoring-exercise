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

	public void moveDown() {
		y += 1;
	}

	public void moveUp() {
		y -= 1;
	}

	public void moveRight() {
		x += 1;
	}

	public void moveLeft() {
		x -= 1;
	}

}
