package minirpg;

public class Player {

    PlayerClassPanel PCP = new PlayerClassPanel();
    
    private String name;
    private int str;
    private int dex;
    private int end;
    private int wis;
    private int pointsLeft = 0;
    private String Class;
    private String Role;
    private int Lvl;
    private String Skill1;
    private String Skill2;
    private String Skill3;
    private String Skill4;

    public Player() {
        this("Steve", 0, 0, 0, 0, 15, "Tank", "Monk", "Stun", null, null, null, 1);
    }
//SetPlayerInfo m = new SetPlayerInfo();
    public Player(String name, int str, int dex, int end, int wis, 
            int pointsLeft, String Role, String Class, String Skill1,
            String Skill2, String Skill3, String Skill4, int Lvl) {
        setName(name);
        setStr(str);
        setDex(dex);
        setEnd(end);
        setWis(wis);
        setPointsLeft(pointsLeft);
        setRole(Role);
        setclass(Class);
        setSkill1(Skill1);
        setSkill2(Skill2);
        setSkill3(Skill3);
        setSkill4(Skill4);
        

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
//GET for pointsLeft
    public void setPointsLeft(int pointsLeft) {
        this.pointsLeft = pointsLeft;
    }
    
    //get for Class
    public String getclass()
    {
        return Class;
    }
    
    public void setclass (String Class)
    {
        this.Class = Class;
    }
    
    //get for role
    public String getRole()
    {
        return Role;
    }
    
    public void setRole (String Role)
    {
        this.Role = Role;
    }
    
    //getter setter for Skillz 1-4
    public String getSkill1()
    {
        return Skill1;
    }
    
    public void setSkill1(String Skill1)
    {
        this.Skill1 = Skill1;
    }
    
    public String getSkill2()
    {
        return Skill2;
    }
    
    public void setSkill2(String Skill2)
    {
        this.Skill2 = Skill2;
    }
    
    public String getSkill3()
    {
        return Skill3;
    }
    
    public void setSkill3(String Skill3)
    {
        this.Skill3 = Skill3;
    }
    
    public String getSkill4()
    {
        return Skill4;
    }
    
    public void setSkill4(String Skill4)
    {
        this.Skill4 = Skill4;
    }
    
    
    //getter and setter for lvl
    public int getLvl()
    {
        return Lvl;
    }
    
    public void setLvl(int Lvl)
    {
        this.Lvl = Lvl;
    }
    
}
