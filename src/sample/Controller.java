package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.transform.Affine;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import sample.antlrelements.MyLanguageLexer;
import sample.antlrelements.MyLanguageParser;
import sample.enums.ColorType;
import sample.enums.TileType;
import sample.models.Board;
import sample.models.Robot;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller osztály
 * kapcsolatot tart a ui és a modellek között
 * kapcsolatot tart a visitorral
 */
public class Controller implements Initializable {
    /** szövegbeviteli mező a felületen */
    @FXML
    private TextArea txtarea;
    /** rajzobjektum a felületen */
    @FXML
    private Canvas canvas;
    /** futtatást indító gomb a felületen */
    @FXML
    private Button startBtn;
    /** bevitelt törlő gomb a felületen */
    @FXML
    private Button clearBtn;
    /** visszacsatolást adó címke a felületen, ide kerülnek a hibák és a futatás eredménye */
    @FXML
    private Label messageLabel;
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

    /** konstruktor */
    public Controller() {

    }

    /**
     * inicializáláskor elindítja a játékot
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start();
    }

    /**
     * játék indításáért felelős, nem csak indításkoz használatos
     * beállítja a robotot és a táblát
     * betölti a képeket
     * nullázza a megevett objektumokat
     * inicializál minden felületibeállítást
     * üres szöveggel kezdünk
     */
    public void start(){
        myRobot = Play.getInstance().getMyRobot();
        myBoard = Play.getInstance().getMyBoard();
        loadImages();
        objectsEaten = 0;
        reloadIt();
        txtarea.setText("");
    }

    /**
     * indító gomb által meghvíott függvény, lefuttatja a kód fordítását és értelmezését
     * beállítja  amegfelelő felületi elemeket, hogy a futtatáshoz ne lehessen módosítani a kódon
     * fordítás és visitor elindítása
     */
    @FXML
    public void printIt() {

        startBtn.setDisable(true);
        clearBtn.setDisable(true);
        messageLabel.setText("");
        txtarea.setDisable(true);

        CodePointCharStream mystream = CharStreams.fromString(txtarea.getText());
        MyLanguageLexer mylexer = new MyLanguageLexer(mystream);
        CommonTokenStream tokstr = new CommonTokenStream(mylexer);
        MyLanguageParser myparser = new MyLanguageParser(tokstr);

        myVisitor mv = new myVisitor(this);
        mv.visitProgram(myparser.program());
    }

    /**
     * újra gombot reprezentálja
     * visszaállítja a felületet újsza szerkeszthető állapotba
     * újraindítja a játékot, robotot, újratölti a képeket
     * nullázza a megevett objektumokat
     */
    public void reloadIt() {
        startBtn.setDisable(false);
        clearBtn.setDisable(false);
        messageLabel.setText("");
        txtarea.setDisable(false);
        Play.getInstance().start();

        myRobot.reload();
        loadImages();
        drawRobot();
        objectsEaten = 0;
    }

    /** kitörli a beírt kódot */
    public void deleteAll(ActionEvent actionEvent) {
        txtarea.clear();
    }

    /**
     * beállítja a graphicscontextet
     * lekéri a betöltendő képek elérési útjait
     * kirajzolja a táblát a képekből
     * kirajzolja a robotot
     */
    @FXML
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

        gc.clearRect(x * tileSize+1, y * tileSize+1, tileSize-1, tileSize-1);

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
        gc.drawImage(new Image("pics/ROBOT_"+myRobot.getColor()+".png"), myRobot.getActualPosition().getX() * tileSize, myRobot.getActualPosition().getY() * tileSize, tileSize, tileSize);
        gc.restore();
    }

    /**
     * robot haladását reprezentálja
     * robot irányának megfelelően meghívja a megfelelő függvényt
     * @return
     */
    public boolean go() {
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
     * a robotot jobbra mozgatja
     * újrarajzolja a helyét
     * majd kirajzolja az új helyre, ha nem lépett hibás mezőre
     * @return a lépés sikerességét mutatja
     */
    public boolean goRight() {
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
     * @return a lépés sikerességét mutatja
     */
    public boolean goLeft() {
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
     * @return a lépés sikerességét mutatja
     */
    public boolean goDown() {
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
     * @return a lépés sikerességét mutatja
     */
    public boolean goUp() {
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
    public void pushTile(){
        reDrawTile();
        myRobot.setColor(myBoard.getTile(myRobot.getActualPosition()).push());
        drawRobot();
    }

    /**
     * objektum megevésére szolgál
     * ha megfelelő, nem nulla színű objektumon van, akkor megeszi az obektumot, és ezt számolja is
     * újrarajzolja a mezőt és a robotot
     */
    public void eatObject(){

        if(getRobotColor()!=ColorType.NONE && getRobotColor()==myBoard.getTile(myRobot.getActualPosition()).getKeyColor()){
            objectsEaten++;
            myBoard.eat(myRobot.getActualPosition());
        }
        reDrawTile();
        drawRobot();
    }

    /** visszaadja a robot színét */
    public ColorType getRobotColor() {
        return myRobot.getColor();
    }

    /**
     * játék végét kezelő függvény
     * ha mindent megettünk:
     *      ha a célban állunk, sikert jelzünk és betöltjük a következő pályát, ha van még
     *      ha nem célban állunk, jelezzük, hogy oda kell eljutni
     * ha nem ettünk meg mindent, jelezzük a hibát
     * a jelzések megfelelő szövegek, az esetleges hibákhoz hozzáfűzve
     */
    public void ended() {
        if (objectsEaten == myBoard.getNumberOfObjects()) {

            if(myBoard.getTile(myRobot.getActualPosition()).getType()== TileType.END){

                boolean b = Play.getInstance().next();
                if(b){
                    start();
                    messageLabel.setText("Gratula, ügyi voltál! :) Tessék, a következő pálya!");
                } else{
                    messageLabel.setText("Gratula, ügyi voltál! :) Elfogytak a pályák");
                }

            } else{
                messageLabel.setText(messageLabel.getText() + "\nMár majdnem kész vagy, de a célban kell befejezned!");
            }
        } else {
            messageLabel.setText(messageLabel.getText() + " \nNem sikerült mindent összeszedni, nem teljesítetted a pályát. :(");
        }
    }

    /**
     * hibajelző függvény
     */
    public void erroring() {
        //TODO
        messageLabel.setText("hiba csúszott a rendszerbe");
    }

    /**
     * hibás input jelzése
     */
    public void invalidInputSignaling() {
        invalidInput();
    }

    /**
     * hibás input visszajelzése a felhasználónak
     */
    private void invalidInput() {
        messageLabel.setText("Valamit elgépeltél, próbáld újra!");
    }

    /**
     * hiba jelzés a felhasználó felé
     */
    private void somethingWentWrong() {
        messageLabel.setText("Valamit elrontottál, próbáld újra!");
        //TODO
    }
}
