package lt.visma.vgtu.s2019;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

/***
 *  Reprezentuoja "Vaiduokliuko" veikėjo abstrakciją.
 * 
 *  Šioje versijoje turi savo poziciją, į kurią gali persikelti, ir judėjimo kryptį, 
 *  bet ateityje gali žinoti savo "gyvybių" skaičių, "agresijos" būseną ir t.t.
 *  
 *  Ši klasė nesirūpina, kaip vaiduokliuką atvaizduoti ekrane (piešimas labai priklauso nuo platformos), 
 *  tiesiog žino vaiduokliuko būseną ir moka ją keisti.
 *
 */
public class Ghost{
	Position position;
	BufferedImage image;
	
	private int ghostDx;
	private int ghostDy;
	
	Ghost (int x, int y, int dx, int dy) throws IOException {
		image = ImageIO.read(new FileInputStream("ghost.png"));
		this.position = new Position(x, y);
		this.ghostDx = dx;
		this.ghostDy= dy;
	}
	
	Position getDesiredPosition() {
		return new Position(position.x + ghostDx, position.y + ghostDy);
	}

	void setPosition(Position newGhostPosition) {
		position = newGhostPosition;
	}

	void changeDirection() {
		ghostDx = -1*ghostDx;
		ghostDy = -1*ghostDy;
	}
}