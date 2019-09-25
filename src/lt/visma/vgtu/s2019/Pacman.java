package lt.visma.vgtu.s2019;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Pacman {
	Position position;
        private BufferedImage pacmanImg;

	public Pacman(int x, int y) {
		this.position = new Position(x, y);
	}
        
        public Pacman(int x, int y, String imgLocation) throws IOException {
		this.position = new Position(x, y);
                pacmanImg = ImageIO.read(new FileInputStream(imgLocation));
	}

	public void moveTo(Position where) {
		position = where;
	}
        
        public Image getImage(){
            return pacmanImg;
        }
}
