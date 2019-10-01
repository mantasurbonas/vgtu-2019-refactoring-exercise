package lt.visma.vgtu.s2019;

import java.awt.*;
import java.io.IOException;

class ElementsDrawer {

    private ImagesRenderer imagesRenderer = new ImagesRenderer();
    private Map map;
    private Pacman pacman;
    private Ghost ghost;

    ElementsDrawer(Map map, Pacman pacman, Ghost ghost) throws IOException {
        this.map = map;
        this.pacman = pacman;
        this.ghost = ghost;
    }

    void drawElement(Graphics g, int x, int y) {
        Image image = getImage(x, y);
        if (image != null)
            g.drawImage(image, 50+x*20, 50+y*20, 20, 20, null);
    }

    private Image getImage(int x, int y) {
        if (ghost.position.x == x && ghost.position.y == y)
            return imagesRenderer.getGhostImg();

        if (pacman.position.x == x && pacman.position.y == y)
            return imagesRenderer.getPacmanImg();
        int element = map.getMapElement(y, x);
        if (element == 0)
            return null;
        return imagesRenderer.getWallImg();
    }
}
