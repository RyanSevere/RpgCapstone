//Created by Sean Forman and Ryan Severe

package minirpg;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Battle extends JFrame {

    public int playerDistance[] = new int[4];
    public int playerToAttack;
    public int lowest;
    public int highest;
    public boolean mmc;
    public boolean mca;
    public int attackingMonsterIndex;
    static SkillAttacks SA = new SkillAttacks();
    IconSelector IS = new IconSelector();
    ImageIcon Orc = IS.getOrc(), Ogre = IS.getOgre(), Goblin = IS.getGoblin();
    Random rand = new Random();
    public static ArrayList<Monster> monsters = new ArrayList<Monster>();
    boolean moveCheck = false, isStunned, hasRun = false;
    int monsterIndex, monsterHP, setupPlayerIndex = 0, stunDuration, stunCount;
    static int selectedPlayerIndex = 0, selectedMonsterIndex = 0, SelectedPlayer, PlayerSelf, range;
    static String Skill;
    public JTable table = new JTable(11, 11);
    static boolean isPlayer, isMonster, inMeleeRange, inRange, isRanged;
    JButton skill1, skill2, skill3, skill4, endPhase;//add buttons as needed
    JLabel lblClass, pClass, lblRole, role, lblStr, lblDex, lblEnd, lblwiz, str, dex, end,
            wiz, lblMoves, movesLeft, lblHp, hp, skills, name, icon, dash, lblSkill1,
            lblSkill2, lblSkill3, lblSkill4, health, phaseLbl, phase, roundLbl, round;
    JTextArea infoBox;
    String empty = "";
    Battle.Event e = new Battle.Event();
    final TextPane[] textPanes = new TextPane[4];
    public JTabbedPane characterInfoPane;

    public Battle() {
        infoBox = new JTextArea(6, 72);
        infoBox.setEditable(false);
        //table.setShowGrid(false);
        table.setSelectionBackground(Color.white);
        table.setRowHeight(50);
        table.setBorder(BorderFactory.createLineBorder(Color.black));

        monsters.add(new Monster("Orc 1", Orc, 30, 3, 0, 3, false, 0, 0, true, 4, false));
        monsters.add(new Monster("Goblin 1", Goblin, 20, 2, 0, 7, false, 0, 0, true, 4, false));
        monsters.add(new Monster("Goblin 2", Goblin, 20, 2, 1, 0, false, 0, 0, true, 4, false));
        monsters.add(new Monster("Orc 2", Orc, 30, 3, 2, 8, false, 0, 0, true, 4, false));
        monsters.add(new Monster("Ogre", Ogre, 40, 5, 2, 2, false, 0, 0, true, 4, false));


        setMap();

        JPanel battleGridPane = new JPanel();
        Dimension minimumSize = new Dimension(800, 100);
        battleGridPane.setMinimumSize(minimumSize);
        battleGridPane.add(table);


        final JTabbedPane characterInfoPane = new JTabbedPane();

        
        while (setupPlayerIndex < 4) {
            textPanes[setupPlayerIndex] = new TextPane();
            characterInfoPane.addTab(minirpg.MiniRPG.players.get(setupPlayerIndex).getName(), null, textPanes[setupPlayerIndex],
                    "");
            setupPlayerIndex++;
        }

        JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                true, battleGridPane, characterInfoPane);
        //<editor-fold defaultstate="Collapsed" desc="Round Info Pane GUI">
        JPanel roundInfo = new JPanel();
        //Dimension m = new Dimension(200, 111);
        //roundInfo.setMinimumSize(m);
        roundInfo.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //top title       
        phaseLbl = new JLabel("Phase: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1; //centering title
        roundInfo.add(phaseLbl, c);

        phase = new JLabel("Player Phase");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        //c.gridwidth = 1; //centering title
        roundInfo.add(phase, c);

        roundLbl = new JLabel("Round: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        //c.gridwidth = 3; //centering title
        roundInfo.add(roundLbl, c);

        round = new JLabel("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        //c.gridwidth = 1; //centering title
        roundInfo.add(round, c);

        endPhase = new JButton("End Phase");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1; //centering title
        roundInfo.add(endPhase, c);

        endPhase.addActionListener(e);

        //</editor-fold>
        JScrollPane battleTextPane = new JScrollPane(infoBox);
        Dimension battleTextPannelSize = new Dimension(800, 500);
        battleGridPane.setMinimumSize(battleTextPannelSize);
        battleTextPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JSplitPane splitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, battleTextPane, roundInfo);

        JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                true, splitPane1, splitPane3);
        splitPane1.setDividerSize(1);
        splitPane2.setDividerSize(1);
        splitPane3.setDividerSize(1);
        
        getContentPane().add(splitPane2);

        table.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent k) {
                int keyCode = k.getKeyCode();
                if (keyCode == KeyEvent.VK_W) {
                    findPlayer();
                    wMoveCheck(selectedPlayerIndex);
                    if (moveCheck == true) {
                        int x = selectedPlayerIndex;
                        table.setValueAt(
                                null,
                                MiniRPG.players.get(x).getRow(),
                                MiniRPG.players.get(x).getColumn());
                        MiniRPG.players.get(x).setRow(
                                MiniRPG.players.get(x).getRow() - 1);
                        table.setValueAt(
                                MiniRPG.players.get(x).getName(),
                                MiniRPG.players.get(x).getRow(),
                                MiniRPG.players.get(x).getColumn());
                        moveCheck = false;
                        MiniRPG.players.get(x).setMoves(
                                MiniRPG.players.get(x).getMoves() - 1);
                        textPanes[x].setMovesLeft(MiniRPG.players.get(x).getMoves());
                        //System.out.println("ROW:" + MiniRPG.players.get(x).getRow() + "," + "COLUMN:" + MiniRPG.players.get(x).getColumn());
                    }
                    k.consume();
                } else if (keyCode == KeyEvent.VK_S) {
                    findPlayer();
                    sMoveCheck(selectedPlayerIndex);
                    if (moveCheck == true) {
                        int x = selectedPlayerIndex;
                        table.setValueAt(
                                null,
                                MiniRPG.players.get(x).getRow(),
                                MiniRPG.players.get(x).getColumn());
                        MiniRPG.players.get(x).setRow(
                                MiniRPG.players.get(x).getRow() + 1);
                        table.setValueAt(
                                MiniRPG.players.get(x).getName(),
                                MiniRPG.players.get(x).getRow(),
                                MiniRPG.players.get(x).getColumn());
                        moveCheck = false;
                        MiniRPG.players.get(x).setMoves(
                                MiniRPG.players.get(x).getMoves() - 1);
                        textPanes[x].setMovesLeft(MiniRPG.players.get(x).getMoves());
                        //System.out.println("ROW:" + MiniRPG.players.get(x).getRow() + "," + "COLUMN:" + MiniRPG.players.get(x).getColumn());
                    }
                    k.consume();
                } else if (keyCode == KeyEvent.VK_A) {
                    findPlayer();
                    aMoveCheck(selectedPlayerIndex);
                    if (moveCheck == true) {
                        int x = selectedPlayerIndex;
                        table.setValueAt(
                                null,
                                MiniRPG.players.get(x).getRow(),
                                MiniRPG.players.get(x).getColumn());
                        MiniRPG.players.get(x).setColumn(
                                MiniRPG.players.get(x).getColumn() - 1);
                        table.setValueAt(
                                MiniRPG.players.get(x).getName(),
                                MiniRPG.players.get(x).getRow(),
                                MiniRPG.players.get(x).getColumn());
                        moveCheck = false;
                        MiniRPG.players.get(x).setMoves(
                                MiniRPG.players.get(x).getMoves() - 1);
                        textPanes[x].setMovesLeft(MiniRPG.players.get(x).getMoves());
                        //System.out.println("ROW:" + MiniRPG.players.get(x).getRow() + "," + "COLUMN:" + MiniRPG.players.get(x).getColumn());
                    }
                    k.consume();
                } else if (keyCode == KeyEvent.VK_D) {
                    findPlayer();
                    dMoveCheck(selectedPlayerIndex);
                    if (moveCheck == true) {
                        int x = selectedPlayerIndex;
                        table.setValueAt(
                                null,
                                MiniRPG.players.get(x).getRow(),
                                MiniRPG.players.get(x).getColumn());
                        MiniRPG.players.get(x).setColumn(
                                MiniRPG.players.get(x).getColumn() + 1);
                        table.setValueAt(
                                MiniRPG.players.get(x).getName(),
                                MiniRPG.players.get(x).getRow(),
                                MiniRPG.players.get(x).getColumn());
                        moveCheck = false;
                        MiniRPG.players.get(x).setMoves(
                                MiniRPG.players.get(x).getMoves() - 1);
                        textPanes[x].setMovesLeft(MiniRPG.players.get(x).getMoves());
                        //System.out.println("ROW:" + MiniRPG.players.get(x).getRow() + "," + "COLUMN:" + MiniRPG.players.get(x).getColumn());
                    }
                    k.consume();
                } else if (keyCode == KeyEvent.VK_SPACE) {
                    if (MiniRPG.players.get(selectedPlayerIndex).getHasAttacked() == false) {
                        if (selectedMonsterIndex == -1) {
                            //System.out.println("no monster selected!!");
                            infoBox.append("\n" + "No monster selected");
                        } else if (MiniRPG.players.get(selectedPlayerIndex).getColumn() - 1
                                == monsters.get(selectedMonsterIndex).getColumn()
                                && MiniRPG.players.get(selectedPlayerIndex).getRow()
                                == monsters.get(selectedMonsterIndex).getRow()) {
                            damageEvent();
                            MiniRPG.players.get(selectedPlayerIndex).setHasAttacked(true);
                            CheckIfAlive();
                            //System.out.println("col hit left!.....on " + monsters.get(selectedMonsterIndex).getName());

                        } else if (MiniRPG.players.get(selectedPlayerIndex).getRow() + 1
                                == monsters.get(selectedMonsterIndex).getRow()
                                && MiniRPG.players.get(selectedPlayerIndex).getColumn()
                                == monsters.get(selectedMonsterIndex).getColumn()) {
                            damageEvent();
                            MiniRPG.players.get(selectedPlayerIndex).setHasAttacked(true);
                            CheckIfAlive();
                            //System.out.println("row hit down!.....on " + monsters.get(selectedMonsterIndex).getName());
                        } else if (MiniRPG.players.get(selectedPlayerIndex).getRow() - 1
                                == monsters.get(selectedMonsterIndex).getRow()
                                && MiniRPG.players.get(selectedPlayerIndex).getColumn()
                                == monsters.get(selectedMonsterIndex).getColumn()) {
                            damageEvent();
                            MiniRPG.players.get(selectedPlayerIndex).setHasAttacked(true);
                            CheckIfAlive();
                            //System.out.println("row hit up!.....on " + monsters.get(selectedMonsterIndex).getName());
                        } else if (MiniRPG.players.get(selectedPlayerIndex).getColumn() + 1
                                == monsters.get(selectedMonsterIndex).getColumn()
                                && MiniRPG.players.get(selectedPlayerIndex).getRow()
                                == monsters.get(selectedMonsterIndex).getRow()) {
                            damageEvent();
                            MiniRPG.players.get(selectedPlayerIndex).setHasAttacked(true);
                            CheckIfAlive();
                            //System.out.println("col hit right!.....on " + monsters.get(selectedMonsterIndex).getName());
                        } else {
                            //System.out.println("dat monster bez tooooo far away!!");
                            infoBox.append("\n" + "Monster to far away");
                        }
                        k.consume();
                    } else {
                        infoBox.append("\n" + "You have already attacked this round.");
                    }
                }
            }
        });
        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                //System.out.println("Row: " + table.getSelectedRow() + "   Col: " + table.getSelectedColumn() + "" + table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
                int x = 0;
                boolean selectedPlayerColumn = false;
                boolean selectedPlayerRow = false;
                boolean selectedMonsterColumn = false;
                boolean selectedMonsterRow = false;
                boolean playerCheck = false;
                boolean monsterCheck = false;
                isPlayer = false;
                isMonster = false;
                while (x <= 3) {
                    if (MiniRPG.players.get(x).getColumn() == table.getSelectedColumn()) {
                        selectedPlayerColumn = true;
                    }
                    if (MiniRPG.players.get(x).getRow() == table.getSelectedRow()) {
                        selectedPlayerRow = true;
                    }
                    if (selectedPlayerRow == true && selectedPlayerColumn == true) {
                        playerCheck = true;
                    }
                    if (playerCheck == true) {
                        //System.out.println("Player selected " + MiniRPG.players.get(x).getName());
                        SelectedPlayer = x;
                        //System.out.println(SelectedPlayer);
                        isPlayer = true;
                        playerCheck = false;
                        //characterInfoPane.setSelectedIndex(x);
                        break;
                    }
                    x++;
                }
                x = 0;
                while (x <= 4) {
                    if (monsters.get(x).getColumn() == table.getSelectedColumn()) {
                        selectedMonsterColumn = true;
                    }
                    if (monsters.get(x).getRow() == table.getSelectedRow()) {
                        selectedMonsterRow = true;
                    }
                    if (selectedMonsterRow == true && selectedMonsterColumn == true) {
                        monsterCheck = true;
                    }
                    if (monsterCheck == true) {
                        isMonster = true;
                        selectedMonsterRow = false;
                        selectedMonsterColumn = false;
                        monsterCheck = false;
                        selectedMonsterIndex = x;
                        //System.out.println("is " + monsters.get(x).getName() + " the monster you were looking for?");
                        //System.out.println(selectedMonsterIndex);
                        break;
                    } else {
                        selectedMonsterIndex = -1;
                    }
                    x++;
                    selectedMonsterRow = false;
                    selectedMonsterColumn = false;
                    monsterCheck = false;

                }
                x = 0;
            }
        });

    }

    public void setMap() {
        //Sets Players
        MiniRPG.players.get(0).setColumn(3);
        MiniRPG.players.get(1).setColumn(4);
        MiniRPG.players.get(2).setColumn(5);
        MiniRPG.players.get(3).setColumn(6);

        MiniRPG.players.get(0).setRow(10);
        MiniRPG.players.get(1).setRow(10);
        MiniRPG.players.get(2).setRow(10);
        MiniRPG.players.get(3).setRow(10);

        table.setValueAt(MiniRPG.players.get(0).getName(), 10, 3);
        table.setValueAt(MiniRPG.players.get(1).getName(), 10, 4);
        table.setValueAt(MiniRPG.players.get(2).getName(), 10, 5);
        table.setValueAt(MiniRPG.players.get(3).getName(), 10, 6);

        //Sets Monsters
        monsters.get(0).setColumn(2);
        monsters.get(1).setColumn(4);
        monsters.get(2).setColumn(6);
        monsters.get(3).setColumn(8);
        monsters.get(4).setColumn(9);

        monsters.get(0).setRow(0);
        monsters.get(1).setRow(0);
        monsters.get(2).setRow(1);
        monsters.get(3).setRow(2);
        monsters.get(3).setRow(2);

        table.setValueAt(monsters.get(0).getName(), 0, 2);
        table.setValueAt(monsters.get(1).getName(), 0, 4);
        table.setValueAt(monsters.get(2).getName(), 1, 6);
        table.setValueAt(monsters.get(3).getName(), 2, 8);
        table.setValueAt(monsters.get(4).getName(), 2, 9);
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

    public void checkMap() {
        ListIterator<Monster> li = monsters.listIterator();
        int monsterskilled = 0;
        int i = -1;
        while (li.hasNext()) {
            i++;
            Object meow = li.next();
            if (monsters.get(i).getIsDead() == true) {
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

    public void damageEvent() {
        //Sets up varibles for damage      
        int damage = MiniRPG.players.get(selectedPlayerIndex).getDamage();
        monsterHP = monsters.get(selectedMonsterIndex).getHp() - damage;
        monsters.get(selectedMonsterIndex).setHp(monsterHP);
        String DamageReport = monsters.get(selectedMonsterIndex).getName() + " takes " + damage + " damage.\n"
                + monsters.get(selectedMonsterIndex).getName() + " is down to " + monsterHP + " Hp";
        infoBox.append("\n" + DamageReport);
    }

    public void CheckIfAlive() {
        if(selectedMonsterIndex != -1)
        {
            if (monsters.get(selectedMonsterIndex).getHp() <= 0) {
                monsters.get(selectedMonsterIndex).setIsDead(true);
                String Kill = monsters.get(selectedMonsterIndex).getName() + "Has Died";
                infoBox.append("\n" + Kill);
                table.setValueAt(null, monsters.get(selectedMonsterIndex).getRow(), monsters.get(selectedMonsterIndex).getColumn());
            }
        }
        
    }

    private void wMoveCheck(int x) {
        if (MiniRPG.players.get(x).getMoves() > 0) {
            if (MiniRPG.players.get(x).getRow() - 1 >= 0) {
                if (table.getValueAt(
                        MiniRPG.players.get(x).getRow() - 1,
                        MiniRPG.players.get(x).getColumn()) == null) {
                    moveCheck = true;
                }
            } else {
                //System.out.println("not so legal move");
                infoBox.append("\n" + "There is a wall that way");
            }
        } else {
            infoBox.append("\n" + "No Moves Left");
        }

    }

    private void sMoveCheck(int x) {
        if (MiniRPG.players.get(x).getMoves() > 0) {
            if (MiniRPG.players.get(x).getRow() + 1 <= table.getRowCount() - 1) {
                if (table.getValueAt(
                        MiniRPG.players.get(x).getRow() + 1,
                        MiniRPG.players.get(x).getColumn()) == null) {
                    moveCheck = true;
                }
            } else {
                //System.out.println("not so legal move");
                infoBox.append("\n" + "There is a wall that way");
            }
        } else {
            infoBox.append("\n" + "No Moves Left");
        }
    }

    private void aMoveCheck(int x) {
        if (MiniRPG.players.get(x).getMoves() > 0) {
            if (MiniRPG.players.get(x).getColumn() - 1 >= 0) {
                if (table.getValueAt(
                        MiniRPG.players.get(x).getRow(),
                        MiniRPG.players.get(x).getColumn() - 1) == null) {
                    moveCheck = true;
                }
            } else {
                //System.out.println("not so legal move");
                infoBox.append("\n" + "There is a wall that way");
            }
        } else {
            infoBox.append("\n" + "No Moves Left");
        }
    }

    private void dMoveCheck(int x) {
        if (MiniRPG.players.get(x).getMoves() > 0) {
            if (MiniRPG.players.get(x).getColumn() + 1 <= table.getRowCount() - 1) {
                if (table.getValueAt(
                        MiniRPG.players.get(x).getRow(),
                        MiniRPG.players.get(x).getColumn() + 1) == null) {
                    moveCheck = true;
                }
            } else {
                //System.out.println("not so legal move");
                infoBox.append("\n" + "There is a wall that way");
            }
        } else {
            infoBox.append("\n" + "No Moves Left");
        }
    }

    private void findPlayer() {
        int x = 0;
        boolean selectedPlayerColumn = false;
        boolean selectedPlayerRow = false;
        boolean meow = false;
        while (x <= 3) {
            if (MiniRPG.players.get(x).getColumn() == table.getSelectedColumn()) {
                selectedPlayerColumn = true;
            }
            if (MiniRPG.players.get(x).getRow() == table.getSelectedRow()) {
                selectedPlayerRow = true;
            }
            if (selectedPlayerRow == true && selectedPlayerColumn == true) {
                meow = true;
            }
            if (meow == true) {
                selectedPlayerIndex = x;
                table.clearSelection();
                break;
            }
            x++;
        }
    }

    public class Event implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int counter = 0;
            if (e.getSource().equals(endPhase)) //end of player phase button
            {
                    if (monsters.get(counter).getIsStunned() == true) // determins if a monster is stunned
                    {
                        if (monsters.get(counter).getStunCount() == monsters.get(counter).getStunDuration()) //if a monster is stunned determines if it has met the stun duration
                        {
                            monsters.get(counter).setIsStunned(false); // if duration has been met removes stun
                        } 
                        else //if stun duration hasnt been met increases stun counter
                        {
                            monsters.get(counter).setStunCount(monsters.get(counter).getStunCount() + 1);

                        }
                    } 
                    else 
                    {
                        resetMonsterStuff();
                    }
                    if (monsters.get(counter).getIsDead() == true)
                    {
                        table.setValueAt(null, monsters.get(counter).getRow(), monsters.get(counter).getColumn());
                    }
                    
                findPlayerToAttack();
                table.repaint();
                table.updateUI();
                
                
                while (counter <= MiniRPG.players.size() - 1) //loops through all players
                {
                    if (MiniRPG.players.get(counter).getIsStunned() == true) //determines if a player is stunned
                    {
                        if (MiniRPG.players.get(counter).getStunCount() == MiniRPG.players.get(counter).getStunDuration()) //if a player id stunned determines how long the stun lasts and if they have reached the end of the stun duration
                        {
                            MiniRPG.players.get(counter).setIsStunned(false);
                            MiniRPG.players.get(counter).setMoves(4);
                            textPanes[counter].setMovesLeft(MiniRPG.players.get(counter).getMoves());
                        } else //if player has remaining stun rounds sets movement points to 0 and increases stun counter
                        {
                            MiniRPG.players.get(counter).setMoves(0);
                            MiniRPG.players.get(counter).setStunCount(MiniRPG.players.get(counter).getStunCount() + 1);
                        }
                    } else //if player isnt stun resets movement points
                    {
                        MiniRPG.players.get(counter).setMoves(4);
                        textPanes[counter].setMovesLeft(MiniRPG.players.get(counter).getMoves());
                    }
                    if (MiniRPG.players.get(counter).getDamage() > MiniRPG.players.get(counter).getMaxDamage()) //resets player damage
                    {
                        MiniRPG.players.get(counter).setDamage(MiniRPG.players.get(counter).getMaxDamage());
                    }
                    if (MiniRPG.players.get(counter).getHasAttacked() == true) //resets boolean for player spacebar attack
                    {
                        MiniRPG.players.get(counter).setHasAttacked(false);
                    }
                    if (MiniRPG.players.get(counter).getDefense() != MiniRPG.players.get(counter).getMaxDefense()) //resets player defense
                    {
                        MiniRPG.players.get(counter).setDefense(MiniRPG.players.get(counter).getMaxDefense());
                    }
                    if (MiniRPG.players.get(counter).getSkill1Used() == true)
                    {
                        MiniRPG.players.get(counter).setSkill1Used(false);
                    }
                    counter++;
                }
                
            }

            int x = 0;
            while (x < 4) {
                if(e.getSource() == textPanes[x].btnskill1)
                {
                    
                    Skill = ((JButton) (e.getSource())).getText(); //sets Skill to the name of the skill button pressed for Skill Attack to determine what skill is being used
                    if(MiniRPG.players.get(x).getSkill1Used() == false)
                    {
                        SA.SkillAttacks();
                        infoBox.append("\n" + SkillAttacks.TextOutput);
                        if(SkillAttacks.skillSuccessful == true)
                        {
                            CheckIfAlive();
                            MiniRPG.players.get(x).setSkill1Used(true);
                            textPanes[x].setHP(MiniRPG.players.get(x).getHp());
                            textPanes[x].setMovesLeft(MiniRPG.players.get(x).getMoves());
                        }
                    }
                    else
                    {
                        infoBox.append("\n" + "You have already used that skill this round");
                    }
                    x = 4;
                }
                else if (e.getSource() == textPanes[x].btnskill2) 
                {
                    
                    x = 4;
                } 
                else if (e.getSource() == textPanes[x].btnskill3) 
                {
                    
                    x = 4;
                } 
                else if (e.getSource() == textPanes[x].btnskill4) 
                {
                    
                    x = 4;
                } 
                else 
                {
                    x++;
                }
            }
        }
}
    
    static boolean CheckMeleeRange()
    {
        if (selectedMonsterIndex == -1) 
        {
            //System.out.println("no monster selected!!");
        } 
        else if (MiniRPG.players.get(selectedPlayerIndex).getColumn() - 1
                == monsters.get(selectedMonsterIndex).getColumn()
                && MiniRPG.players.get(selectedPlayerIndex).getRow()
                == monsters.get(selectedMonsterIndex).getRow()) 
        {
            inMeleeRange = true;
        } 
        else if (MiniRPG.players.get(selectedPlayerIndex).getRow() + 1
                == monsters.get(selectedMonsterIndex).getRow()
                && MiniRPG.players.get(selectedPlayerIndex).getColumn()
                == monsters.get(selectedMonsterIndex).getColumn()) 
        {
            inMeleeRange = true;
        } 
        else if (MiniRPG.players.get(selectedPlayerIndex).getRow() - 1
                == monsters.get(selectedMonsterIndex).getRow()
                && MiniRPG.players.get(selectedPlayerIndex).getColumn()
                == monsters.get(selectedMonsterIndex).getColumn()) 
        {
            inMeleeRange = true;
        } 
        else if (MiniRPG.players.get(selectedPlayerIndex).getColumn() + 1
                == monsters.get(selectedMonsterIndex).getColumn()
                && MiniRPG.players.get(selectedPlayerIndex).getRow()
                == monsters.get(selectedMonsterIndex).getRow()) 
        {
            inMeleeRange = true;
        } 
        else 
        {
            inMeleeRange = false;
        }
        return inMeleeRange;
    }

    static String GetSelectedSkill() {
        return Skill;
    }

    static int getSelectedPlayer() {
        return SelectedPlayer;
    }

    static int GetSelectedMonster() {
        return selectedMonsterIndex;
    }

    static boolean getIsPlayer() {
        return isPlayer;
    }

    static boolean getIsMonster() {
        return isMonster;
    }

    public void updateTable(int i) {
        table.setValueAt(
                null,
                monsters.get(i).getRow(),
                monsters.get(i).getColumn());

    }

    public void updateTable2(int i) {
        table.setValueAt(
                monsters.get(i).getName(),
                monsters.get(i).getRow(),
                monsters.get(i).getColumn());
    }

    static int getPlayerSelf() {
        return PlayerSelf;
    }

    static boolean getInMeleeRange() {
        return inMeleeRange;
    }

    public void findPlayerToAttack() {
        int i = attackingMonsterIndex;
        //System.out.println("1 FindPlayerToAttack");
        if (attackingMonsterIndex <= 4 && attackingMonsterIndex != -1) {
            lowest = 100;
            for (int x = 0; x < playerDistance.length; x++) {
                int pColDistance = Math.abs((MiniRPG.players.get(x).getColumn() + 1) - 11);
                int pRowDistance = Math.abs((MiniRPG.players.get(x).getRow() + 1) - 11);
                int mColDistance = Math.abs((monsters.get(i).getColumn() + 1) - 11);
                int mRowDistance = Math.abs((monsters.get(i).getRow() + 1) - 11);
                int distanceBetweenCol = Math.abs(pColDistance - mColDistance);
                int distanceBetweenRow = Math.abs(pRowDistance - mRowDistance);
                int distanceTotal = distanceBetweenCol + distanceBetweenRow;
                playerDistance[x] = distanceTotal;
                //System.out.println(distanceBetween);
                if (distanceTotal < lowest) {
                    lowest = playerDistance[x];
                    playerToAttack = x;
                }
                //System.out.println(minirpg.MiniRPG.players.get(x).getName() + " is" + playerDistance[x] + "from " +monsters.get(i).getName() );
            }
            //System.out.println(monsters.get(i).getName() + " should attack " + minirpg.MiniRPG.players.get(playerToAttack).getName());
            //System.out.println("attacking monster index is " + i);


            if (attackingMonsterIndex < 5 && monsters.get(attackingMonsterIndex).getMovesLeft() != 0 
                    && monsters.get(attackingMonsterIndex).getIsStunned() == false 
                    && monsters.get(attackingMonsterIndex).getIsDead() == false) 
            {
                monsterAttack(attackingMonsterIndex);
                //System.out.println("if"); 
            } else if (attackingMonsterIndex < 5 && monsters.get(attackingMonsterIndex).getMovesLeft() == 0) {
                attackingMonsterIndex++;
                //System.out.println("else if"); 
                run();
                //System.out.println(attackingMonsterIndex);
                //System.out.println(i);
            } else {
                //System.out.println("DONE!!");
            }
            //attackingMonsterIndex = -1;
            //System.out.println("meow");



        }
//System.out.println("DONE!! with step 1");
    }

    public void monsterAttack(int attackingMonsterIndex) {
        int i = attackingMonsterIndex;
        //System.out.println("2. MonsterAttack" + "moves left: " + monsters.get(i).getMovesLeft());
        int x = playerToAttack;
        if (monsters.get(i).getMovesLeft() != 0) {
            int pColDistance = Math.abs((MiniRPG.players.get(x).getColumn() + 1) - 11);
            int pRowDistance = Math.abs((MiniRPG.players.get(x).getRow() + 1) - 11);
            int mColDistance = Math.abs((monsters.get(i).getColumn() + 1) - 11);
            int mRowDistance = Math.abs((monsters.get(i).getRow() + 1) - 11);
            int distanceBetweenCol = Math.abs(pColDistance - mColDistance);
            int distanceBetweenRow = Math.abs(pRowDistance - mRowDistance);
            //System.out.println("col distance is " + distanceBetweenCol);
            //System.out.println("row distance is " + distanceBetweenRow); 
            //System.out.println(monsters.get(i).getName() + " should attack " + MiniRPG.players.get(x).getName());
            if (distanceBetweenCol < distanceBetweenRow && monsters.get(i).getColumn() != MiniRPG.players.get(x).getColumn()) {
                if (monsters.get(i).getColumn() < MiniRPG.players.get(x).getColumn()) {
                    // System.out.println("Move Check Right");
                    monsterMoveCheck(1, i);
                    if (mmc == true) {
                        monsterMoveRight();
                        monsterCheckAttack();
                    }
                }
                if (monsters.get(i).getColumn() > MiniRPG.players.get(x).getColumn()) {
                    // System.out.println("Move Check Left");
                    monsterMoveCheck(2, i);
                    if (mmc == true) {
                        monsterMoveLeft();
                        monsterCheckAttack();
                    }
                }
            }
            if (monsters.get(i).getRow() < MiniRPG.players.get(x).getRow()) {
                // System.out.println("Move Check Down");
                monsterMoveCheck(3, i);
                if (mmc == true) {
                    monsterMoveDown();
                    monsterCheckAttack();

                }
            }
            if (monsters.get(i).getRow() > MiniRPG.players.get(x).getRow()) {
                //System.out.println("Move Check Up");
                monsterMoveCheck(4, i);
                if (mmc == true) {
                    monsterMoveUp();
                    monsterCheckAttack();
                }
            }

        }
        // System.out.println("all ifs failed"); 
        if (hasRun == false) {
            //System.out.println("hasRun"); 
            attackingMonsterIndex++;
            monsters.get(i).setMovesLeft(0);

            run();
        } else {
            hasRun = false;
            attackingMonsterIndex++;
            monsters.get(i).setMovesLeft(0);
            run();

        }
    }

    public void monsterMoveCheck(int direction, int attackingMonsterIndex) {
        //System.out.println("3. monsterMoveCheck");
        int d = direction;
        int i = attackingMonsterIndex;
        mmc = false;
        if (d == 1) 
        {
            if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() + 1) == null /*
                     * || table.getValueAt(monsters.get(i).getRow(),
                     * monsters.get(i).getColumn() + 1) == ""
                     */) 
            {
                mmc = true;
            } 
            else 
            {
                //monsterMoveCheck2(2, i);
                monsters.get(i).setMovesLeft(0);
                monsterCheckAttack();
                attackingMonsterIndex++;
                if (hasRun == false) 
                {
                    run();
                } 
                else 
                {
                    hasRun = false;

                }
            }
        }
        if (d == 2) 
        {
            if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() - 1) == null /*
                     * || table.getValueAt(monsters.get(i).getRow(),
                     * monsters.get(i).getColumn() - 1) == ""
                     */) 
            {
                mmc = true;
            } 
            else 
            {
                //monsterMoveCheck2(3, i);
                monsters.get(i).setMovesLeft(0);
                monsterCheckAttack();
                attackingMonsterIndex++;
                if (hasRun == false) 
                {
                    run();
                } 
                else 
                {
                    hasRun = false;

                }
            }
        }
        if (d == 3) 
        {
            if (table.getValueAt(monsters.get(i).getRow() + 1, monsters.get(i).getColumn()) == null /*
                     * || table.getValueAt(monsters.get(i).getRow() + 1,
                     * monsters.get(i).getColumn()) == ""
                     */) 
            {
                mmc = true;
            } 
            else 
            {
                //monsterMoveCheck2(4, i);
                monsters.get(i).setMovesLeft(0);
                monsterCheckAttack();
                attackingMonsterIndex++;
                if (hasRun == false) 
                {
                    run();
                } 
                else 
                {
                    hasRun = false;

                }
            }
        }
        if (d == 4) {
            if (table.getValueAt(monsters.get(i).getRow() - 1, monsters.get(i).getColumn()) == null /*
                     * || table.getValueAt(monsters.get(i).getRow() - 1,
                     * monsters.get(i).getColumn()) == ""
                     */) 
            {
                mmc = true;
            } 
            else 
            {
                //monsterMoveCheck2(0, i);
                monsters.get(i).setMovesLeft(0);
                monsterCheckAttack();
                attackingMonsterIndex++;
                if (hasRun == false) 
                {
                    run();
                } 
                else 
                {
                    hasRun = false;

                }
            }
        }
    }

//    public void monsterMoveCheck2(int direction, int attackingMonsterIndex) {
//        int d = direction;
//        int i = attackingMonsterIndex;
//        if (d == 1) {
//            if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() + 1) == null/*
//                     * || table.getValueAt(monsters.get(i).getRow(),
//                     * monsters.get(i).getColumn() + 1) == ""
//                     */) {
//                monsterMoveDown();
//            } else {
//                monsterMoveCheck2(2, i);
//            }
//        }
//        if (d == 2) {
//            if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() - 1) == null /*
//                     * || table.getValueAt(monsters.get(i).getRow(),
//                     * monsters.get(i).getColumn() - 1) == ""
//                     */) {
//                monsterMoveUp();
//            } else {
//                monsterMoveCheck2(3, i);
//            }
//        }
//        if (d == 3) {
//            if (table.getValueAt(monsters.get(i).getRow() + 1, monsters.get(i).getColumn()) == null /*
//                     * || table.getValueAt(monsters.get(i).getRow() + 1,
//                     * monsters.get(i).getColumn()) == ""
//                     */) {
//                monsterMoveRight();
//            } else {
//                monsterMoveCheck2(4, i);
//            }
//        }
//        if (d == 4) {
//            if (table.getValueAt(monsters.get(i).getRow() - 1, monsters.get(i).getColumn()) == null /*
//                     * || table.getValueAt(monsters.get(i).getRow() - 1,
//                     * monsters.get(i).getColumn()) == ""
//                     */) {
//                monsterMoveLeft();
//            } else {
//                monsterMoveCheck2(1, i);
//            }
//        }
//    }
    public void run() {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                findPlayerToAttack();
            }
        });
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

    public void monsterCheckAttack() {
        //System.out.println("4.monsterCheckAttack");
        int i = attackingMonsterIndex;
        int x = 0;
        mca = false;
        while (x < 4) {
            if (monsters.get(i).getColumn() + 1 < table.getColumnCount()) {
                if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() + 1) != null && monsters.get(i).getHasAttacked() == false) {
                    if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() + 1).equals(MiniRPG.players.get(x).getName())) {
                        mca = true;
                        //System.out.println(monsters.get(i).getName() + " attacks");
                        //playerToAttack = x;
                        monsterHit();
                        break;
                    }
                }
            }
            if (monsters.get(i).getColumn() - 1 > 0) {
                if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() - 1) != null && monsters.get(i).getHasAttacked() == false) {
                    if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() - 1).equals(MiniRPG.players.get(x).getName())) {
                        mca = true;
                        //System.out.println(monsters.get(i).getName() + " attacks");
                        //playerToAttack = x;
                        monsterHit();
                        break;
                    }
                }
            }
            if (monsters.get(i).getRow() + 1 < table.getRowCount()) {
                if (table.getValueAt(monsters.get(i).getRow() + 1, monsters.get(i).getColumn()) != null && monsters.get(i).getHasAttacked() == false) {
                    if (table.getValueAt(monsters.get(i).getRow() + 1, monsters.get(i).getColumn()).equals(MiniRPG.players.get(x).getName())) {
                        mca = true;
                        //System.out.println(monsters.get(i).getName() + " attacks");
                        //playerToAttack = x;
                        monsterHit();
                        break;
                    }
                }
            }
            if (monsters.get(i).getRow() - 1 >= 0) {
                if (table.getValueAt(monsters.get(i).getRow() - 1, monsters.get(i).getColumn()) != null && monsters.get(i).getHasAttacked() == false) {
                    if (table.getValueAt(monsters.get(i).getRow() - 1, monsters.get(i).getColumn()).equals(MiniRPG.players.get(x).getName())) {
                        mca = true;
                        //System.out.println(monsters.get(i).getName() + " attacks");
                        //playerToAttack = x;
                        monsterHit();
                        break;
                    }
                }
            }
            x++;
        }
        if (hasRun == false) {
            run();
        } else {
            hasRun = false;

        }
    }

    public void monsterMoveRight() {
        int i = attackingMonsterIndex;
        updateTable(i);
        monsters.get(i).setColumn(monsters.get(i).getColumn() + 1);
        monsters.get(i).setMovesLeft(monsters.get(i).getMovesLeft() - 1);
        //System.out.println(monsters.get(i).getName() + " moved 1 right");
        updateTable2(i);
        //monsterCheckAttack();
    }

    public void monsterMoveLeft() {
        int i = attackingMonsterIndex;
        updateTable(i);
        monsters.get(i).setColumn(monsters.get(i).getColumn() - 1);
        monsters.get(i).setMovesLeft(monsters.get(i).getMovesLeft() - 1);
        //System.out.println(monsters.get(i).getName() + " moved 1 left");
        updateTable2(i);
        //monsterCheckAttack();
    }

    public void monsterMoveDown() {
        int i = attackingMonsterIndex;
        updateTable(i);
        monsters.get(i).setRow(monsters.get(i).getRow() + 1);
        monsters.get(i).setMovesLeft(monsters.get(i).getMovesLeft() - 1);
        updateTable2(i);
        //System.out.println(monsters.get(i).getName() + " moved 1 down");
        //monsterCheckAttack();
    }

    public void monsterMoveUp() {
        int i = attackingMonsterIndex;
        updateTable(i);
        monsters.get(i).setRow(monsters.get(i).getRow() - 1);
        monsters.get(i).setMovesLeft(monsters.get(i).getMovesLeft() - 1);
        //System.out.println(monsters.get(i).getName() + " moved 1 up");
        updateTable2(i);
        //monsterCheckAttack();
    }

    public void monsterHit() {
        // System.out.println("5. monsterHit");
        int i = attackingMonsterIndex;
        int x = playerToAttack;
        int Damage = (int) (monsters.get(i).getDamage() - MiniRPG.players.get(x).getDefense());
        //System.out.println(x);
        MiniRPG.players.get(x).setHp(MiniRPG.players.get(x).getHp() - Damage);
        infoBox.append("\n" + MiniRPG.players.get(x).getName() + " takes " + Damage + " damage. \n"
                + MiniRPG.players.get(x).getName() + " is down to " + MiniRPG.players.get(x).getHp() + " Hp");
        textPanes[x].setHP(MiniRPG.players.get(x).getHp());
        monsters.get(i).setHasAttacked(true);
        attackingMonsterIndex++;
        hasRun = true;
        run();
    }

    public void resetMonsterStuff() 
    {
        attackingMonsterIndex = 0;
        for (int x = 0; x <= 4; x++) {
            monsters.get(x).setMovesLeft(4);
            monsters.get(x).setHasAttacked(false);
        }
    }

    static boolean rangedAttack(int distance) {
        int d = distance;
      if(d == 5){
          checkRange(d);
          d --;
      }
      if(d == 4){
          checkRange(d);
          d --;
      }  
      if(d == 3){
          checkRange(d);
          d --;
      }
      if(d == 2 && inRange ==false){
          checkRange(d);
          d --;
      }
       if(d == 1 && inRange ==false){
        checkRange(d);
          d --;
      }
        return inRange;
    }

    static void checkRange(int distance) {
        int d = distance;
        if (monsters.get(selectedMonsterIndex).getColumn() >= 3) {
            if (MiniRPG.players.get(selectedPlayerIndex).getColumn() - d
                    == monsters.get(selectedMonsterIndex).getColumn()
                    && MiniRPG.players.get(selectedPlayerIndex).getRow()
                    == monsters.get(selectedMonsterIndex).getRow()) {
                inRange = true;
            }
        }
        if (monsters.get(selectedMonsterIndex).getColumn() <= 7) {
            if (MiniRPG.players.get(selectedPlayerIndex).getRow() + d
                    == monsters.get(selectedMonsterIndex).getRow()
                    && MiniRPG.players.get(selectedPlayerIndex).getColumn()
                    == monsters.get(selectedMonsterIndex).getColumn()) {
                inRange = true;
            }
        }
        if (monsters.get(selectedMonsterIndex).getRow() >= 3) {
            if (MiniRPG.players.get(selectedPlayerIndex).getRow() - d
                    == monsters.get(selectedMonsterIndex).getRow()
                    && MiniRPG.players.get(selectedPlayerIndex).getColumn()
                    == monsters.get(selectedMonsterIndex).getColumn()) {
                inRange = true;
            }
        }
        if (monsters.get(selectedMonsterIndex).getRow() <= 7) {
            if (MiniRPG.players.get(selectedPlayerIndex).getColumn() + d
                    == monsters.get(selectedMonsterIndex).getColumn()
                    && MiniRPG.players.get(selectedPlayerIndex).getRow()
                    == monsters.get(selectedMonsterIndex).getRow()) {
                inRange = true;
            }
        }
    }
    
    protected class TextPane extends JPanel 
    {

    private JLabel name, icon, lblClass, pClass, lblRole, role, lblStr, str, lblDex,
            dex, lblEnd, end, wiz, lblHp, health, lblMoves, movesLeft, lblSkill1;
    private JButton btnskill1, btnskill2, btnskill3, btnskill4;
    private final JLabel lblSkill2, lblSkill3, lblSkill4;

    public TextPane() 
    {

        //add(filler);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel dash;

        name = new JLabel(MiniRPG.players.get(setupPlayerIndex).getName());
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        add(name, c);

        icon = new JLabel(MiniRPG.players.get(setupPlayerIndex).getIcon());
        c.gridx = 1;
        c.gridy = 2;
        add(icon, c);

        lblClass = new JLabel("Class:");
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        add(lblClass, c);

        pClass = new JLabel(MiniRPG.players.get(setupPlayerIndex).getclass());
        c.gridx = 2;
        c.gridy = 3;
        add(pClass, c);

        lblRole = new JLabel("Role:");
        c.gridx = 1;
        c.gridy = 4;
        add(lblRole, c);

        role = new JLabel(MiniRPG.players.get(setupPlayerIndex).getRole());
        c.gridx = 2;
        c.gridy = 4;
        add(role, c);

        dash = new JLabel("--------------------STATS--------------------");
        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 5;
        add(dash, c);

        lblStr = new JLabel("Strengh:");
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 6;
        add(lblStr, c);

        str = new JLabel(Integer.toString(
                MiniRPG.players.get(setupPlayerIndex).getStr()));
        //c.insets = new Insets(5, 5, 5, 5);
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 6;
        add(str, c);

        lblDex = new JLabel("Dexterity:");
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 7;
        add(lblDex, c);

        dex = new JLabel(Integer.toString(
                MiniRPG.players.get(setupPlayerIndex).getDex()));
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 7;
        add(dex, c);

        lblEnd = new JLabel("Endurance:");
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 8;
        add(lblEnd, c);

        end = new JLabel(Integer.toString(
                MiniRPG.players.get(setupPlayerIndex).getEnd()));
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 8;
        add(end, c);

        lblDex = new JLabel("Wisdom:");
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 9;
        add(lblDex, c);

        wiz = new JLabel(Integer.toString(
                MiniRPG.players.get(setupPlayerIndex).getWis()));
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 9;
        add(wiz, c);

        lblHp = new JLabel("HP: ");
        c.gridx = 1;
        c.gridy = 10;
        add(lblHp, c);


        health = new JLabel(Integer.toString(
                MiniRPG.players.get(setupPlayerIndex).getHp()));
        c.gridx = 2;
        c.gridy = 10;
        add(health, c);

        lblMoves = new JLabel("Moves Left: ");
        c.gridx = 1;
        c.gridy = 11;
        add(lblMoves, c);

        movesLeft = new JLabel(Integer.toString(
                MiniRPG.players.get(setupPlayerIndex).getMoves()));
        c.gridx = 2;
        c.gridy = 11;
        add(movesLeft, c);

        dash = new JLabel("--------------------SKILLS--------------------");
        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 12;
        add(dash, c);

        lblSkill1 = new JLabel("Skill 1:");
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 13;
        add(lblSkill1, c);

        btnskill1 = new JButton(MiniRPG.players.get(setupPlayerIndex).getSkill1());
        c.gridx = 2;
        c.gridy = 13;
        add(btnskill1, c);

        lblSkill2 = new JLabel("Skill 2:");
        c.gridx = 1;
        c.gridy = 14;
        add(lblSkill2, c);

        btnskill2 = new JButton(MiniRPG.players.get(setupPlayerIndex).getSkill2());
        c.gridx = 2;
        c.gridy = 14;
        add(btnskill2, c);
        btnskill2.setEnabled(false);

        lblSkill3 = new JLabel("Skill 3:");
        c.gridx = 1;
        c.gridy = 15;
        add(lblSkill3, c);

        btnskill3 = new JButton(MiniRPG.players.get(setupPlayerIndex).getSkill3());
        c.gridx = 2;
        c.gridy = 15;
        add(btnskill3, c);
        btnskill3.setEnabled(false);

        lblSkill4 = new JLabel("Skill 4:");
        c.gridx = 1;
        c.gridy = 16;
        add(lblSkill4, c);

        btnskill4 = new JButton(MiniRPG.players.get(setupPlayerIndex).getSkill4());
        c.gridx = 2;
        c.gridy = 16;
        add(btnskill4, c);
        btnskill4.setEnabled(false);

        btnskill1.addActionListener(e);
        btnskill2.addActionListener(e);
        btnskill3.addActionListener(e);
        btnskill4.addActionListener(e);

    }

    public void setMovesLeft(int value) {
        movesLeft.setText(Integer.toString(value));
    }
    
    public void setHP(int value)
    {
        health.setText(Integer.toString(value));
    }

    }
    
    public boolean isCellEditable(int rowIndex, int colIndex)
    {
        return false;
    }
}
