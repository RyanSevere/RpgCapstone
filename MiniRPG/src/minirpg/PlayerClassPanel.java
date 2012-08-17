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
    JButton btnDone;
    JLabel lblClass, lblRole, lblTitle, lblName, lblSkills, lblspacer;
    JTextArea txtbxDescription;
    JComboBox comboClass, comboRole, comboName, comboSkills;
    String defaultmessage = "Skill dropdown is for Skill Preview, and skill description. Not Skill Selection",
            TankMessage = "Tank basic damage based on Str", 
            CasterMessage = "Caster basic damage based on Wis",
            DamageMessage = "Damage basic damage based on Dex", 
            HealerMessage ="Healer basic damage based on Wis, Except Cleric which is based on Str",
            //Skill Description variables
            SelectedSkill, //where the selected skill will go for the file read function
            SkillDescription, //where the description from the file will be stored for output
            Class = "", Role = "", Skill1 = "", Skill2 = "", Skill3 = "", Skill4 = "", error;
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
  
        //label for Role Combo box
        lblRole = new JLabel("Role ");
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
        
        lblspacer = new JLabel("  ");
        c.gridx = 2;
        c.gridy = 2;
        add(lblspacer, c);
        
        //label for Class Combo Box
        lblClass = new JLabel("Class ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        add(lblClass, c);
        
        //Class Combo Box
        comboClass = new JComboBox(); //popluate based on selection from roles combo box
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        add(comboClass, c);
        
        //label for skills combo box
        lblSkills = new JLabel("Skills ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        add(lblSkills, c);
        
        //combo box for skills
        comboSkills = new JComboBox();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
        add(comboSkills, c);
        
        //txtbox where Skill Discription will be displayed
        txtbxDescription = new JTextArea(5, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;
        c.gridwidth = 3;
        c.gridheight = 3;
        add(txtbxDescription, c);
        txtbxDescription.setEditable(false);
        txtbxDescription.setWrapStyleWord(true);
        txtbxDescription.setLineWrap(true);
        txtbxDescription.setText(defaultmessage);
        
        btnDone = new JButton("Done");
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 1;
        add(btnDone, c);
        
        PlayerClassPanel.Event a = new PlayerClassPanel.Event();
        btnDone.addActionListener(a);
        
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
                                resetSelection();
                                comboClass.setModel(new DefaultComboBoxModel(TankClass));//populates comboClass with Selection
                                txtbxDescription.setText(TankMessage);
                            }
                            else if ("Healer".equals(selectedRole))
                            {
                                resetSelection();
                                comboClass.setModel(new DefaultComboBoxModel(HealerClass));
                                txtbxDescription.setText(HealerMessage);
                            } 
                            else if ("Caster".equals(selectedRole))
                            {                
                                resetSelection();
                                comboClass.setModel(new DefaultComboBoxModel(CasterClass));
                                txtbxDescription.setText(CasterMessage);
                            }
                            else if ("Damage".equals(selectedRole))
                            {                
                                resetSelection();
                                comboClass.setModel(new DefaultComboBoxModel(DpsClass));
                                txtbxDescription.setText(DamageMessage);
                            }
                            else if ("".equals(selectedRole))
                            {
                                resetSelection();
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
                    txtbxDescription.setText("");
                    comboSkills.setModel(new DefaultComboBoxModel(BarbarianSkills));
                    SetSkills();
                }
                else if("Monk".equals(selectedClass))
                {
                    txtbxDescription.setText("");
                    comboSkills.setModel(new DefaultComboBoxModel(MonkSkills));
                    SetSkills();
                }
                else if("Paladin".equals(selectedClass))
                {
                    txtbxDescription.setText("");
                    comboSkills.setModel(new DefaultComboBoxModel(PaladinSkills));
                    SetSkills();
                }
                else if("Warrior".equals(selectedClass))
                {
                    txtbxDescription.setText("");
                    comboSkills.setModel(new DefaultComboBoxModel(WarriorSkills));
                    SetSkills();
                }
                else if("Cleric".equals(selectedClass))
                {
                    txtbxDescription.setText("");
                    comboSkills.setModel(new DefaultComboBoxModel(ClaricSkills));
                    SetSkills();
                }
                else if("Priest".equals(selectedClass))
                {
                    txtbxDescription.setText("");
                    comboSkills.setModel(new DefaultComboBoxModel(PriestSkills));
                    SetSkills();
                }
                else if("Shaman".equals(selectedClass))
                {
                    txtbxDescription.setText("");
                    comboSkills.setModel(new DefaultComboBoxModel(ShamanSkills));
                    SetSkills();
                }
                else if("Bard".equals(selectedClass))
                {
                    txtbxDescription.setText("");
                    comboSkills.setModel(new DefaultComboBoxModel(BardSkills));
                    SetSkills();
                }
                else if("Wizard".equals(selectedClass))
                {
                    txtbxDescription.setText("");
                    comboSkills.setModel(new DefaultComboBoxModel(WizardSkills));
                    SetSkills();
                }
                else if("Druid".equals(selectedClass))
                {
                    txtbxDescription.setText("");
                    comboSkills.setModel(new DefaultComboBoxModel(DruidSkills));
                    SetSkills();
                }
                else if("Warlock".equals(selectedClass))
                {
                    txtbxDescription.setText("");
                    comboSkills.setModel(new DefaultComboBoxModel(WarlockSkills));
                    SetSkills();
                }
                else if("Pyromancer".equals(selectedClass))
                {
                    txtbxDescription.setText("");
                    comboSkills.setModel(new DefaultComboBoxModel(PyroSkills));
                    SetSkills();
                }
                else if("Swashbuckler".equals(selectedClass))
                {
                    txtbxDescription.setText("");
                    comboSkills.setModel(new DefaultComboBoxModel(SwashSkills));
                    SetSkills();
                }
                else if("Thief".equals(selectedClass))
                {
                    txtbxDescription.setText("");
                    comboSkills.setModel(new DefaultComboBoxModel(ThiefSkills));
                    SetSkills();
                }
                else if("Ranger".equals(selectedClass))
                {
                    txtbxDescription.setText("");
                    comboSkills.setModel(new DefaultComboBoxModel(RangerSkills));
                    SetSkills();
                }
                else if("Assassin".equals(selectedClass))
                {
                    txtbxDescription.setText("");
                    comboSkills.setModel(new DefaultComboBoxModel(AssassinSkills));
                    SetSkills();
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
                if(comboSkills.getItemCount() > 0)
                {
                    SetSkills();
                }
                //System.out.println(Skill);
                
            }
        };
        
        //set listeners
        comboRole.addItemListener(roleListener);
        comboClass.addItemListener(classListener);
        comboSkills.addItemListener(skillListener);        
        
   }
    
    public void SetSkills()
    {
        Skill1 = comboSkills.getItemAt(1).toString();
        Skill2 = comboSkills.getItemAt(2).toString();
        Skill3 = comboSkills.getItemAt(3).toString();
        Skill4 = comboSkills.getItemAt(4).toString();
    }
    
    public void checkValid()
    {
        if(Role.equals("") || Role == null)
        {
            error = "You must Select a Role";
        }
        else if(Class.equals("") || Class == null)        
        {
            error = "You must Select a Class";
        }
        else if(Skill1.equals("") || Skill1 == null)
        {
            error = "Error Adding Skill 1";
        }
        else if(Skill2.equals("") || Skill2 == null)
        {
            error = "Error Adding Skill 2";
        }
        else if(Skill3.equals("") || Skill3 == null)
        {
             error = "Error Adding Skill 3";
        }
        else if(Skill4.equals("") || Skill4 == null)
        {
            error = "Error Adding Skill 4";
        }
        else
        {
            isValid = true;
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
    public String getPlayerSkill1()
        {   
            return Skill1;
        }
    public String getPlayerSkill2()
        {   
            return Skill2;
        }
    public String getPlayerSkill3()
        {   
            return Skill3;
        }
    public String getPlayerSkill4()
        {   
            return Skill4;
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
    
  public void resetSelection()
    {
        comboClass.removeAllItems(); // removes previous selection from combobox
        comboSkills.removeAllItems(); // removes previous skill selection
        txtbxDescription.setText("");
    }  
  
  //<editor-fold //<editor-fold defaultstate="collapsed" desc="ActionLiseners for done button">
        public class Event implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource() == btnDone)
                {
                    checkValid(); 
                    if (isValid == true)
                    {
                        TabGUI.comboSelection.add(new ComboSelection(Role, Class, Skill1, Skill2, Skill3, Skill4));
                        isValid = false;
                        TabGUI.activateStatPanel();
                        TabGUI.disableClassPanel();
                        TabGUI.FowardStatPanel();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(btnDone, error);
                    }
                }
            }
        }
        
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
    String[] BardSkills = {"", "Throw Dagger", "Song of Inspiration", "Song of Renewal", "Fascinate"};
    //Arrays for Damage Skills
    String[] SwashSkills = {"", "Repose", "Dirty Trick", "Pistol Shot", "Pillage"};
    String[] ThiefSkills = {"", "Back Stab", "Poison", "Stealth", "Steal"};
    String[] RangerSkills = {"", "Aimed Shot", "Bow Strike", "Arrow Stab", "Rain of Arrows"};
    String[] AssassinSkills = {"", "Garrote", "Throwing Knife", "Kidney Stab", "Assassinate"};
    
    String[] empty = {""};
    //</editor-fold>
}
