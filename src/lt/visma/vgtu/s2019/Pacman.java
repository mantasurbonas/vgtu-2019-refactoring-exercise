package lt.visma.vgtu.s2019;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
public class Pacman {
	Position position;

	BufferedImage image;

	Pacman(int x, int y) throws IOException {
		image = ImageIO.read(new FileInputStream("pacman-open.png"));
		this.position = new Position(x, y);
	}

	void moveTo(Position where) {
		position = where;
	}
}
