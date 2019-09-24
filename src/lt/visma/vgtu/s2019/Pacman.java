package lt.visma.vgtu.s2019;

/***
 * Reprezentuoja "Pacmano" veikėjo abstrakciją.
 * 
 * Šioje versijoje turi savo poziciją, į kurią gali persikelti, bet ateityje
 * gali žinoti savo "gyvybių" skaičių, žiūrėjimo kryptį ir t.t.
 * 
 * Ši klasė nesirūpina, kaip Pacmaną atvaizduoti ekrane (piešimas labai
 * priklauso nuo platformos), tiesiog žino Pacmano būseną ir moka ją keisti.
 *
 */
public class Pacman extends Character {
	public Pacman(int x, int y) {
		super(x, y);
	}
}
