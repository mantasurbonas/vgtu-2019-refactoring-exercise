package lt.visma.vgtu.s2019;

import java.util.Arrays;

enum Command {
    MOVEUP('w'), MOVERIGHT('d'), MOVEDOWN('s'), MOVELEFT('a'), QUIT('q');

    private char commandChar;

    Command(char commandChar) {
        this.commandChar = commandChar;
    }

    public static Command valueOf(char commandChar) {
        return Arrays.stream(values()).filter(command -> command.commandChar == commandChar).findFirst().get();
    }

    public Direction getDirection() {
        switch (this) {
        case MOVEUP:
            return Direction.UP;
        case MOVERIGHT:
            return Direction.RIGHT;
        case MOVEDOWN:
            return Direction.DOWN;
        case MOVELEFT:
            return Direction.LEFT;
        default:
            throw new IllegalStateException("This should never happen: " + this + " has accoding direction");
        }
    }
}