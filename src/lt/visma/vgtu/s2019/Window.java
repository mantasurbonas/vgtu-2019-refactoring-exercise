/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.visma.vgtu.s2019;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author katinas
 */
public class Window {
    Map map;
    Pacman pacman;
    Ghost ghost;

    public Window(Map map, Pacman pacman, Ghost ghost) {
        this.map = map;
        this.pacman = pacman;
        this.ghost = ghost;
    }
    
    public void drawElement(Graphics g, int x, int y) {
            Image image = getImage(x, y);
            if (image != null)
                    g.drawImage(image, 50+x*20, 50+y*20, 20, 20, null);
    }

    private Image getImage(int x, int y) {
            if (pacman.position.x == x && pacman.position.y == y) 
                    return pacman.getImage();

            if (ghost.position.x == x && ghost.position.y == y)
                    return ghost.getImage();

            int element = map.getMapElement(y, x);

            if (element == 0)
                    return null;

            return map.getImage();
    }
}
