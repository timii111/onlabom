package sample.controllers;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.transform.Affine;
import sample.Play;
import sample.WrongStepError;
import sample.enums.ColorType;
import sample.enums.TileType;
import sample.models.Board;
import sample.models.Robot;

public class BoardController {

    /** rajzobjektum a felületen */
    private Canvas canvas;
    /** rajzoláshoz használt grapchicscontext */
    private GraphicsContext gc;
    /** a játékban irányítandó aktuális robotobjektum */
    private Robot myRobot;
    /** aktuális játéktábla */
    private Board myBoard;
    /** a megevett objektumok száma a játék egy futása során */
    private int objectsEaten = 0;
    /** a rajzolt mezők mérete, alapértékkel */
    public int tileSize = 80;
    /** visszacsatolást adó címke a felületen, ide kerülnek a hibák és a futtatás eredménye */
    private Label messageLabel;

    /** konstruktor */
    public BoardController(Canvas canvas, Label msgLabel) {

        this.canvas = canvas;
        this.messageLabel = msgLabel;
    }

    /**
     * játék indításáért felelős, nem csak indításkoz használatos
     * beállítja a robotot és a táblát
     * betölti a képeket
     * nullázza a megevett objektumokat
     * inicializál minden felületibeállítást
     * üres szöveggel kezdünk
     */
    public void start() {

        myRobot = Play.getInstance().getMyRobot();
        myBoard = Play.getInstance().getMyBoard();
        loadImages();
        objectsEaten = 0;
        reloadIt();

    }

    /**
     * letörli a rajztáblát
     */
    public void clearCanvas(){
        gc = canvas.getGraphicsContext2D();
        gc.clearRect(0,0,1000,1000);
    }


    /**
     * újra gombot reprezentálja
     * visszaállítja a felületet újsza szerkeszthető állapotba
     * újraindítja a játékot, robotot, újratölti a képeket
     * nullázza a megevett objektumokat
     */
    public void reloadIt() {
        Play.getInstance().start();

        myBoard = Play.getInstance().getMyBoard();
        myRobot.setMyBoard(myBoard);
        
        myRobot.reload();
        loadImages();
        drawRobot();
        objectsEaten = 0;
    }


    /**
     * beállítja a graphicscontextet
     * lekéri a betöltendő képek elérési útjait
     * kirajzolja a táblát a képekből
     * kirajzolja a robotot
     */
    public void loadImages() {
        gc = canvas.getGraphicsContext2D();

        String[][] images = Play.getInstance().start();

        int h = images.length;
        int w = images[0].length;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Image im = new Image(images[i][j]);
                gc.drawImage(im, j * tileSize, i * tileSize, tileSize, tileSize);
            }
        }

        drawRobot();
    }

    /**
     * a robot aktuális pozíciójában lévő mezőt letörli
     * lekéri az új mezőtípust és kirajzolja
     */
    public void reDrawTile() {
        int x = myRobot.getActualPosition().getX();
        int y = myRobot.getActualPosition().getY();

        gc.clearRect(x * tileSize + 1, y * tileSize + 1, tileSize - 1, tileSize - 1);

        Image im = new Image(myBoard.getTileType(x, y));
        gc.drawImage(im, x * tileSize, y * tileSize, tileSize, tileSize); //-1 az elcsúszás kezelésére
    }

    /**
     * robot kirajzolása
     * beállítja a megfelelő forgatást a képre az iránynak megfelelően
     * majd kirajzolja a robotot
     */
    public void drawRobot() {
        int rotationAngle = 0;
        switch (myRobot.getMyDirection()) {
            case DOWN:
                rotationAngle = 0;
                break;
            case UP:
                rotationAngle = 180;
                break;
            case LEFT:
                rotationAngle = 90;
                break;
            case RIGHT:
                rotationAngle = -90;
                break;
        }

        gc.save();
        Affine rotate = new Affine();
        rotate.appendRotation(rotationAngle, myRobot.getActualPosition().getX() * tileSize + tileSize / 2, myRobot.getActualPosition().getY() * tileSize + tileSize / 2);
        gc.setTransform(rotate);
        gc.drawImage(new Image("pics/ROBOT_" + myRobot.getColor() + ".png"), myRobot.getActualPosition().getX() * tileSize, myRobot.getActualPosition().getY() * tileSize, tileSize, tileSize);
        gc.restore();
    }

    /**
     * robot haladását reprezentálja
     * robot irányának megfelelően meghívja a megfelelő függvényt
     *
     * @return visszaadja a sikerességét
     */
    public boolean go() throws WrongStepError {
        switch (myRobot.getMyDirection()) {
            case RIGHT:
                return goRight();
            case LEFT:
                return goLeft();
            case UP:
                return goUp();
            case DOWN:
                return goDown();
        }
        return false;
    }

    /**
     * a robot lépését visszaállító metódus
     */
    public boolean goBack() throws WrongStepError {
        switch (myRobot.getMyDirection()) {
            case RIGHT:
                return goLeft();
            case LEFT:
                return goRight();
            case UP:
                return goDown();
            case DOWN:
                return goUp();
        }
        return false;
    }

    /**
     * a robotot jobbra mozgatja
     * újrarajzolja a helyét
     * majd kirajzolja az új helyre, ha nem lépett hibás mezőre
     *
     * @return a lépés sikerességét mutatja
     */
    public boolean goRight() throws WrongStepError {
        reDrawTile();
        boolean b = myRobot.goRight();
        if (b) {
            drawRobot();
        } else {
            somethingWentWrong();
        }
        return b;
    }

    /**
     * a robotot balra mozgatja
     * újrarajzolja a helyét
     * majd kirajzolja az új helyre, ha nem lépett hibás mezőre
     *
     * @return a lépés sikerességét mutatja
     */
    public boolean goLeft() throws WrongStepError {
        reDrawTile();
        boolean b = myRobot.goLeft();
        if (b) {
            drawRobot();
        } else {
            somethingWentWrong();
        }
        return b;
    }

    /**
     * a robotot lefelé mozgatja
     * újrarajzolja a helyét
     * majd kirajzolja az új helyre, ha nem lépett hibás mezőre
     *
     * @return a lépés sikerességét mutatja
     */
    public boolean goDown() throws WrongStepError {
        reDrawTile();
        boolean b = myRobot.goDown();
        if (b) {
            drawRobot();
        } else {
            somethingWentWrong();
        }
        return b;
    }

    /**
     * a robotot felfelé mozgatja
     * újrarajzolja a helyét
     * majd kirajzolja az új helyre, ha nem lépett hibás mezőre
     *
     * @return a lépés sikerességét mutatja
     */
    public boolean goUp() throws WrongStepError {
        reDrawTile();
        boolean b = myRobot.goUp();
        if (b) {
            drawRobot();
        } else {
            somethingWentWrong();
        }
        return b;
    }

    /**
     * robotot jobbra forgatja
     * törli a helyét, majd újrarajzolja a robotot
     */
    public void turnRight() {
        reDrawTile();
        myRobot.turnRight();
        drawRobot();
    }

    /**
     * robotot balra forgatja
     * törli a helyét, majd újrarajzolja a robotot
     */
    public void turnLeft() {
        reDrawTile();
        myRobot.turnLeft();
        drawRobot();
    }

    /**
     * gomb megnyomását reprezentálja
     * újrarajzolja a mezőt
     * majd a robotot is, a megnyomás után, a megváltozott állapotában
     */
    public ColorType pushTile() {
        reDrawTile();
        ColorType c = myBoard.getTile(myRobot.getActualPosition()).push();
        myRobot.setColor(c);
        drawRobot();
        return c;
    }

    /**
     * gomb megnyomását visszaállító metódus
     * újrarajzolja a felületi elemeket
     */
    public ColorType unPushTile(ColorType c) {
        reDrawTile();
        myRobot.setColor(c);
        drawRobot();
        return c;
    }

    /**
     * objektum megevésére szolgál
     * ha megfelelő, nem nulla színű objektumon van, akkor megeszi az obektumot, és ezt számolja is
     * újrarajzolja a mezőt és a robotot
     */
    public ColorType eatObject() {
        ColorType c = myBoard.getTile(myRobot.getActualPosition()).getKeyColor();
        if (getRobotColor() != ColorType.NONE && getRobotColor() == c) {
            objectsEaten++;
            myBoard.eat(myRobot.getActualPosition());
        }
        reDrawTile();
        drawRobot();
        return c;
    }

    /**
     * megevett kulcs visszaállítására szolgáló metódus
     * @param c a visszaállított objektum színe
     */
    public void addEatingObject(ColorType c) {

        objectsEaten--;
        myBoard.addEatingObject(myRobot.getActualPosition(), c);

        reDrawTile();
        drawRobot();
    }

    /**
     * visszaadja a robot színét
     */
    public ColorType getRobotColor() {
        return myRobot.getColor();
    }

    /**
     * játék végét kezelő függvény
     * ha mindent megettünk:
     * ha a célban állunk, sikert jelzünk és betöltjük a következő pályát, ha van még
     * ha nem célban állunk, jelezzük, hogy oda kell eljutni
     * ha nem ettünk meg mindent, jelezzük a hibát
     * a jelzések megfelelő szövegek, az esetleges hibákhoz hozzáfűzve
     */
    public boolean ended() {
        if (objectsEaten == myBoard.getNumberOfObjects()) {

            if (myBoard.getTile(myRobot.getActualPosition()).getType() == TileType.END) {

                boolean b = Play.getInstance().next();
                if (b) {
                    start();
                    messageLabel.setText("Gratula, ügyi voltál! :) Tessék, a következő pálya!");
                } else {
                    messageLabel.setText("Gratula, ügyi voltál! :) Elfogytak a pályák");
                }
                return true;
            } else {
                messageLabel.setText("Már majdnem kész vagy, de a célban kell befejezned!");
                return false;
            }
        } else {
            messageLabel.setText("Nem sikerült mindent összeszedni, nem teljesítetted a pályát. :(");
            return false;
        }
    }

    /**
     * hiba jelzés a felhasználó felé
     */
    private void somethingWentWrong() throws WrongStepError {
        messageLabel.setText("Valamit elrontottál, próbáld újra!");
        throw new WrongStepError();
    }

    /**
     * a kapott string alapján rajzolja ki a pályát
     * pályagenerálásnál használatos
     * @param str
     */
    public void drawBoard(String str) {

        gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 1000, 1000);
        String[][] images = Play.getInstance().draw(str.toUpperCase());

        myRobot = Play.getInstance().getMyRobot();
        myBoard = Play.getInstance().getMyBoard();

        int h = images.length;
        int w = images[0].length;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Image im = new Image(images[i][j]);
                gc.drawImage(im, j * tileSize, i * tileSize, tileSize, tileSize);
            }
        }

        drawRobot();

        objectsEaten = 0;
    }

    /**
     * hibajelzés
     */
    public void erroring() {
        messageLabel.setText("valami hiba történt");
    }

    /**
     * visszaadja a jelenleg, robot alatt lévő aktív mező típusát
     */
    public String getActualTileType(){
        return myBoard.getTileType(myRobot.getActualPosition()).toString();
    }
}
