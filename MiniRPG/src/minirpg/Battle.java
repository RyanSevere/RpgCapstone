//created by Sean Forman
package minirpg;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.table.TableCellRenderer;

public class Battle extends JFrame {

    IconSelector IS = new IconSelector();
    ImageIcon Orc = IS.getOrc();
    ImageIcon Ogre = IS.getOgre();
    ImageIcon Goblin = IS.getGoblin();
    Random rand = new Random();
    public static ArrayList<Monster> monsters = new ArrayList<Monster>();
    boolean moveCheck = false;
    int monsterIndex;
    int setupPlayerIndex = 0;
    int selectedPlayerIndex = 0;
    int selectedMonsterIndex = 0;
    JTable table = new JTable(10, 10);
    JButton skill1, skill2,  skill3, skill4;//add buttons as needed
    JLabel lblClass, pClass, lblRole, role, lblStr, lblDex, lblEnd, lblwiz, str, dex, end,
            wiz, movesLeft, lblHp, hp, skills, name, icon, dash, lblSkill1,
            lblSkill2, lblSkill3, lblSkill4;
    JTextArea infoBox;
    String empty = "";
    public JTabbedPane characterInfoPane;

    public Battle() {
        
        infoBox = new JTextArea(6, 95);
        infoBox.setEditable(false);
        //table.setShowGrid(false);
        table.setSelectionBackground(Color.white);
        table.setRowHeight(50);
        table.setBorder(BorderFactory.createLineBorder(Color.black));
        monsters.add(new Monster("Orc", Orc, 1, 0, 3));
        monsters.add(new Monster("Goblin", Goblin, 1, 0, 7));
        monsters.add(new Monster("Goblin", Goblin, 1, 1, 0));
        monsters.add(new Monster("Orc", Orc, 1, 2, 8));
        monsters.add(new Monster("Ogre", Ogre, 1, 2, 2));

        setMap();

        JPanel battleGridPane = new JPanel();
        Dimension minimumSize = new Dimension(800, 100);
        battleGridPane.setMinimumSize(minimumSize);
        battleGridPane.add(table);
       
        
        final JTabbedPane characterInfoPane = new JTabbedPane();
        while (setupPlayerIndex < 4) {
            JComponent panel = makeTextPanel("");
            characterInfoPane.addTab(minirpg.MiniRPG.players.get(setupPlayerIndex).getName(), null, panel,
                    "");
            setupPlayerIndex++;
        }


        JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                true, battleGridPane, characterInfoPane);

        JPanel battleTextPane = new JPanel();
        Dimension battleTextPannelSize = new Dimension(800, 500);
        battleGridPane.setMinimumSize(battleTextPannelSize);
        battleTextPane.add(infoBox);

        JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                true, splitPane1, battleTextPane);


        getContentPane().add(splitPane2);

//        Event a = new Event();

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
                        System.out.println("ROW:" + MiniRPG.players.get(x).getRow() + "," + "COLUMN:" + MiniRPG.players.get(x).getColumn());
                    }
                    k.consume();
                }
                else if (keyCode == KeyEvent.VK_S) {
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
                        System.out.println("ROW:" + MiniRPG.players.get(x).getRow() + "," + "COLUMN:" + MiniRPG.players.get(x).getColumn());
                    }
                    k.consume();
                }
                else if (keyCode == KeyEvent.VK_A) {
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
                        System.out.println("ROW:" + MiniRPG.players.get(x).getRow() + "," + "COLUMN:" + MiniRPG.players.get(x).getColumn());
                    }
                    k.consume();
                }
                else if (keyCode == KeyEvent.VK_D) {
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
                        System.out.println("ROW:" + MiniRPG.players.get(x).getRow() + "," + "COLUMN:" + MiniRPG.players.get(x).getColumn());
                    }
                    k.consume();
                }
                
                else if (keyCode == KeyEvent.VK_SPACE) {
                    if(selectedMonsterIndex == -1){
                        System.out.println("no monster selected!!");
                    }
                    else if (MiniRPG.players.get(selectedPlayerIndex).getColumn() -1 == 
                            monsters.get(selectedMonsterIndex).getColumn() && 
                            MiniRPG.players.get(selectedPlayerIndex).getRow() == 
                            monsters.get(selectedMonsterIndex).getRow()) {
                        System.out.println("col hit left!.....on "+ monsters.get(selectedMonsterIndex).getName());
                    }
                    
                    
                    else  if (MiniRPG.players.get(selectedPlayerIndex).getRow() + 1 == 
                            monsters.get(selectedMonsterIndex).getRow() && 
                            MiniRPG.players.get(selectedPlayerIndex).getColumn() == 
                            monsters.get(selectedMonsterIndex).getColumn()) {
                        System.out.println("row hit down!.....on "+ monsters.get(selectedMonsterIndex).getName());
                    }
                    
                    else if (MiniRPG.players.get(selectedPlayerIndex).getRow() - 1 == 
                            monsters.get(selectedMonsterIndex).getRow() &&
                            MiniRPG.players.get(selectedPlayerIndex).getColumn() == 
                            monsters.get(selectedMonsterIndex).getColumn() ) {
                        System.out.println("row hit up!.....on "+ monsters.get(selectedMonsterIndex).getName());
                    }
                    else if (MiniRPG.players.get(selectedPlayerIndex).getColumn() + 1 ==
                            monsters.get(selectedMonsterIndex).getColumn()&& 
                            MiniRPG.players.get(selectedPlayerIndex).getRow() == 
                            monsters.get(selectedMonsterIndex).getRow()){
                        System.out.println("col hit right!.....on " + monsters.get(selectedMonsterIndex).getName());
                    }
                    else{
                        System.out.println("dat monster bez tooooo far away!!");
                    }
                    k.consume();
                }
            }
        });
        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                //System.out.println(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
                int x = 0;
                boolean selectedPlayerColumn = false;
                boolean selectedPlayerRow = false;
                boolean selectedMonsterColumn = false;
                boolean selectedMonsterRow = false;
                boolean playerCheck = false;
                boolean monsterCheck = false;
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
                        //System.out.println("Player selected" + MiniRPG.players.get(x).getName());
                        playerCheck = false;
                        characterInfoPane.setSelectedIndex(x);
                        break;
                    }
                    x++;
                }
                x = 0;
                while (x <= 4){
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
                        monsterCheck = false;
                        System.out.println("is " + monsters.get(x).getName() +" the monster you were looking for?");
                        selectedMonsterIndex = x;
                        break;
                    }
                    else{
                        selectedMonsterIndex = -1;
                    }
                    x++;
                    
                }
            }
        });
    }

    //deals with player attack use later also uncomment event
    /*
     * public class Event implements ActionListener {
     *
     * public void actionPerformed(ActionEvent a) { if (a.getSource() == moveP1)
     * { p1MoveCheck = true; } else if (a.getSource() == attackP1) {
     * p1AttackCheck = true; } } }
     */
    public void setMap() {
        //Sets Players
        MiniRPG.players.get(0).setColumn(3);
        MiniRPG.players.get(1).setColumn(4);
        MiniRPG.players.get(2).setColumn(5);
        MiniRPG.players.get(3).setColumn(6);
        
        MiniRPG.players.get(0).setRow(9);
        MiniRPG.players.get(1).setRow(9);
        MiniRPG.players.get(2).setRow(9);
        MiniRPG.players.get(3).setRow(9);
        
        table.setValueAt(MiniRPG.players.get(0).getName(), 9, 3);
        table.setValueAt(MiniRPG.players.get(1).getName(), 9, 4);
        table.setValueAt(MiniRPG.players.get(2).getName(), 9, 5);
        table.setValueAt(MiniRPG.players.get(3).getName(), 9, 6);
        //Sets Monsters
        monsters.get(0).setColumn(3);
        monsters.get(1).setColumn(7);
        monsters.get(2).setColumn(0);
        monsters.get(3).setColumn(8);
        monsters.get(4).setColumn(2);
        
        monsters.get(0).setRow(0);
        monsters.get(1).setRow(0);
        monsters.get(2).setRow(1);
        monsters.get(3).setRow(2);
        monsters.get(3).setRow(2);
        
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
                if (monsters.get(i).getColumn() == colInt && cc == false) {
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
        try {
            // Open the file that is the first 
            // command line parameter
            FileInputStream fstream = new FileInputStream(file);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                if (strLine.equals(moveName)) {
                    isRanged = br.readLine();
                    range = br.readLine();
                    damage = br.readLine();
                    output = br.readLine();
                }
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        //panel.add(filler);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        name = new JLabel(minirpg.MiniRPG.players.get(setupPlayerIndex).getName());
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        panel.add(name, c);

        icon = new JLabel(MiniRPG.players.get(setupPlayerIndex).getIcon());
        c.gridx = 1;
        c.gridy = 2;
        panel.add(icon, c);

        lblClass = new JLabel("Class:");
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        panel.add(lblClass, c);

        pClass = new JLabel(MiniRPG.players.get(setupPlayerIndex).getclass());
        c.gridx = 2;
        c.gridy = 3;
        panel.add(pClass, c);

        lblRole = new JLabel("Role:");
        c.gridx = 1;
        c.gridy = 4;
        panel.add(lblRole, c);

        role = new JLabel(MiniRPG.players.get(setupPlayerIndex).getRole());
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
                minirpg.MiniRPG.players.get(setupPlayerIndex).getStr()));
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
                minirpg.MiniRPG.players.get(setupPlayerIndex).getDex()));
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
                minirpg.MiniRPG.players.get(setupPlayerIndex).getEnd()));
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
                minirpg.MiniRPG.players.get(setupPlayerIndex).getWis()));
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

        skill1 = new JButton(MiniRPG.players.get(setupPlayerIndex).getSkill1());
        c.gridx = 2;
        c.gridy = 12;
        panel.add(skill1, c);

        lblSkill2 = new JLabel("Skill 2:");
        c.gridx = 1;
        c.gridy = 13;
        panel.add(lblSkill2, c);

        skill2 = new JButton(MiniRPG.players.get(setupPlayerIndex).getSkill2());
        c.gridx = 2;
        c.gridy = 13;
        panel.add(skill2, c);

        lblSkill3 = new JLabel("Skill 3:");
        c.gridx = 1;
        c.gridy = 14;
        panel.add(lblSkill3, c);

        skill3 = new JButton(MiniRPG.players.get(setupPlayerIndex).getSkill3());
        c.gridx = 2;
        c.gridy = 14;
        panel.add(skill3, c);

        lblSkill4 = new JLabel("Skill 4:");
        c.gridx = 1;
        c.gridy = 15;
        panel.add(lblSkill4, c);

        skill4 = new JButton(MiniRPG.players.get(setupPlayerIndex).getSkill4());
        c.gridx = 2;
        c.gridy = 15;
        panel.add(skill4, c);


        return panel;
    }

    private void wMoveCheck(int x) {
        if (MiniRPG.players.get(x).getRow() - 1 >= 0) {
            if (table.getValueAt(
                    MiniRPG.players.get(x).getRow() - 1,
                    MiniRPG.players.get(x).getColumn()) == null) {
                moveCheck = true;
            }
        } else {
            System.out.println("not so legal move");
        }
    }

    private void sMoveCheck(int x) {
        if (MiniRPG.players.get(x).getRow() + 1 <= 9) {
            if (table.getValueAt(
                    MiniRPG.players.get(x).getRow() + 1,
                    MiniRPG.players.get(x).getColumn()) == null) {
                moveCheck = true;
            }
        } else {
            System.out.println("not so legal move");
        }
    }
    private void aMoveCheck(int x) {
        if (MiniRPG.players.get(x).getColumn() - 1 >= 0) {
            if (table.getValueAt(
                    MiniRPG.players.get(x).getRow(),
                    MiniRPG.players.get(x).getColumn() - 1) == null) {
                moveCheck = true;
            }
        } else {
            System.out.println("not so legal move");
        }
    }

    private void dMoveCheck(int x) {
        if (MiniRPG.players.get(x).getColumn() + 1 <= 9) {
            if (table.getValueAt(
                    MiniRPG.players.get(x).getRow() ,
                    MiniRPG.players.get(x).getColumn()+ 1) == null) {
                moveCheck = true;
            }
        } else {
            System.out.println("not so legal move");
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
}
