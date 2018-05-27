package sample.models;
/**
    Koordinátákat megvalósító osztály
    A pályán való könnyebb tájékozódást segíti
    Benne x és y koordináta
 */
public class Coords {

    private int X;
    private int Y;

    /**
        Konstruktor
     */
    public Coords(int a, int b){
        X = a;
        Y = b;
    }

    /**
        X-et beállító setter
     */
    public void setX(int x) {
        X = x;
    }

    /**
        Y-t beállító setter
     */
    public void setY(int y) {
        Y = y;
    }

    /**
        getter x tagra
     */
    public int getX() {
        return X;
    }

    /**
        getter y tagra
     */
    public int getY() {
        return Y;
    }

    /**
     *   Jobb fv
     *   ellenőrzi a kapott pályán, hogy léphetünk e jobbra, ott van e még mező, nem érünk e le a pályáról
     *   @param b    a tábla, amin haladni szeretnénk
     *   @return  megmutatja, valid e  a mező
     */
    public boolean right(Board b){
        if(X + 1 < b.getWidth()){
            X++;
            return true;
        } else return false;
    }

    /**
     *   Bal fv
     *   ellenőrzi a kapott pályán, hogy léphetünk e balra, ott van e még mező, nem érünk e le a pályáról
     *   @param b    a tábla, amin haladni szeretnénk
     *   @return  megmutatja, valid e  a mező
     */
    public boolean left(Board b){
        if(X > 0){
            X--;
            return true;
        } else return  false;
    }

    /**
     *   Fel fv
     *   ellenőrzi a kapott pályán, hogy léphetünk e fel, ott van e még mező, nem érünk e le a pályáról
     *   @param b    a tábla, amin haladni szeretnénk
     *   @return  megmutatja, valid e  a mező
     */
    public boolean top(Board b){
        if(Y > 0){
            Y--;
            return  true;
        } else return false;
    }

    /**
     *   Le fv
     *   ellenőrzi a kapott pályán, hogy léphetünk e lefelé, ott van e még mező, nem érünk e le a pályáról
     *   @param b    a tábla, amin haladni szeretnénk
     *   @return  megmutatja, valid e  a mező
     */
    public boolean down(Board b){
        if( Y + 1 < b.getHeight()){
            Y++;
            return true;
        } else return false;
    }
}
