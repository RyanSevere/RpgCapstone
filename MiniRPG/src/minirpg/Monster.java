package minirpg;

import javax.swing.ImageIcon;

public class Monster {

    private String name;
    private int hp;
    private int row;
    private int col;
    private boolean isDead;
    private ImageIcon icon = new ImageIcon("Redx.png");

    public Monster() {
        this("Monster",null , 20,0,0);
    }
    public Monster(String name,ImageIcon icon, int hp,int row,int col) {
        setName(name);
        setIcon(icon);
        setHp(hp);
        setRow(row);
        setCol(col);
        setIsDead(false);
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

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
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
}