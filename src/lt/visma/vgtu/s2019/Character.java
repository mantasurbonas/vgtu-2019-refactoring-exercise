package lt.visma.vgtu.s2019;

public class Character {
    Position position;

    public Character(int x, int y) {
        this.position = new Position(x, y);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPositionIfMoved(Direction where) {
        Position position = new Position(this.position.x, this.position.y);
        position.move(where);
        return position;
    }
}
