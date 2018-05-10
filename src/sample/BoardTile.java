package sample;

public class BoardTile {

    private TileType type;
    private boolean hasButton = false;
    private ColorType buttonColor = ColorType.NONE;
    private boolean hasKey = false;
    private ColorType keyColor = ColorType.NONE;


    public BoardTile(String[] args) {
        type = TileType.valueOf(args[0]);
        if (args.length > 1) {
            if (args[1] == "KEY") {
                hasKey = true;
                keyColor = ColorType.valueOf(args[2]);
            } else if (args[1] == "BUTTON") {
                hasButton = true;
                buttonColor = ColorType.valueOf(args[2]);
            } else if (args[1] == "END") {
                keyColor = ColorType.END;
            }
        }

    }

    //TODO ez még csak teszt, grafikus megjelenítést kialakítani
    public String draw(String s) {

        switch (type) {
            case PATH:
                if (hasKey) {
                    s += "!";
                } else if (hasButton) {
                    s += "?";
                } else {
                    s += ".";
                }

                break;
            case WATER:
                s += "-";
                break;


        }
        return s;

    }
}
