package minirpg;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    JTable table = new JTable(10, 10);
    JButton moveP1, moveP2, moveP3, moveP4,
            attackP1, attackP2, attackP3, attackP4;
    JLabel p1Name, p2Name, p3Name, p4Name, movesLeft,
            p1MovesLeft, p2MovesLeft, p3MovesLeft, p4MovesLeft;
    JTextArea infoBox;
    String empty = "";
    //int rowInt = (int)table.getSelectedRow();
    //int colInt = (int)table.getSelectedColumn();
    //private JSplitPane splitPane;
    //SetPlayerInfo spi = new SetPlayerInfo();

    public Battle() {
        JOptionPane.showMessageDialog(rootPane,
                  "This would be the alpha of the game I guess. All you can do \n"
                + "at this time is move/attack with player 1. Click on the move \n"
                + "button for player one then click the cell you would like to \n"
                + "move Player 1 to. Attack works in the same way but you have \n"
                + "to be standing next to the monster you want to attack. Once \n"
                + "all the monsters have been killed you get a message in the \n"
                + "green JTextArea telling you you win!");
        table.setRowHeight(50);
        table.setBorder(BorderFactory.createLineBorder(Color.black));

        monsters.add(new Monster("Orc", 1, 0, 3));
        monsters.add(new Monster("Troll", 1, 0, 7));
        monsters.add(new Monster("Troll", 1, 1, 0));
        monsters.add(new Monster("Orc", 1, 2, 8));
        monsters.add(new Monster("Ogre", 1, 2, 2));

        setMap();

        JPanel p = new JPanel();
        JPanel p2 = new JPanel();
        p2.setLayout(new GridBagLayout());
        Dimension minimumSize = new Dimension(800, 400);

        p.setMinimumSize(minimumSize);
        p.add(table);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        infoBox = new JTextArea(5, 15);
        infoBox.setEditable(false);
        infoBox.setLineWrap(true);
        infoBox.setWrapStyleWord(true);
        infoBox.setBackground(Color.green);
        c.insets = new Insets(0, 5, 20, 5);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        p2.add(infoBox, c);

//      Player 1 stuff
        p1Name = new JLabel(minirpg.MiniRPG.players.get(0).getName());
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        p2.add(p1Name, c);

        movesLeft = new JLabel("Moves left:");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        p2.add(movesLeft, c);

        p1MovesLeft = new JLabel("3");
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        p2.add(p1MovesLeft, c);

        moveP1 = new JButton("Move");
        c.gridx = 0;
        c.gridy = 3;
        p2.add(moveP1, c);

        attackP1 = new JButton("Attack");
        c.gridx = 1;
        c.gridy = 3;
        p2.add(attackP1, c);

        //Player 2 stuff
        p2Name = new JLabel(minirpg.MiniRPG.players.get(1).getName());
        c.insets = new Insets(30, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        p2.add(p2Name, c);

        movesLeft = new JLabel("Moves left:");
        c.insets = new Insets(2, 2, 2, 2);
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        p2.add(movesLeft, c);

        p2MovesLeft = new JLabel("3");
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 1;
        p2.add(p2MovesLeft, c);

        moveP2 = new JButton("Move");
        c.gridx = 0;
        c.gridy = 6;
        p2.add(moveP2, c);

        attackP2 = new JButton("Attack");
        c.gridx = 1;
        c.gridy = 6;
        p2.add(attackP2, c);

        //Player 3 stuff
        p3Name = new JLabel(minirpg.MiniRPG.players.get(2).getName());
        c.insets = new Insets(30, 2, 2, 2);
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 2;
        p2.add(p3Name, c);

        movesLeft = new JLabel("Moves left:");
        c.insets = new Insets(2, 2, 2, 2);
        c.gridx = 0;
        c.gridy = 8;
        c.gridwidth = 1;
        p2.add(movesLeft, c);

        p3MovesLeft = new JLabel("3");
        c.gridx = 1;
        c.gridy = 8;
        c.gridwidth = 1;
        p2.add(p3MovesLeft, c);

        moveP3 = new JButton("Move");
        c.gridx = 0;
        c.gridy = 9;
        p2.add(moveP3, c);

        attackP3 = new JButton("Attack");
        c.gridx = 1;
        c.gridy = 9;
        p2.add(attackP3, c);

        //Player 4 stuff
        p4Name = new JLabel(minirpg.MiniRPG.players.get(3).getName());
        c.insets = new Insets(30, 2, 2, 2);
        c.gridx = 0;
        c.gridy = 10;
        c.gridwidth = 2;
        p2.add(p4Name, c);

        movesLeft = new JLabel("Moves left:");
        c.insets = new Insets(2, 2, 2, 2);
        c.gridx = 0;
        c.gridy = 11;
        c.gridwidth = 1;
        p2.add(movesLeft, c);

        p4MovesLeft = new JLabel("3");
        c.gridx = 1;
        c.gridy = 11;
        c.gridwidth = 1;
        p2.add(p4MovesLeft, c);

        moveP4 = new JButton("Move");
        c.gridx = 0;
        c.gridy = 12;
        p2.add(moveP4, c);

        attackP4 = new JButton("Attack");
        c.gridx = 1;
        c.gridy = 12;
        p2.add(attackP4, c);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                true, p, p2);

        splitPane.setOneTouchExpandable(false);
        getContentPane().add(splitPane);

        Event a = new Event();
        moveP1.addActionListener(a);
        attackP1.addActionListener(a);


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

    public class Event implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == moveP1) {
                p1MoveCheck = true;
            } else if (a.getSource() == attackP1) {
                p1AttackCheck = true;
            }
        }
    }

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
                monsterskilled ++;
            }  
        }
        if (monsterskilled == i+1) {
            infoBox.setText("");
            infoBox.append("All Monsters have been defeated \n YOU WIN!");
            JOptionPane.showMessageDialog(rootPane, "SHOWS OVER!");
            this.dispose();
        }
    }
}
