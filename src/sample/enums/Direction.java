package sample.enums;

/**
    irányt reprezentáló osztály
    robot mozagtásánál használjuk fel
 */
public enum Direction {

    RIGHT,
    LEFT,
    UP,
    DOWN;

    /** megmutatja, melyik irány van jobbra az aktuálistól, mi lesz az új irány, ha jobbra fordulunk */
    private Direction right;
    /** megmutatja, melyik irány van balra az aktuálistól, mi lesz az új irány, ha balra fordulunk */
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
