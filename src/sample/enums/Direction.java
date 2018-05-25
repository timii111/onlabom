package sample.enums;

public enum Direction {

    RIGHT,
    LEFT,
    UP,
    DOWN;

    private Direction right;
    private Direction left;

    static{
        RIGHT.right = DOWN;
        DOWN.right = LEFT;
        LEFT.right = UP;
        UP.right = RIGHT;

        RIGHT.left = UP;
        DOWN.left = RIGHT;
        LEFT.left = DOWN;
        UP.left = LEFT;
    }

    public Direction getLeft() {
        return left;
    }

    public Direction getRight() {
        return right;
    }
}
