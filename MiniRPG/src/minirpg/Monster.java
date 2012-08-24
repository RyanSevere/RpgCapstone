package minirpg;

import javax.swing.ImageIcon;

public class Monster {

    private String name;
    private int hp, row, column, damage, stunDuration, stunCount, movesLeft;
    private boolean isDead, isStunned, canMove, hasAttacked;
    private ImageIcon icon = new ImageIcon("Redx.png");

    public Monster() {
        this("Monster",null , 20, 1, 0,0, false, 0, 0, true,4,false);
    }
    public Monster(String name,ImageIcon icon, int hp,int damage, int row,int column, boolean isStunned, int stunDuration, int stunCount, boolean canMove, int movesLeft,boolean hasAttacked) {
        setName(name);
        setIcon(icon);
        setHp(hp);
        setDamage(damage);
        setRow(row);
        setColumn(column);
        setIsDead(false);
        setIsStunned(isStunned);
        setStunDuration(stunDuration);
        setStunCount(stunCount);
        setMovesLeft(movesLeft);
        setHasAttacked(hasAttacked);
    }
    
    public ImageIcon getIcon()
    {
        return icon;
    }
    public void setIcon(ImageIcon icon)
    {
        this.icon = icon;
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int colunm) {
        this.column = colunm;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean isIsDead() {
        return isDead;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }
    
    public int getDamage()
    {
        return damage;
    }
    
    public void setDamage(int damage)
    {
        this.damage = damage;
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
    
    public boolean getCanMove()
    {
        return canMove;
    }
    
    public void setCanMove(boolean canMove)
    {
        this.canMove = canMove;
    }
    public int getMovesLeft() {
        return movesLeft;
    }

    public void setMovesLeft(int movesLeft) {
        this.movesLeft = movesLeft;
    }
    public void setHasAttacked(boolean hasAttacked)
    {
        this.hasAttacked = hasAttacked;
    }
    
    public boolean getHasAttacked()
    {
        return hasAttacked;
    }
    
}