package lt.visma.vgtu.s2019;

import java.awt.*;

/***
 *  Reprezentuoja "Pacmano" veikėjo abstrakciją.
 * 
 *  Šioje versijoje turi savo poziciją, į kurią gali persikelti, 
 *  bet ateityje gali žinoti savo "gyvybių" skaičių, žiūrėjimo kryptį ir t.t.
 *  
 *  Ši klasė nesirūpina, kaip Pacmaną atvaizduoti ekrane (piešimas labai priklauso nuo platformos), 
 *  tiesiog žino Pacmano būseną ir moka ją keisti.
 *
 */
class Pacman extends Player {

	Pacman(int x, int y) {
		this.position = new Position(x, y);
	}

}
