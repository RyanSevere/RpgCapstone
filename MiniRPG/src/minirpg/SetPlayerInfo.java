package minirpg;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.*;

public class SetPlayerInfo extends JPanel {
    //all gui buttons,Labels....ect
    JButton addStr, subStr, addDex, subDex, addEnd, subEnd, addWis,
            subWis, create, edit, done, battle;
    JLabel str, dex, end, wis, name, pointsLeftLabel, strTotal,
            dexTotal, endTotal, wisTotal, pointsLeftField;
    JTextField nameField;
    String playerName = "meow";
    JComboBox listBox;
    
    PlayerClassPanel pcp = new PlayerClassPanel();
    
    //Delcared Array for Player Names and Stats
    ArrayList<Player> players = new ArrayList<Player>();
    ListIterator<Player> namelist = players.listIterator();
    //Player player; // unneeded code for current set up
    //Player setInfo = new Player(); //point of this line of code? does not seem to be used other then to initalize an instance of player but is not used else were
    int battleCounter = 0;
    int pID = 0;

    //initalizes an instance of Player() (constructor? error control?)
    public SetPlayerInfo() {
        this(new Player());
    }

    //sets up and inializes layout of GUI for Stats entry
    public SetPlayerInfo(Player newGuy) {
        //inital instructions message before game menu
        //JOptionPane.showMessageDialog(rootPane, "Create 4 Players then the battle button will become visable");
        //uses gridbag layout to setup gui
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
        
        nameField = new JTextField();       
        //c.insets = new Insets(2, 7, 2, 2);
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 3;
        add(nameField, c);
        
        //adds the buttons the the GUI
        create = new JButton("Create");       
        c.insets = new Insets(2, 2, 2, 2);
        c.gridx = 0;
        c.gridy = 8;
        c.gridwidth = 2;
        add(create, c);

        edit = new JButton("Edit");       
        c.gridx = 2;
        c.gridy = 8;
        c.gridwidth = 2;
        add(edit, c);

        done = new JButton("Done");       
        c.gridx = 2;
        c.gridy = 8;
        c.gridwidth = 2;
        add(done, c);
        
        //combobox lists already created players by name in order of creation
        //only visiable after inital character creation
        listBox = new JComboBox();
        c.insets = new Insets(2, 9, 2, 2);      
        c.gridx = 0;
        c.gridy = 9;
        c.gridwidth = 3;
        add(listBox, c);
        listBox.setEditable(true);
        listBox.setVisible(false);
        
        //only visable after 4 characters created
        battle = new JButton("Battle");       
        c.insets = new Insets(2, 2, 2, 30);
        c.gridx = 1;
        c.gridy = 10;
        c.gridwidth = 2;
        add(battle, c);
        battle.setVisible(false);


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
        edit.addActionListener(a);
        listBox.addActionListener(a);
        done.addActionListener(a);
        battle.addActionListener(a);

    }
    
    public class Event implements ActionListener {

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
                    JOptionPane.showMessageDialog(create, "You can not go below zero"); //no popup happens to display message but user cannot go below 0
                    
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
                    JOptionPane.showMessageDialog(create, "You can not go below zero"); //no popup happens to display message but user cannot go below 0
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
                    JOptionPane.showMessageDialog(create, "You can not go below zero"); //no popup happens to display message but user cannot go below 0
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
                    JOptionPane.showMessageDialog(create, "You can not go below zero"); //no popup happens to display message but user cannot go below 0
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
                    JOptionPane.showMessageDialog(create, "You can not go below zero"); //no popup happens to display message but user cannot go below 0
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
                    JOptionPane.showMessageDialog(create, "You can not go below zero"); //no popup happens to display message but user cannot go below 0
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
                    //JOptionPane.showMessageDialog(rootPane,
                      //      "You can not go below zero");
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
                    //JOptionPane.showMessageDialog(rootPane,
                      //      "You can not go below zero");
                }
            } 
            //create listener
            //Used to set all the stats and adds player to the array list
            //changes menu look the 1st time its clicked
            else if (a.getSource() == create) {
                create(); //adds stat information and player name to the array list
                show(); //makes player list box visable
            } 
            //edit listener
            else if (a.getSource() == edit) {
                edit();
                nameField.setText(MiniRPG.players.get(listBox.getSelectedIndex()).getName());
            } 
            //clicked after a player is done with editing a player
            //changes menu look
            /*changing the name with edit doesn't update the dropdown menu but
            *does change the name*/
            else if (a.getSource() == done) {
                setStr();
                setDex();
                setEnd();
                setWis();
                setName();
                setPointsLeft();
                show();
            }
            //makes current window disappear
            //opens battle window
            else if (a.getSource() == battle) {
                setVisible(false);
                Battle gui = new Battle();
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gui.setSize(1000, 550);
                gui.setResizable(false);
                gui.setVisible(true);
            }
        }

        
        //gets all stats 
        //allows the array list to know the stats of a player
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
        
        //sets name
        public void setName() {
            Object obj = listBox.getSelectedItem();
            MiniRPG.players.get(listBox.getSelectedIndex()).setName(nameField.getText());
            listBox.setEditable(true);
            listBox.setSelectedItem(nameField.getText());
            obj = listBox.getSelectedItem();
            listBox.updateUI();
        }
        
        //resets all fields
        //makes the edit and create buttons visable
        //makes the listbox that holds the players visable

        public void show() {
            strTotal.setText("0");
            dexTotal.setText("0");
            endTotal.setText("0");
            wisTotal.setText("0");
            pointsLeftField.setText("15");
            nameField.setText("");
            name.setText("Character Setup");
            done.setVisible(false);
            edit.setVisible(true);
            nameField.setVisible(true);
            listBox.setVisible(true);
            create.setVisible(true);
            //makes the battle button visable 
            /*the loop number is how many players need to be created before 
             * the battle can begin*/
            if (battleCounter >= 4) {
                battle.setVisible(true);
            }
        }
        //lets you edit the player at the index selected 
        //chages the menu look
        public void edit() {
            String setStr = Integer.toString(MiniRPG.players.get(listBox.getSelectedIndex()).getStr());
            String setDex = Integer.toString(MiniRPG.players.get(listBox.getSelectedIndex()).getDex());
            String setEnd = Integer.toString(MiniRPG.players.get(listBox.getSelectedIndex()).getEnd());
            String setWis = Integer.toString(MiniRPG.players.get(listBox.getSelectedIndex()).getWis());
            String setPointsLeft = Integer.toString(MiniRPG.players.get(listBox.getSelectedIndex()).getPointsLeft());
            strTotal.setText(setStr);
            dexTotal.setText(setDex);
            endTotal.setText(setEnd);
            wisTotal.setText(setWis);
            pointsLeftField.setText(setPointsLeft);
            edit.setVisible(false);
            create.setVisible(false);
            listBox.setVisible(false);
            battle.setVisible(false);
            done.setVisible(true);
            playerName = MiniRPG.players.get(listBox.getSelectedIndex()).getName();
            name.setText(playerName);
            pointsLeftField.setText(Integer.toString(MiniRPG.players.get(listBox.getSelectedIndex()).getPointsLeft()));
        }
        //adds the player to the array list found in the main class
        public void create() {
                        
            int s = Integer.parseInt(strTotal.getText());
            int d = Integer.parseInt(dexTotal.getText());
            int e = Integer.parseInt(endTotal.getText());
            int w = Integer.parseInt(wisTotal.getText());
            int p = Integer.parseInt(pointsLeftField.getText());
            int lvl = 1;
            playerName = nameField.getText();
            String Role = pcp.getPlayerRole();
            String Class =pcp.getPlayerClass();
            String Skill = pcp.getPlayerSkill();
                       
            //adds all the information from the menus into the player array creating the player info
            MiniRPG.players.add(new Player(playerName, s, d, e, w, p, 
                    Role, Class, Skill, "Skill 2", " Skill 3", "Skill 4", lvl));
            pID++;
            name.setText(nameField.getText());
            listBox.addItem(playerName);
            listBox.setVisible(true);
            if (battleCounter >= 4) {
                battle.setVisible(true);
            } else {
                battleCounter++;
            }
            
        }
    }
}


//test comment for github
