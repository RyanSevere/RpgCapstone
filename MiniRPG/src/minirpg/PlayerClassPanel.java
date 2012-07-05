/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minirpg;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JTextField txtbxName, txtbxDescription;
    JComboBox comboClass, comboRole, comboName, comboSkills;
    
    //Skill Description variables
    String SelectedSkill; //where the selected skill will go for the file read function
    String SkillDescription; //where the description from the file will be stored for output
    
       
    public PlayerClassPanel()
    {
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
        comboClass = new JComboBox(SelectedClass); //popluate based on selection from roles combo box
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
        txtbxDescription = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 3;
        c.gridwidth = 3;
        add(txtbxDescription, c);
        txtbxDescription.setEditable(false);
        
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
        
        
        PlayerClassPanel.Event a = new PlayerClassPanel.Event();
        //set listeners
        comboClass.addActionListener(a);
        comboRole.addActionListener(a);
        comboSkills.addActionListener(a);
        
    }
    
    public class Event implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent a)
        {
            
        }
    }
    
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
                    SkillDescription =reader.readLine();
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
        
    //Drop Box Arrays
    //Roles Array
    String[] roles = {"", "Tank", "Healer", "Caster", "Damage"};
    //Array for Tank Classes
    String[] TankClass = {"", "Barbarian", "Monk", "Paladin", "Warrior"};
    //Array for Healer Classes
    String[] HealerClass = {"", "Claric", "Priest", "Shaman", "Bard"};
    //Array for Caster Classes
    String[] CasterClass = {"", "Wizard", "Druid", "Warlock", "Pyromancer"};
    //Array for Damage Classes
    String[] DpsClass = {"", "Swashbuckler", "Thief", "Ranger", "Assassin"};
    
    //Skill Arrays
    //arrays for tank class skills
    String[] BarbaianSkills = {"", "Rush", "Rage", "Spin", "KnockBack"};
    String[] MonkSkills = {"", "Focus Strike", "Meditate", "Stun", "Roundhouse"};
    String[] PaladinSkills = {"", "Lay on Hands", "Banish", "Holy Strike", "Righteous Rage"};
    String[] WarriorSkills = {"", "Shield Bash", "Tactical Strike", "Power Attack", "Rally"};
    //Arrays for Caster Skills
    String[] WizardSkills = {"", "FireBall", "Magic Missle", "Lightning Bolt", "Frost Shard"};
    String[] DruidSkills = {"", "Entanglement", "Natures Touch", "Summon Dire Wolf", "Wild Shape"};
    String[] WarlockSkills = {"", "Shadow Bolt", "Fear", "Drain Life", "Summon Demon"};
    String[] PyroSkills = {"", "Fire Blast", "Blaze", "Incinerate", "Mind Fire"};
    //Arrays for Healer Skills
    String[] ClaricSkills = {"", "Holy Bash", "Prayer", "Holy Aura", "Divine Intervention"};
    String[] PriestSkills = {"", "Heal Target", "Holy Fire", "Heal All", "Act of GOD"};
    String[] ShamanSkills = {"", "Curse", "Heal", "Protection", "Summon Ethereal Weapon"};
    String[] BardSkills = {"", "Throw Dagger", "Song of Inspiration", "Song of Renewal", "Facinate"};
    //Arrays for Damage Skills
    String[] SwashSkills = {"", "Repose", "Dirty Trick", "Pistol Shot", "Pillage"};
    String[] ThiefSkills = {"", "Back Stab", "Poison", "Stealth", "Steal"};
    String[] RangerSkills = {"", "Aimed Shot", "Bow Strike", "Arrow Stab", "Rain of Arrows"};
    String[] AssassinSkills = {"", "Garrote", "Throwing Knife", "Kidney Stab", "Assassinate"};
    
    //array to fill Class Combo box with either nothing or selected class's once role is selected
    String[] SelectedClass ={"", "", "", "", "         "};
    
    
}
