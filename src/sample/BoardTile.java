package sample;

public class BoardTile {

    private TileType type;
    private boolean hasButton = false;
    private ColorType buttonColor = ColorType.NONE;
    private boolean hasKey = false;
    private ColorType keyColor = ColorType.NONE;

    private String imagePath;

    public BoardTile(String[] args) {
        type = TileType.valueOf(args[0]);
        if (args.length > 1) {
            if (args[1].equals("KEY")) {
                hasKey = true;
                keyColor = ColorType.valueOf(args[2]);
            } else if (args[1].equals("BUTTON")) {
                hasButton = true;
                buttonColor = ColorType.valueOf(args[2]);
            }
        }

    }

    //TODO ez még csak teszt, grafikus megjelenítést kialakítani
    public String draw() {

        switch (type) {
            case PATH:
                if (hasKey) {
                    imagePath = "pics/PATH_KEY_" + keyColor.toString() + ".png";
                } else if (hasButton) {
                    imagePath = "pics/PATH_BUTTON_" + buttonColor.toString() + ".png";
                } else {
                    imagePath = "pics/PATH.png";
                }

                break;
            case WATER:
                imagePath = "pics/WATER.png";
                break;
            case END:
                imagePath = "pics/END.png";
        }

        return imagePath;

    }
}
