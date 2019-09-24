package lt.visma.vgtu.s2019;

/***
 * Reprezentuoja "Vaiduokliuko" veikėjo abstrakciją.
 * 
 * Šioje versijoje turi savo poziciją, į kurią gali persikelti, ir judėjimo
 * kryptį, bet ateityje gali žinoti savo "gyvybių" skaičių, "agresijos" būseną
 * ir t.t.
 * 
 * Ši klasė nesirūpina, kaip vaiduokliuką atvaizduoti ekrane (piešimas labai
 * priklauso nuo platformos), tiesiog žino vaiduokliuko būseną ir moka ją
 * keisti.
 *
 */
public class Ghost extends Character {
	Direction movementDirection;

	public Ghost(int x, int y, Direction movementDirection) {
		super(x, y);
		this.movementDirection = movementDirection;
	}

	public Position getDesiredPosition() {
		return super.getPositionIfMoved(movementDirection);
	}

	public void changeDirection() {
		movementDirection = movementDirection.opposite();
	}
}