package lt.visma.vgtu.s2019;

public class Ghost{
	Position position;

	int ghostDx = -1;
	int ghostDy = 0;

	public Ghost(int x, int y, int dx, int dy) {
		this.position = new Position(x, y);
		this.ghostDx = dx;
		this.ghostDy= dy;
	}

	public Position getDesiredPosition() {
		return new Position(position.x + ghostDx, position.y + ghostDy);
	}

	public void setPosition(Position newGhostPosition) {
		position = newGhostPosition;
	}

	public void changeDirection() {
		ghostDx = -1*ghostDx;
		ghostDy = -1*ghostDy;
	}

}