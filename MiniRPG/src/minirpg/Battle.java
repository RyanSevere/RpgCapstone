//created by Sean Forman
package minirpg;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import javax.swing.*;

public class Battle extends JFrame {

    Random rand = new Random();
    public static ArrayList<Monster> monsters = new ArrayList<Monster>();
    boolean p1MoveCheck = false;
    boolean p2Check = false;
    boolean p3Check = false;
    boolean p4Ccheck = false;
    boolean p1AttackCheck = false;
    int p1LastRow = 9;
    int p1LastCol = 3;
    int p1CurretRow;
    int p1CurretCol;
    int monsterIndex;
    int playerIndex = 0;
    JTable table = new JTable(10, 10);
    JButton none;//add buttons as needed
    JLabel lblClass,pClass,lblRole,role,lblStr,lblDex,lblEnd,lblwiz,str,dex,end,
            wiz,movesLeft,lblHp,hp,skills,name,icon,dash,lblSkill1,skill1,
            lblSkill2,skill2,lblSkill3,skill3,lblSkill4,skill4;
    JTextArea infoBox;
    String empty = "";
    //int rowInt = (int)table.getSelectedRow();
    //int colInt = (int)table.getSelectedColumn();
    //private JSplitPane splitPane;
    //SetPlayerInfo spi = new SetPlayerInfo();

    public Battle() {
        table.setRowHeight(50);
        table.setBorder(BorderFactory.createLineBorder(Color.black));
        monsters.add(new Monster("Orc", 1, 0, 3));
        monsters.add(new Monster("Troll", 1, 0, 7));
        monsters.add(new Monster("Troll", 1, 1, 0));
        monsters.add(new Monster("Orc", 1, 2, 8));
        monsters.add(new Monster("Ogre", 1, 2, 2));

        setMap();

        JPanel p = new JPanel();
        //JPanel p2 = new JPanel();
        //p2.setLayout(new GridBagLayout());
        Dimension minimumSize = new Dimension(800, 600);

        p.setMinimumSize(minimumSize);
        p.add(table);
//add tabs!!
        
        
        JTabbedPane p2 = new JTabbedPane();
        //p2.setLayout(new GridBagLayout());
        while (playerIndex < 4){
        JComponent panel = makeTextPanel("");
        p2.addTab(minirpg.MiniRPG.players.get(playerIndex).getName(),null, panel,
                "Does nothing");
        playerIndex++;
        }
        
        
        //tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        //above is how to setup a hot key to change players
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                true, p, p2);

        splitPane.setOneTouchExpandable(false);
        getContentPane().add(splitPane);

       // Event a = new Event();
//        moveP1.addActionListener(a);
//        attackP1.addActionListener(a);


        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                moveCheck();
                if (p1AttackCheck == true) {
                    getMonsterIndex();
                    attack();
                    p1AttackCheck = false;

                }
//                System.out.println("ROW:" + sr() + "," + "COLUMN:" + sc());
//                System.out.println(nc());
//                getMonsterIndex();
//                System.out.println("The monster index is" + monsterIndex);
//                System.out.println(monsters.get(0).getRow());
//                System.out.println(monsters.get(0).getCol());
            }
        });
    }

    //deals with player attack use later also uncomment event
    
    /*public class Event implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == moveP1) {
                p1MoveCheck = true;
            } else if (a.getSource() == attackP1) {
                p1AttackCheck = true;
            }
        }
    }*/

    public void moveCheck() {
        if (p1MoveCheck == true && nc() == null) {
            p1Move();
            p1MoveCheck = false;
        } else {
            clear();
            infoBox.append("you can not move to this space");
        }

    }

    public void attackCheck() {
        if (p1AttackCheck == true) {
            attack();
        }
    }

    public void p1Move() {
        int rowSelect = table.getSelectedRow();
        int colSelect = table.getSelectedColumn();
        Object p1 = MiniRPG.players.get(0).getName();
        table.setValueAt(p1, rowSelect, colSelect);
        table.setValueAt((Object) null, p1LastRow, p1LastCol);
        p1LastRow = rowSelect;
        p1LastCol = colSelect;
        p1CurretRow = (int) table.getSelectedRow();
        p1CurretCol = (int) table.getSelectedColumn();
//        System.out.println(p1CurretRow);
    }

    public void setMap() {
        //Sets Players
        table.setValueAt(MiniRPG.players.get(0).getName(), 9, 3);
        table.setValueAt(MiniRPG.players.get(1).getName(), 9, 4);
        table.setValueAt(MiniRPG.players.get(2).getName(), 9, 5);
        table.setValueAt(MiniRPG.players.get(3).getName(), 9, 6);
        //Sets Monsters
        table.setValueAt(monsters.get(0).getName(), 0, 3);
        table.setValueAt(monsters.get(1).getName(), 0, 7);
        table.setValueAt(monsters.get(2).getName(), 1, 0);
        table.setValueAt(monsters.get(3).getName(), 2, 8);
        table.setValueAt(monsters.get(4).getName(), 2, 2);
    }

    public void clear() {
        infoBox.setText("");
    }

    public Object nc() {
        Object nc = table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
        return nc;
    }

    public Object sr() {
        Object row = Integer.toString(table.getSelectedRow());
        return row;
    }

    public Object sc() {
        Object col = Integer.toString(table.getSelectedColumn());
        return col;
    }

    public void getMonsterIndex() {
        boolean mc = false;
        boolean rc = false;
        boolean cc = false;
        int i = 0;
        int rowInt = table.getSelectedRow();
        int colInt = table.getSelectedColumn();
        ListIterator<Monster> li = monsters.listIterator();
        while (li.hasNext() && mc == false) {
            Object meow = li.next();
            for (int x = 0; x < 9; x++) {
                if (monsters.get(i).getRow() == rowInt && rc == false) {
                    rc = true;
                }
                if (monsters.get(i).getCol() == colInt && cc == false) {
                    cc = true;
                }
                if (cc == true && rc == true) {
                    monsterIndex = i;
                    mc = true;
                }
            }
            i++;
        }
    }

    public void attack() {
        boolean row = false;
        boolean col = false;
        int mi = monsterIndex;
        int mcHP = monsters.get(mi).getHp();
        String mn = monsters.get(mi).getName();
        int mcr = monsters.get(mi).getRow();
        int mcc = monsters.get(mi).getCol();
        int pcr = p1CurretRow;
        int pcc = p1CurretCol;
        int rowInt = table.getSelectedRow();
        int colInt = table.getSelectedColumn();
//        System.out.println("m index" + mi);
//        System.out.println("m row "+mcr);
//        System.out.println("m col "+mcc);
//        System.out.println("p row "+pcr);
//        System.out.println("p col "+pcc);
//        System.out.println("row "+rowInt);
//        System.out.println("col "+ colInt);
        if (pcr == mcr + 1 && pcc == mcc || pcr == mcr - 1 && pcc == mcc) {
            int playerDamage = rand.nextInt(7);
            monsters.get(mi).setHp(mcHP -= playerDamage);
            infoBox.setText("");
            infoBox.append("You hit " + mn + " for " + playerDamage + " \n");
            infoBox.append(mn + " has" + mcHP + "HP Left \n");
            if (mcHP <= 0) {
                table.setValueAt(null, mcr, mcc);
                monsters.get(mi).setIsDead(true);
                infoBox.setText("");
                infoBox.append(mn + " has been killed ");
                checkMap();
            }
        }
        if (pcc == mcc + 1 && pcr == mcr || pcc == mcc - 1 && pcr == mcr) {
            int playerDamage = rand.nextInt(7);
            monsters.get(mi).setHp(mcHP -= playerDamage);
            infoBox.setText("");
            infoBox.append("You hit " + mn + " for " + playerDamage + " \n");
            infoBox.append(mn + " has" + mcHP + "HP Left \n");
            if (mcHP <= 0) {
                table.setValueAt(null, mcr, mcc);
                monsters.get(mi).setIsDead(true);
                infoBox.setText("");
                infoBox.append(mn + " has been killed ");;
                checkMap();
            }
        }
    }

    public void checkMap() {
        ListIterator<Monster> li = monsters.listIterator();
        int monsterskilled = 0;
        int i = -1;
        while (li.hasNext()) {
            i++;
            Object meow = li.next();
            if (monsters.get(i).isIsDead() == true) {
                monsterskilled++;
            }
        }
        if (monsterskilled == i + 1) {
            infoBox.setText("");
            infoBox.append("All Monsters have been defeated \n YOU WIN!");
            JOptionPane.showMessageDialog(rootPane, "SHOWS OVER!");
            this.dispose();
        }
    }

    public void damageEvent(String file, String moveName) {
  //Sets up varibles for damage      
        String isRanged;
        String range;
        String damage;
        String output;
        try{
  // Open the file that is the first 
  // command line parameter
            FileInputStream fstream = new FileInputStream(file);
  // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
  //Read File Line By Line
  while ((strLine = br.readLine()) != null)   {
  // Print the content on the console
          if(strLine.equals(moveName)){
              isRanged = br.readLine();
              range = br.readLine();
              damage = br.readLine();
              output = br.readLine();
          }
  }
  //Close the input stream
  in.close();
    }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
    }
    
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        //panel.add(filler);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        name = new JLabel(minirpg.MiniRPG.players.get(playerIndex).getName());
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        panel.add(name, c);
        
        icon = new JLabel("icon");
        c.gridx = 1;
        c.gridy = 2;
        panel.add(icon, c);
        
        lblClass = new JLabel("Class:");
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        panel.add(lblClass, c);
        
        pClass = new JLabel("Wizard");
        c.gridx = 2;
        c.gridy = 3;
        panel.add(pClass, c);
        
        lblRole = new JLabel("Role:");
        c.gridx = 1;
        c.gridy = 4;
        panel.add(lblRole, c);
        
        role = new JLabel("CatMage");
        c.gridx = 2;
        c.gridy = 4;
        panel.add(role, c);
        
        dash = new JLabel("--------------------STATS--------------------");
        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 5;
        panel.add(dash, c);
        
        lblStr = new JLabel("Strengh:");
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 6;
        panel.add(lblStr, c);
        
        str = new JLabel(Integer.toString(
                minirpg.MiniRPG.players.get(playerIndex).getStr()));
        //c.insets = new Insets(5, 5, 5, 5);
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 6;
        panel.add(str, c);
        
        lblDex = new JLabel("Dexterity:");
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 7;
        panel.add(lblDex, c);
        
        dex = new JLabel(Integer.toString(
                minirpg.MiniRPG.players.get(playerIndex).getDex()));
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 7;
        panel.add(dex, c);
        
        lblEnd = new JLabel("Endurance:");
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 8;
        panel.add(lblEnd, c);
        
        end = new JLabel(Integer.toString(
                minirpg.MiniRPG.players.get(playerIndex).getEnd()));
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 8;
        panel.add(end, c);
        
        lblDex = new JLabel("Wisdom:");
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 9;
        panel.add(lblDex, c);
        
        wiz = new JLabel(Integer.toString(
                minirpg.MiniRPG.players.get(playerIndex).getWis()));
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 9;
        panel.add(wiz, c);
        
        lblHp = new JLabel("HP");
        c.gridx = 1;
        c.gridy = 10;
        panel.add(lblHp, c);
        
        hp = new JLabel("27");
        c.gridx = 2;
        c.gridy = 10;
        panel.add(hp, c);
        
        dash = new JLabel("--------------------SKILLS--------------------");
        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 11;
        panel.add(dash, c);
        
        lblSkill1 = new JLabel("Skill 1:");
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 12;
        panel.add(lblSkill1, c);
        
        skill1 = new JLabel("Scrach");
        c.gridx = 2;
        c.gridy = 12;
        panel.add(skill1, c);
        
        lblSkill2 = new JLabel("Skill 2:");
        c.gridx = 1;
        c.gridy = 13;
        panel.add(lblSkill2, c);
        
        skill2 = new JLabel("Bite");
        c.gridx = 2;
        c.gridy = 13;
        panel.add(skill2, c);
        
        lblSkill3 = new JLabel("Skill 3:");
        c.gridx = 1;
        c.gridy = 14;
        panel.add(lblSkill3, c);
        
        skill3 = new JLabel("Meow");
        c.gridx = 2;
        c.gridy = 14;
        panel.add(skill3, c);
        
        lblSkill4 = new JLabel("Skill 4:");
        c.gridx = 1;
        c.gridy = 15;
        panel.add(lblSkill4, c);
        
        skill4 = new JLabel("Hair Ball");
        c.gridx = 2;
        c.gridy = 15;
        panel.add(skill4, c);
        
        
        return panel;
    }
}
