package lt.visma.vgtu.s2019;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Ghost{
	Position position;
	private BufferedImage ghostImg;
        
	int ghostDx = -1;
	int ghostDy = 0;
	
	public Ghost(int x, int y, int dx, int dy) {
		this.position = new Position(x, y);
		this.ghostDx = dx;
		this.ghostDy= dy;
	}
        
        public Ghost(int x, int y, int dx, int dy, String image) throws IOException {
		this.position = new Position(x, y);
		this.ghostDx = dx;
		this.ghostDy= dy;
                ghostImg = ImageIO.read(new FileInputStream(image));
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
        
        public Image getImage(){
            return ghostImg;
        }
}