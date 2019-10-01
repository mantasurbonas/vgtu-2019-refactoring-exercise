package lt.visma.vgtu.s2019;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class ImagesRenderer {
    private BufferedImage pacmanImg;
    private BufferedImage ghostImg;
    private BufferedImage wallImg;

    ImagesRenderer() throws IOException {
        this.pacmanImg = ImageIO.read(new FileInputStream("pacman-open.png"));
        this.ghostImg = ImageIO.read(new FileInputStream("ghost.png"));
        this.wallImg = ImageIO.read(new FileInputStream("wall.png"));
    }

    BufferedImage getPacmanImg() {
        return pacmanImg;
    }

    BufferedImage getGhostImg() {
        return ghostImg;
    }

    BufferedImage getWallImg() {
        return wallImg;
    }

}
