package lt.visma.vgtu.s2019;

enum Direction {
    UP, RIGHT, DOWN, LEFT;

    public Direction opposite() {
        switch (this) {
        case UP:
            return Direction.DOWN;
        case RIGHT:
            return Direction.LEFT;
        case DOWN:
            return Direction.UP;
        case LEFT:
            return Direction.RIGHT;
        default:
            throw new IllegalStateException("This should never happen: " + this + " has no opposite.");
        }
    }
}