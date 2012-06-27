package minirpg;

public class Player {

    private String name;
    private int str;
    private int dex;
    private int end;
    private int wis;
    private int pointsLeft = 0;

    public Player() {
        this("Bob", 0, 0, 0, 0, 15);
    }
//SetPlayerInfo m = new SetPlayerInfo();
    public Player(String name, int str, int dex, int end, int wis, int pointsLeft) {
        setName(name);
        setStr(str);
        setDex(dex);
        setEnd(end);
        setWis(wis);
        setPointsLeft(pointsLeft);

    }
//GET and SET for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//GET and SET for str
    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

//GET and SET for dex
    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

//GET and SET for str
    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

//GET and SET for wis
    public int getWis() {
        return wis;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public int getPointsLeft() {
        return pointsLeft;
    }
//GET Set for pointsLeft
    public void setPointsLeft(int pointsLeft) {
        this.pointsLeft = pointsLeft;
    }
}
