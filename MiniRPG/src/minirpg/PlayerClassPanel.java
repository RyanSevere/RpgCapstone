/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minirpg;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.*;

/**
 *
 * @author LordShadow
 */
public class PlayerClassPanel extends JPanel {

       
    //establish Buttons, Drop boxes, Labels
    JButton btnDone, btnAdd;
    JLabel lblClass, lblRole, lblTitle, lblName, lblSkills;
    JTextField txtbxName;
    JTextArea txtbxDescription;
    JComboBox comboClass, comboRole, comboName, comboSkills;
    
    //Skill Description variables
    String SelectedSkill; //where the selected skill will go for the file read function
    String SkillDescription; //where the description from the file will be stored for output
    String Class, Role, Skill;
    boolean isValid = false;
    
       
    public PlayerClassPanel()
    {
       //<editor-fold defaultstate="collapsed" desc="GUI layout">
        //uses gridbag layout to setup GUI
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        //Title
        lblTitle = new JLabel("Character Class Selection");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 5; //centering title text
        add(lblTitle, c);

        //<editor-fold defaultstate="collapsed" desc="grid placement for Player Name and Text Field for player name, not being used on this pannel">
//        //label for name field
//        lblName = new JLabel("Player Name");
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.gridx = 0;
//        c.gridy = 1;
//        add(lblName, c);
//        
//        //text field for name
//        txtbxName = new JTextField(); //need to figure out how to enlarge /extend field size
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.gridx = 2;
//        c.gridy = 1;
//        add(txtbxName, c);
        //</editor-fold>
        
        //label for Role Combo box
        lblRole = new JLabel("Role");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        add(lblRole, c);
        
        //Role Combo Box
        comboRole = new JComboBox(roles);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        add(comboRole, c);
        
        //label for Class Combo Box
        lblClass = new JLabel("Class");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        add(lblClass, c);
        
        //Class Combo Box
        comboClass = new JComboBox(); //popluate based on selection from roles combo box
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;
        add(comboClass, c);
        
        //label for skills combo box
        lblSkills = new JLabel("Skills");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        add(lblSkills, c);
        
        //combo box for skills
        comboSkills = new JComboBox();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        add(comboSkills, c);
        
        //txtbox where Skill Discription will be displayed
        txtbxDescription = new JTextArea(5, 8);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 3;
        add(txtbxDescription, c);
        txtbxDescription.setEditable(false);
        txtbxDescription.setWrapStyleWord(true);
        txtbxDescription.setLineWrap(true);
        
        btnDone = new JButton("Done");
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        add(btnDone, c);
        
        PlayerClassPanel.Event a = new PlayerClassPanel.Event();
        btnDone.addActionListener(a);
        
        //</editor-fold>
        
        
       //<editor-fold defaultstate="collapsed" desc="add and Done button placement not being used on this panel">
        //add button
//        btnAdd = new JButton("Add");
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.gridx = 0;
//        c.gridy = 4;
//        c.gridwidth = 2;
//        c.gridheight = 4;
//        add(btnAdd, c);
        
        //done button
//        btnDone = new JButton("Done");
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.gridx = 2;
//        c.gridy = 4;
//        c.gridwidth = 2;
//        add(btnDone, c);
//        btnDone.setVisible(false);
       //</editor-fold> 
        
       //<editor-fold defaultstate="collapsed" desc="now unused action listeners"> 
       /*
        PlayerClassPanel.Event a = new PlayerClassPanel.Event();
        comboClass.addActionListener(a);
        comboRole.addActionListener(a);
        comboSkills.addActionListener(a);
       */ 
       //</editor-fold> 
        
        ItemListener roleListener = new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)                    
               {
                   
                   String selectedRole = (String) comboRole.getSelectedItem();
                   
                   
                    if (e.getStateChange() == ItemEvent.SELECTED)
                        {
                            //tank();
                            if ("Tank".equals(selectedRole))
                            {
                                comboClass.removeAllItems(); // removes previous selection from combobox
                                comboClass.setModel(new DefaultComboBoxModel(TankClass)); //populates comboClass with Selection
                            }
                            else if ("Healer".equals(selectedRole))
                            {
                                comboClass.removeAllItems();
                                comboClass.setModel(new DefaultComboBoxModel(HealerClass));
                            } 
                            else if ("Caster".equals(selectedRole))
                            {                
                                comboClass.removeAllItems();
                                comboClass.setModel(new DefaultComboBoxModel(CasterClass));
                            }
                            else if ("Damage".equals(selectedRole))
                            {                
                                comboClass.removeAllItems();
                                comboClass.setModel(new DefaultComboBoxModel(DpsClass));
                            }
                            else if ("".equals(selectedRole))
                            {
                                comboClass.removeAllItems();
                                comboSkills.removeAllItems();
                                txtbxDescription.setText("");
                            }


                        }
                    Role =  (String) comboRole.getSelectedItem();
               }
        
        };
        
        
        ItemListener classListener = new ItemListener()
        //<editor-fold defaultstate="collapsed" desc="{...}">
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                String selectedClass = (String) comboClass.getSelectedItem();
                if("Barbarian".equals(selectedClass))
                {
                    comboSkills.removeAllItems();
                    comboSkills.setModel(new DefaultComboBoxModel(BarbarianSkills));
                }
                else if("Monk".equals(selectedClass))
                {
                    comboSkills.removeAllItems();
                    comboSkills.setModel(new DefaultComboBoxModel(MonkSkills));
                }
                else if("Paladin".equals(selectedClass))
                {
                    comboSkills.removeAllItems();
                    comboSkills.setModel(new DefaultComboBoxModel(PaladinSkills));
                }
                else if("Warrior".equals(selectedClass))
                {
                    comboSkills.setModel(new DefaultComboBoxModel(WarriorSkills));
                }
                else if("Cleric".equals(selectedClass))
                {
                    comboSkills.setModel(new DefaultComboBoxModel(ClaricSkills));
                }
                else if("Priest".equals(selectedClass))
                {
                    comboSkills.setModel(new DefaultComboBoxModel(PriestSkills));
                }
                else if("Shaman".equals(selectedClass))
                {
                    comboSkills.setModel(new DefaultComboBoxModel(ShamanSkills));
                }
                else if("Bard".equals(selectedClass))
                {
                    comboSkills.setModel(new DefaultComboBoxModel(BardSkills));
                }
                else if("Wizard".equals(selectedClass))
                {
                    comboSkills.setModel(new DefaultComboBoxModel(WizardSkills));
                }
                else if("Druid".equals(selectedClass))
                {
                    comboSkills.setModel(new DefaultComboBoxModel(DruidSkills));
                }
                else if("Warlock".equals(selectedClass))
                {
                    comboSkills.setModel(new DefaultComboBoxModel(WarlockSkills));
                }
                else if("Pyromancer".equals(selectedClass))
                {
                    comboSkills.setModel(new DefaultComboBoxModel(PyroSkills));
                }
                else if("Swashbuckler".equals(selectedClass))
                {
                    comboSkills.setModel(new DefaultComboBoxModel(SwashSkills));
                }
                else if("Thief".equals(selectedClass))
                {
                    comboSkills.setModel(new DefaultComboBoxModel(ThiefSkills));
                }
                else if("Ranger".equals(selectedClass))
                {
                    comboSkills.setModel(new DefaultComboBoxModel(RangerSkills));
                }
                else if("Assassin".equals(selectedClass))
                {
                    comboSkills.setModel(new DefaultComboBoxModel(AssassinSkills));
                }
                else if("".equals(selectedClass))
                {
                    comboSkills.removeAllItems();
                    txtbxDescription.setText("");
                }
                Class = (String) comboClass.getSelectedItem();
                //System.out.println(Class);
            }
            
        };
        //</editor-fold>
        
        ItemListener skillListener = new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                SelectedSkill = (String) comboSkills.getSelectedItem();
                if(!"".equals(SelectedSkill))
                {
                    readfile();
                    txtbxDescription.setText(SkillDescription);
                }
                else
                {
                    txtbxDescription.setText("");
                }
                Skill = SelectedSkill;
                //System.out.println(Skill);
                
            }
        };
        
        //set listeners
        comboRole.addItemListener(roleListener);
        comboClass.addItemListener(classListener);
        comboSkills.addItemListener(skillListener);        
        
   }
    
    public void checkValid()
    {
        if(!"".equals(Role) || Role != null)
        {
            if(!"".equals(Class) || Class != null)
            {
                if(!"".equals(Skill) || Skill != null)
                {
                    isValid = true;
                }
            }
        }
    }
   
    
    //attempts to do get information from role, class, skill to SetPlayerInfo 
    //some where between the ItemListener and the Getters the Value of Class, Role, and Skill are being set back to null;
    public String getPlayerClass()
        {                         
            return Class;            
        }
    public String getPlayerRole()
        {   
            return Role;
        }
    public String getPlayerSkill()
        {   
            return Skill;
        }
   
    
   //<editor-fold defaultstate="collapsed" desc="read file method to get the skill discription">
    public void readfile()
        {
            try
            {
                //open the file
                //command line parameter
                FileInputStream fstream = new FileInputStream("src/SkillsDescriptions.txt");
                //get the object of DataInputStream
                DataInputStream input = new DataInputStream(fstream);
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String strline;
                //Read File line by line
                while ((strline = reader.readLine()) != null)
                {
                    //for testing Print the contents on the console
                    if(strline.equals(SelectedSkill))
                    {
                        SkillDescription = reader.readLine();
                        
                    }
                }
                //close the input stream
                input.close();
            }
            catch (Exception e) 
            {
                System.err.println("Error: "+ e.getMessage());        
            }
        }
    //</editor-fold>
    
    
  //<editor-fold //<editor-fold defaultstate="collapsed" desc="ActionLiseners Replaced with ItemListeners, Resolved Issue of comboboxs getting multipule instances of the same list">
    
        public class Event implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource() == btnDone)
                {
                    TabGUI.activateStatPanel();
                    
                    checkValid();
                    if (isValid == true)
                    {
                        TabGUI.comboSelection.add(new ComboSelection(Role, Class, Skill));
                        isValid = false;
                        TabGUI.disableClassPanel();
                        TabGUI.FowardStatPanel();
                    }
                }
            }
        }
        
    //</editor-fold>    
    
   
  //<editor-fold defaultstate="collapsed" desc="no longer used methods for filling in combobox's">
    /*public void comboClasscleaner()
    {
        int x = 5;
        int y = 6;
        if(x <= comboClass.getItemCount())
        {
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            System.out.println("number of item in combo" + comboClass.getItemCount());
            comboClass.removeItemAt(6);
            comboClass.removeItemAt(7);
            comboClass.removeItemAt(8);
            comboClass.removeItemAt(9);
            comboClass.removeItemAt(10);
            y++;
        }
    }
    
    public void tank()
    {
        int x = 0;
        while (x < TankClass.length) 
        {
            System.out.println(x);
            comboClass.insertItemAt(TankClass[x], x);
            x++;
        }
    }
    
    public void caster()
    {
        int x = 0;
        while (x < CasterClass.length)
        {
            System.out.println(x);
            comboClass.insertItemAt(CasterClass[x], x);
            x++;
        }
    }
    
    public void healer()
    {
        int x = 0;
        while (x < HealerClass.length)
        {
            comboClass.insertItemAt(HealerClass[x], x);
            x++;
        }
    }
    
    public void dps()
    {
        int x = 0;
        while (x < DpsClass.length)
        {
            comboClass.insertItemAt(DpsClass[x], x);
            x++;
        }
    }
    
    public void barbarian()
    {
        int x = 0;
        while (x < BarbarianSkills.length)
        {
            comboSkills.insertItemAt(BarbarianSkills[x], x);
            x++;
        }
    }
    
    */
  //</editor-fold>
   
    
    //<editor-fold defaultstate="collapsed" desc="Drop Box Arrays">
    //Roles Array
    String[] roles = {"", "Tank", "Healer", "Caster", "Damage"};
    //Array for Tank Classes
    String[] TankClass = {"", "Barbarian", "Monk", "Paladin", "Warrior"};
        //Array for Healer Classes
    String[] HealerClass = {"", "Cleric", "Priest", "Shaman", "Bard"};
    //Array for Caster Classes
    String[] CasterClass = {"", "Wizard", "Druid", "Warlock", "Pyromancer"};
    //Array for Damage Classes
    String[] DpsClass = {"", "Swashbuckler", "Thief", "Ranger", "Assassin"};
    
    //Skill Arrays
    //arrays for tank class skills
    String[] BarbarianSkills = {"", "Rush", "Rage", "Spin", "KnockBack"};
    String[] MonkSkills = {"", "Focus Strike", "Meditate", "Stun", "Roundhouse"};
    String[] PaladinSkills = {"", "Lay on Hands", "Banish", "Holy Strike", "Righteous Rage"};
    String[] WarriorSkills = {"", "Shield Bash", "Tactical Strike", "Power Attack", "Rally"};
    //Arrays for Caster Skills
    String[] WizardSkills = {"", "Fireball", "Magic Missile", "Lightning Bolt", "Frost Shard"};
    String[] DruidSkills = {"", "Entanglement", "Natures Touch", "Summon Dire Wolf", "Wild Shape"};
    String[] WarlockSkills = {"", "Shadow Bolt", "Fear", "Drain Life", "Summon Demon"};
    String[] PyroSkills = {"", "Fire Blast", "Blaze", "Incinerate", "Mind Fire"};
    //Arrays for Healer Skills
    String[] ClaricSkills = {"", "Holy Bash", "Prayer", "Holy Aura", "Divine Intervention"};
    String[] PriestSkills = {"", "Heal Target", "Holy Fire", "Heal All", "Act of GOD"};
    String[] ShamanSkills = {"", "Curse", "Heal", "Protection", "Magic Weapon"};
    String[] BardSkills = {"", "Throw Dagger", "Song of Inspiration", "Song of Renewal", "Facinate"};
    //Arrays for Damage Skills
    String[] SwashSkills = {"", "Repose", "Dirty Trick", "Pistol Shot", "Pillage"};
    String[] ThiefSkills = {"", "Back Stab", "Poison", "Stealth", "Steal"};
    String[] RangerSkills = {"", "Aimed Shot", "Bow Strike", "Arrow Stab", "Rain of Arrows"};
    String[] AssassinSkills = {"", "Garrote", "Throwing Knife", "Kidney Stab", "Assassinate"};
    
    String[] empty = {""};
    //</editor-fold>
}
