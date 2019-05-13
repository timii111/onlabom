package sample.models;

import sample.enums.ColorType;
import sample.enums.TileType;

/**
    játéktábla egy elemét, mezőjét reprezentáló objektum
 */
public class BoardTile {

    /** mező típusa */
    private TileType type;
    /** megmutatja, van e gomb a mezőn - alapból nincs */
    private boolean hasButton = false;
    /** megmutatja a mezőn lévő gomb színét - alapból nincs */
    private ColorType buttonColor = ColorType.NONE;
    /** megmutatja, van e felszedendő objektum a mezőn - alapból nincs */
    private boolean hasKey = false;
    /** megmutatja  afelszedendő objektum színét - alapból nincs */
    private ColorType keyColor = ColorType.NONE;
    /** képelérési út összeállításához szükséges változó */
    private String imagePath;

    /**
        konstruktor, a beolvasott stringek tömbjéből hozzuk létre
        beállítja a megfelelő változókat
     */
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

    /**
        összeállítja a mező kirajzolásához szükséges fájlelérési utat a mező aktuális állapotának megfelelően
        ezt az elérési utat adja vissza
        megjelenítéshez szükséges
     */
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

    /** visszaadja a mező típust */
    public TileType getType() {
        return type;
    }

    /** gomb megnyomását mutatja - visszaadja a gomb színét (akkor is, ha nincs) */
    public ColorType push(){
        return buttonColor;
    }

    /** visszaadja a mezőn lévő kulcs színét - akkor is, ha nincs */
    public ColorType getKeyColor() {
        return keyColor;
    }

    /** beállítja, van e kulcs a mezőn */
    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    /** megevést szombolzálja, eltűnteti a kulcsot, ha van a mezőn */
    public void eat(){
        setHasKey(false);
        keyColor = ColorType.NONE;
    }

    /** visszaállítja a mezőre a már megevett kulcsot, az adott színűre */
    public void addEatingObject(ColorType c){
        setHasKey(true);
        keyColor = c;
    }
}
