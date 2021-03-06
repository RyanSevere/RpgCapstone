//Created by Sean Forman and Ryan Severe
package minirpg;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class SetPlayerInfo extends JPanel {
    //all gui buttons,Labels....ect
    JButton addStr, subStr, addDex, subDex, addEnd, subEnd, addWis,
            subWis, create, done;
    JLabel str, dex, end, wis, name, pointsLeftLabel, strTotal,
            dexTotal, endTotal, wisTotal, pointsLeftField, lblName;
    JTextField nameField;
    String playerName = "", SelectedRole, SelectedClass, error;
    JComboBox listBox;
    
    int x = 0, pID = 0, battleCounter = 0, pStr, pDex, pEnd, pWis, pName, pLvl, hp, Damage, baseLineDamage;
    double Defense, Modifyer;
    int comboSelectedIndex;
    public boolean valid = false;
    ImageIcon icon = new ImageIcon();
    PlayerClassPanel pcp = new PlayerClassPanel();    
    IconSelector IS = new IconSelector();
    //Delcared Array for Player Names and Stats
    ArrayList<Player> players = new ArrayList<Player>();
    

    //initalizes an instance of Player() (constructor? error control?)
    public SetPlayerInfo() {
        this(new Player());
    }

    //sets up and inializes layout of GUI for Stats entry
    public SetPlayerInfo(Player newGuy) {
        //<editor-fold defaultstate="Collapsed" desc="GUI layout">
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
              
        //top title       
        name = new JLabel("Character Stat's");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.insets = new Insets(2, 2, 2, 2);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 3; //centering title
        add(name, c);

        //Starts STR stuff
        addStr = new JButton("+");
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1; //reseting back to 1 after centering title
        add(addStr, c);

        subStr = new JButton("-");
        c.gridx = 0;
        c.gridy = 1;
        add(subStr, c);

        str = new JLabel("   Strength   ");
        c.gridx = 2;
        c.gridy = 1;
        add(str, c);
        
        strTotal = new JLabel(Integer.toString(newGuy.getStr()));
        c.gridx = 3;
        c.gridy = 1;
        add(strTotal, c);

        //Starts DEX stuff
        addDex = new JButton("+");
        c.gridx = 1;
        c.gridy = 2;
        add(addDex, c);

        subDex = new JButton("-");
        c.gridx = 0;
        c.gridy = 2;
        add(subDex, c);

        dex = new JLabel("   Dexterity   ");
        c.gridx = 2;
        c.gridy = 2;
        add(dex, c);

        dexTotal = new JLabel(Integer.toString(newGuy.getDex()));
        c.gridx = 3;
        c.gridy = 2;
        add(dexTotal, c);

        //Starts END stuff
        addEnd = new JButton("+");       
        c.gridx = 1;
        c.gridy = 3;
        add(addEnd, c);

        subEnd = new JButton("-");       
        c.gridx = 0;
        c.gridy = 3;
        add(subEnd, c);

        end = new JLabel("   Endurance   ");      
        c.gridx = 2;
        c.gridy = 3;
        add(end, c);

        endTotal = new JLabel(Integer.toString(newGuy.getEnd()));      
        c.gridx = 3;
        c.gridy = 3;
        add(endTotal, c);

        //Starts WIS stuff
        addWis = new JButton("+");       
        c.gridx = 1;
        c.gridy = 4;
        add(addWis, c);

        subWis = new JButton("-");       
        c.gridx = 0;
        c.gridy = 4;
        add(subWis, c);

        wis = new JLabel("   Wisdom   ");       
        c.gridx = 2;
        c.gridy = 4;
        add(wis, c);

        wisTotal = new JLabel(Integer.toString(newGuy.getWis()));       
        c.gridx = 3;
        c.gridy = 4;
        add(wisTotal, c);

        pointsLeftLabel = new JLabel("Points Left: ");       
        c.gridx = 2;
        c.gridy = 5;
        add(pointsLeftLabel, c);

        pointsLeftField = new JLabel(Integer.toString(newGuy.getPointsLeft()));       
        c.gridx = 3;
        c.gridy = 5;
        add(pointsLeftField, c);
        
        lblName = new JLabel("Name: ");       
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 2;
        add(lblName, c);
        
        nameField = new JTextField();       
        //c.insets = new Insets(2, 7, 2, 2);
        c.gridx = 1;
        c.gridy = 7;
        c.gridwidth = 2;
        add(nameField, c);
        
        //adds the buttons the the GUI
        create = new JButton("Create");       
        c.insets = new Insets(2, 2, 2, 2);
        c.gridx = 1;
        c.gridy = 8;
        c.gridwidth = 3;
        add(create, c);        
        
        //combobox lists already created players by name in order of creation
        //only visiable after inital character creation
        // will be deleted in cleaning
        listBox = new JComboBox();
        c.insets = new Insets(2, 9, 2, 2);      
        c.gridx = 0;
        c.gridy = 10;
        c.gridwidth = 3;
        add(listBox, c);
        listBox.setEditable(true);
        listBox.setVisible(false);

        SetPlayerInfo.Event a = new SetPlayerInfo.Event();
        //all the listeners
        addStr.addActionListener(a);
        subStr.addActionListener(a);
        addDex.addActionListener(a);
        subDex.addActionListener(a);
        addEnd.addActionListener(a);
        subEnd.addActionListener(a);
        addWis.addActionListener(a);
        subWis.addActionListener(a);
        create.addActionListener(a);
        listBox.addActionListener(a);
        //</editor-fold>
    }
    
    public class Event implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            int total = 0;
            int num = 0;
            //Setup for + and - for str
            if (a.getSource() == addStr) {  //if button addStr pressed do...
                total = Integer.parseInt(pointsLeftField.getText()); //determines number of points left that can be added to Str
                num = Integer.parseInt(strTotal.getText()); //determines current number of points in Str
                if (total > 0) { //if total is > 0 
                    num += 1;   // add 1 to Str
                    total -= 1; // subtract 1 from points left
                    pointsLeftField.setText(Integer.toString(total)); //update Points left
                    strTotal.setText(Integer.toString(num));    //update Str total
                } else if (total == 0) {   //prevents user from having negative amount of Str
                    JOptionPane.showMessageDialog(create, "You have run out of points to spend"); 
                    
                }
            } else if (a.getSource() == subStr) {
                total = Integer.parseInt(pointsLeftField.getText());
                num = Integer.parseInt(strTotal.getText());
                if (num > 0) {
                    num -= 1;
                    total += 1;
                    strTotal.setText(Integer.toString(num));
                    pointsLeftField.setText(Integer.toString(total));
                } else if (num == 0) {
                    JOptionPane.showMessageDialog(create, "You can not go below zero"); 
                }
            } //Setup for + and - for dex
            else if (a.getSource() == addDex) {
                total = Integer.parseInt(pointsLeftField.getText());
                num = Integer.parseInt(dexTotal.getText());
                if (total > 0) {
                    num += 1;
                    total -= 1;
                    pointsLeftField.setText(Integer.toString(total));
                    dexTotal.setText(Integer.toString(num));
                } else if (total == 0) {
                    JOptionPane.showMessageDialog(create, "You have run out of points to spend"); 
                }
            } else if (a.getSource() == subDex) {
                total = Integer.parseInt(pointsLeftField.getText());
                num = Integer.parseInt(dexTotal.getText());
                if (num > 0) {
                    num -= 1;
                    total += 1;
                    dexTotal.setText(Integer.toString(num));
                    pointsLeftField.setText(Integer.toString(total));
                } else if (num == 0) {
                    JOptionPane.showMessageDialog(create, "You can not go below zero"); 
                }
            }
            //Setup for + and - for end
            if (a.getSource() == addEnd) {
                total = Integer.parseInt(pointsLeftField.getText());
                num = Integer.parseInt(endTotal.getText());
                if (total > 0) {
                    num += 1;
                    total -= 1;
                    pointsLeftField.setText(Integer.toString(total));
                    endTotal.setText(Integer.toString(num));
                } else if (total == 0) {
                    JOptionPane.showMessageDialog(create, "You have run out of points to spend");
                }
            } else if (a.getSource() == subEnd) {
                total = Integer.parseInt(pointsLeftField.getText());
                num = Integer.parseInt(endTotal.getText());
                if (num > 0) {
                    num -= 1;
                    total += 1;
                    endTotal.setText(Integer.toString(num));
                    pointsLeftField.setText(Integer.toString(total));
                } else if (num == 0) {
                    JOptionPane.showMessageDialog(create, "You can not go below zero");
                }
            }
            //Setup for + and - for wis
            if (a.getSource() == addWis) {
                total = Integer.parseInt(pointsLeftField.getText());
                num = Integer.parseInt(wisTotal.getText());
                if (total > 0) {
                    num += 1;
                    total -= 1;
                    pointsLeftField.setText(Integer.toString(total));
                    wisTotal.setText(Integer.toString(num));
                } else if (total == 0) {
                    JOptionPane.showMessageDialog(create, "You have run out of points to spend");
                }
            } else if (a.getSource() == subWis) {
                total = Integer.parseInt(pointsLeftField.getText());
                num = Integer.parseInt(wisTotal.getText());
                if (num > 0) {
                    num -= 1;
                    total += 1;
                    wisTotal.setText(Integer.toString(num));
                    pointsLeftField.setText(Integer.toString(total));
                } else if (num == 0) {
                    JOptionPane.showMessageDialog(create, "You can not go below zero");
                }
            } 
            //create listener
            //Used to set all the stats and adds player to the array list
            //changes menu look the 1st time its clicked
            else if (a.getSource() == create) 
            {
                
                if(nameField.getText().equals("") || nameField.getText() == null) 
                {
                    JOptionPane.showMessageDialog(create, "You must enter a player name");
                }
                else
                {
                    create(); //adds stat information and player name to the array list
                    show(); //makes player list box visable
                }

            } 
            
            //changes menu look
            else if (a.getSource() == done) {
                setStr();
                setDex();
                setEnd();
                setWis();
                setName();
                setPointsLeft();
                setRole();
                setClass();
                setSkill1();
                setSkill2();
                setSkill3();
                setSkill4();
                battleCounter = 4;
                create();
            }
            
        }

        
        //gets all stats 
        //<editor-fold defaultstate="collapsed" desc="allows the array list to know the stats of a player">
        public int getStr() {
            int str = players.get(listBox.getSelectedIndex()).getStr();
            return str;
        }

        public int getDex() {
            int dex = players.get(listBox.getSelectedIndex()).getDex();
            return dex;
        }

        public int getEnd() {
            int end = players.get(listBox.getSelectedIndex()).getEnd();
            return end;
        }

        public int getWis() {
            int wis = players.get(listBox.getSelectedIndex()).getStr();
            return wis;
        }
        
        //seters for all stats
        public void setStr() {
            MiniRPG.players.get(listBox.getSelectedIndex()).setStr(Integer.parseInt(strTotal.getText()));
        }

        public void setDex() {
            MiniRPG.players.get(listBox.getSelectedIndex()).setDex(Integer.parseInt(dexTotal.getText()));
        }

        public void setEnd() {
            MiniRPG.players.get(listBox.getSelectedIndex()).setEnd(Integer.parseInt(endTotal.getText()));
        }

        public void setWis() {
            MiniRPG.players.get(listBox.getSelectedIndex()).setWis(Integer.parseInt(wisTotal.getText()));
        }

        public void setPointsLeft() {
            MiniRPG.players.get(listBox.getSelectedIndex()).setPointsLeft(Integer.parseInt(pointsLeftField.getText()));
        }
        
        public void setClass()
        {
            getSelectedComboIndex();
            TabGUI.comboSelection.get(comboSelectedIndex).getClass();
        }
        
        public void setRole()
        {
            getSelectedComboIndex();
            TabGUI.comboSelection.get(comboSelectedIndex).getRole();
        }
        public void setSkill1()
        {
            getSelectedComboIndex();
            TabGUI.comboSelection.get(comboSelectedIndex).getSkill1();
        }
        public void setSkill2()
        {
            getSelectedComboIndex();
            TabGUI.comboSelection.get(comboSelectedIndex).getSkill2();
        }
        public void setSkill3()
        {
            getSelectedComboIndex();
            TabGUI.comboSelection.get(comboSelectedIndex).getSkill3();
        }
        public void setSkill4()
        {
            getSelectedComboIndex();
            TabGUI.comboSelection.get(comboSelectedIndex).getSkill4();
        }
        
        public void getSelectedComboIndex()
        {
            comboSelectedIndex = PlayerSummeryPanel.getcomboIndex();
        }
        
        //sets name
        public void setName() {
            Object obj = listBox.getSelectedItem();
            MiniRPG.players.get(listBox.getSelectedIndex()).setName(nameField.getText());
            listBox.setEditable(true);
            listBox.setSelectedItem(nameField.getText());
            obj = listBox.getSelectedItem();
            listBox.updateUI();
        }
        //</editor-fold>
        
        //resets all fields
        //makes the create button visable
        //makes the listbox that holds the players visable
        public void show() 
        {
            strTotal.setText("0");
            dexTotal.setText("0");
            endTotal.setText("0");
            wisTotal.setText("0");
            pointsLeftField.setText("16");
            nameField.setText("");
            name.setText("Character Setup");
            nameField.setVisible(true);
            //listBox.setVisible(true);
            create.setVisible(true);
            //makes the battle button visable 
            /*the loop number is how many players need to be created before 
             * the battle can begin*/
            if (battleCounter >= 4) {
                create.setEnabled(false);
                TabGUI.activateSummeryPanel();
                TabGUI.SummerySelected();
            }
        }
        
        //adds the player to the array list found in the main class
        public void create() 
        {
            pStr = Integer.parseInt(strTotal.getText());
            pDex = Integer.parseInt(dexTotal.getText());
            pEnd = Integer.parseInt(endTotal.getText());
            pWis = Integer.parseInt(wisTotal.getText());
            int p = Integer.parseInt(pointsLeftField.getText());
            pLvl = 1;
            playerName = nameField.getText();
            SelectedRole = TabGUI.comboSelection.get(x).getRole();
            SelectedClass = TabGUI.comboSelection.get(x).getclass();                    
            String Skill1 = TabGUI.comboSelection.get(x).getSkill1();
            String Skill2 = TabGUI.comboSelection.get(x).getSkill2();
            String Skill3 = TabGUI.comboSelection.get(x).getSkill3();
            String Skill4 = TabGUI.comboSelection.get(x).getSkill4();
            x++;
            //adds all the information from the menus into the player array creating the player info
            IS.IconSelector();
            icon = IS.getPlayerIcon();
            HP();
            Damage();
            Defense();
            int basicDamage = getDamage();
            int playerHp = getHp();
            double PlayerDefense = getDefense();
            MiniRPG.players.add(new Player(playerName, pStr, pDex, pEnd, pWis, p, 
                    SelectedRole, SelectedClass, Skill1, Skill2, Skill3, Skill4, pLvl,0,0, icon,
                    playerHp, playerHp, basicDamage, basicDamage, PlayerDefense, PlayerDefense, 4, false, false, 0, 0,
                    false, false, false, false));
            pID++;
            name.setText(nameField.getText());
            listBox.addItem(playerName);
            //listBox.setVisible(true);

            battleCounter++;
            if(battleCounter < 4)
            {
                TabGUI.activateClassPanel();
                TabGUI.returntoClassPanel();  
            }
            TabGUI.resetCombo();

        }
    }
    
    public void HP()
    {
        //int modifyer = pEnd/2;
        hp = 20 + (pEnd/2);
    }
    
    public void Damage()
    {
        if(SelectedRole == "Tank")
        {
            baseLineDamage = 5;
            Damage = baseLineDamage + (pStr / 2);
        }
        else if(SelectedRole == "Caster")
        {
            baseLineDamage = 1;
            Damage = baseLineDamage + (pWis / 2);
        }
        else if(SelectedRole == "Healer")
        {
            if(SelectedClass == "Cleric")
            {
                baseLineDamage = 3;
                Damage = baseLineDamage + (pStr / 2);
            }
            else
            {
                baseLineDamage = 1;
                Damage = baseLineDamage + (pWis / 2);
            }
        }
        else if(SelectedRole == "Damage")
        {
            baseLineDamage = 4;
            Damage = baseLineDamage + (pDex / 2);
        }
        
    }
    
    public void Defense()
    {
        if(SelectedRole == "Tank")
        {
            Modifyer= 10 + (pEnd / 2);
            Defense = Modifyer / 100;
        }
        else if(SelectedRole == "Caster")
        {
            Modifyer = 3 + (pEnd / 2);
            Defense = Modifyer / 100;
        }
        else if(SelectedRole == "Healer")
        { 
            Modifyer= 2 + (pEnd / 2);
            Defense = Modifyer / 100;
        }
        else if(SelectedRole == "Damage")
        {
            Modifyer= 5 + (pEnd / 2);
            Defense = Modifyer / 100;
        }
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
        return Damage;
    }
    
    public void setDamage(int Damage)
    {
        this.Damage = Damage;
    }
    
    public double getDefense()
    {
        return Defense;
    }
    
    public void setDefense(double Defense)
    {
        this.Defense = Defense;
    }
}


