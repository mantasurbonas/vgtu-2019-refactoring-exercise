package lt.visma.vgtu.s2019;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class ElementDrawer {

    private BufferedImage pacmanImg;
    private BufferedImage ghostImg;
    private BufferedImage wallImg;
    private Pacman pacman;
    private Ghost ghost;
    private Map map;

    public ElementDrawer(Map map, Pacman pacman, Ghost ghost) throws IOException {
        this.map = map;
        this.pacman = pacman;
        this.ghost = ghost;
        initImages();
    }

    private void drawElement(Graphics g, int x, int y) {
        Image image = getImage(x, y);
        if (image != null)
            g.drawImage(image, 50 + x * 20, 50 + y * 20, 20, 20, null);
    }

    private void initImages() throws IOException {
        pacmanImg = ImageIO.read(new FileInputStream("pacman-open.png"));
        ghostImg = ImageIO.read(new FileInputStream("ghost.png"));
        wallImg = ImageIO.read(new FileInputStream("wall.png"));
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

    public void drawMap(Graphics g, Map map) {
        for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                drawElement(g, x, y);
            }
        }
    }
}
