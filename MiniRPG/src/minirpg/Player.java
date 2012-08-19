package minirpg;

import javax.swing.ImageIcon;

public class Player {

    PlayerClassPanel PCP = new PlayerClassPanel();
    
    private String name, Class, Role, Skill1, Skill2, Skill3, Skill4, SkillText;
    private int basicDamage, maxDamage, maxHp, hp, row, column, str, dex, end, wis, Lvl, moves, pointsLeft = 0, stunDuration, stunCount;
    private double Defense, MaxDefense;
    private ImageIcon icon;
    private boolean hasAttacked, isStunned, Skill1Used, Skill2Used, Skill3Used, Skill4Used;

    public Player() {
        this("Steve", 0, 0, 0, 0, 16, "Tank", "Monk", "Stun", null, null, null, 
                1,0,0, null, 20, 20, 10, 10, 0.0, 0.0, 4, false, false, 0, 0, false, false, false, false);
    }
//SetPlayerInfo m = new SetPlayerInfo();
    public Player(String name, int str, int dex, int end, int wis, 
            int pointsLeft, String Role, String Class, String Skill1,
            String Skill2, String Skill3, String Skill4, int Lvl,int row,int column, 
            ImageIcon icon, int maxHp, int hp, int basicDamage, int maxDamage, 
            double Defense, double MaxDefense, int moves, boolean hasAttacked, 
            boolean isStunned, int StunDuration, int stunCount, 
            boolean Skill1Used, boolean Skill2Used, boolean Skill3Used, boolean Skill4Used) 
    {
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
        setRow(row);
        setColumn(column);
        setIcon(icon);
        setMaxHp(maxHp);
        setHp(hp);
        setDamage(basicDamage);
        setMaxDamage(maxDamage);
        setDefense(Defense);
        setMaxDefense(MaxDefense);
        setMoves(moves);
        setHasAttacked(hasAttacked);
        setIsStunned(isStunned);
        setSkill1Used(Skill1Used);
        setSkill2Used(Skill2Used);
        setSkill3Used(Skill3Used);
        setSkill4Used(Skill4Used);
        
        

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
    public int getRow()
    {
        return row;
    }
    public void setRow(int row)
    {
        this.row = row;
    }
    public int getColumn()
    {
        return column;
    }
    public void setColumn(int column)
    {
        this.column = column;
    }
    
    public ImageIcon getIcon()
    {
        return icon;
    }
    
    public void setIcon(ImageIcon icon)
    {
        this.icon = icon;
    }
    public int getHp()
    {
        return hp;
    }
    
    public void setHp(int hp)
    {
        this.hp = hp;
    }
    
    public int getDamage()
    {
        return basicDamage;
    }
    
    public void setDamage(int basicDamage)
    {
        this.basicDamage = basicDamage;
    }
    
    public boolean getHasAttacked()
    {
        return hasAttacked;
    }
    
    public void setHasAttacked(boolean hasAttacked)
    {
        this.hasAttacked = hasAttacked;
    }
    
    public boolean getIsStunned()
    {
        return isStunned;
    }
    
    public void setIsStunned(boolean isStunned)
    {
        this.isStunned = isStunned;
    }
    
    public int getStunDuration()
    {
        return stunDuration;
    }
    
    public void setStunDuration(int stunDuration)
    {
        this.stunDuration = stunDuration;
    }
    
    public int getStunCount()
    {
        return stunCount;
    }
    
    public void setStunCount(int stunCount)
    {
        this.stunCount = stunCount;
    }
    
    public int getMaxHp()
    {
        return maxHp;
    }
    
    public void setMaxHp(int maxHp)
    {
        this.maxHp = maxHp;
    }
    
    public double getDefense()
    {
        return Defense;
    }
    
    public void setDefense(double Defense)
    {
        this.Defense = Defense;
    }
    
    public double getMaxDefense()
    {
        return MaxDefense;
    }
    
    public void setMaxDefense(double MaxDefense)
    {
        this.MaxDefense = MaxDefense;
    }
    
    public int getMaxDamage()
    {
        return maxDamage;
    }
    
    public void setMaxDamage(int maxDamage)
    {
        this.maxDamage = maxDamage;
    }
    
    public int getMoves()
    {
        return moves;
    }
    
    public void setMoves(int moves)
    {
        this.moves = moves;
    }
    
    public boolean getSkill1Used()
    {
        return Skill1Used;
    }
    
    public void setSkill1Used(boolean Skill1Used)
    {
        this.Skill1Used = Skill1Used;
    }
    
    public boolean getSkill2Used()
    {
        return Skill2Used;
    }
    
    public void setSkill2Used(boolean Skill2Used)
    {
        this.Skill2Used = Skill2Used;
    }
    
    public boolean getSkill3Used()
    {
        return Skill3Used;
    }
    
    public void setSkill3Used(boolean Skill3Used)
    {
        this.Skill3Used = Skill3Used;
    }
    
    public boolean getSkill4Used()
    {
        return Skill4Used;
    }
    
    public void setSkill4Used(boolean Skill4Used)
    {
        this.Skill4Used = Skill4Used;
    }
        
}
