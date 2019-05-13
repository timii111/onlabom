package sample;

import sample.models.Board;
import sample.models.Robot;

import java.io.*;

/**
 * játékot reprezentáló osztály
 * singleton, egy példányban létezik, mainből példányosodik
 * felel a pályák betöltéséért és elindításáért
 */
public class Play {
    /** aktuális játék száma */
    private int gameNumber = 1;
    /** maximális pályák száma */
    private int maxGameNumber;
    /** aktuális pálya objektum */
    private Board actualBoard;

    /** bufferedreader, fájlolvasáshoz */
    private BufferedReader br;
    /** filenév tárolásához használt string */
    private String fileName;
    /** statikus játék objektum, singleton minta */
    private static Play ourInstance;
    /** aktuális robot a játékban */
    private Robot myRobot;

    /**
     * játékpéldányt visszadó metódus
     * létrehozza, ha nincs, ha pedig van, azt adja vissza
     * @return játék objektum
     */
    public static Play getInstance() {
        if(ourInstance==null) {
            ourInstance = new Play();
        }
        return ourInstance;
    }

    public int getMaxGameNumber(){return maxGameNumber;}
    public void setMaxGameNumber(int max){ maxGameNumber = max;}

    public Robot getMyRobot(){
        return myRobot;
    }
    public Board getMyBoard(){
        return actualBoard;
    }

    /**
     * konstruktor
     * betölti a következő pályát
     * meghatározza a maximális pályaszámot
     */
    private Play() {
        loadNextStage();
        File folder = new File("./src/sample/boards");
        File[] listOfFiles = folder.listFiles();

        maxGameNumber = listOfFiles.length;
    }

    /**
     * aktuális játék elkezdéséhez, a pálya kirajzolásához használt fv
     * elindítja a következő pályát
     * megmutatja, milyen mezőkből áll össze a pálya
     * @return visszaadja a játékmezők beolvasásához szükséges elérési utakat
     */
    public String[][] start(){
        loadNextStage();
        return actualBoard.draw();
    }

    /**
     * a kapott string alapján építi fel a pályát és kirajzolja
     * saját definiált pályák esetén használandó
     */
    public String[][] draw(String str){
        loadNewBoard(str);
        return actualBoard.draw();
    }

    /**
     * pálya betöltéséhez használt fv
     * beolvassa az aktuális pálya fájlját, amiben a pályaleírás található
     * létrehozza a robotot, aminek átadja a maradék feldolgozandó infot
     * beállítja az aktuális pályát
     */
    public void loadNextStage(){
        fileName = "sample/boards/Board_" + gameNumber + ".txt";
        try{
            InputStream fr = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            br = new BufferedReader(new InputStreamReader(fr));

            myRobot = new Robot(br);
            actualBoard = myRobot.getMyBoard();

            br.close();
            fr.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * beolvassa stringból a pálya adatait
     * létrehozza a robotot és a pályát
     */
    public void loadNewBoard(String str){
        Reader inputString = new StringReader(str);
        BufferedReader reader = new BufferedReader(inputString);

        myRobot = new Robot(reader);
        actualBoard = myRobot.getMyBoard();
    }

    /**
     * következő pálya betöltését szolgálja, miután sikeresen végeztünk az előzővel
     * ha van még pálya, betölti és növeli az aktuális játék számát
     * ha nincs, visszatér
     * @return megmutatja, van e még új pálya
     */
    public boolean next(){
        if(gameNumber==maxGameNumber) return false;
        else{
            gameNumber++;
            loadNextStage();
            return true;
        }
    }
}
