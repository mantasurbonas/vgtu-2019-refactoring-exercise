package lt.visma.vgtu.s2019;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Window{
    Map map;
    Pacman pacman;
    Ghost ghost;

    BufferedImage pacmanImg;
    BufferedImage ghostImg;
    BufferedImage wallImg;

    public Window(Map map, Pacman pacman, Ghost ghost) {
        this.map = map;
        this.pacman = pacman;
        this.ghost = ghost;
    }
    
    public void setGhostImg(String imageSrc) throws IOException {
        this.ghostImg = ImageIO.read(new FileInputStream(imageSrc));
    }

    public void setWallImg(String imageSrc) throws IOException {
        this.wallImg = ImageIO.read(new FileInputStream(imageSrc));
    }

    public void setPacmanImg(String imageSrc) throws IOException {
        this.pacmanImg = ImageIO.read(new FileInputStream(imageSrc));
    }

    public void drawElement(Graphics g, int x, int y) {
        Image image = getImage(x, y);
        if (image != null)
            g.drawImage(image, 50+x*20, 50+y*20, 20, 20, null);
    }

    private Image getImage(int x, int y) {
        if (pacman.position.x == x && pacman.position.y == y)
            return pacmanImg;

        if (ghost.position.x == x && ghost.position.y == y)
            return ghostImg;

        int element = map.getMapElement(y, x);

        if (element == 0)
            return null;

        return wallImg;
    }


}
