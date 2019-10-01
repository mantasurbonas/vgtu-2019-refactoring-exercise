package lt.visma.vgtu.s2019;

import java.awt.*;

public abstract class Player implements PlayerInterface {
    Position position;

    public void moveTo(Position newPosition) {
        position = newPosition;
    }

}
