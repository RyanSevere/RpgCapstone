/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minirpg;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author LordShadow
 */
public class SetPlayerClass extends JFrame {
    //establish Buttons, Drop boxes, Labels
    JButton btndone, btnadd;
    JLabel lblclass, lblrole, lblname, lblskills, lbldiscriptionheader, lblDescription;
    JTextField TxtFieldName;
    JComboBox lstbxClass, lstbxRole, lstbxName, lstbxSkills;
    String PlayerName = "";
    
    //Declare array for Player Names, Role, Class, and skill
    ArrayList<Player> players = new ArrayList<Player>();
    Player player;
    
    //Declare Array for Roles
    ArrayList roles = new ArrayList();
    {
           
        roles.add("Tank");
        roles.add("Healer");
        roles.add("Caster");
        roles.add("Damage");
    }
    
    //Array for Tank Classes
    ArrayList TankClass = new ArrayList();
    {
        TankClass.add("Barbarain");
        TankClass.add("Monk");
        TankClass.add("Paladin");
        TankClass.add("Warrior");
    }
    //Array for Healer Classes
    ArrayList HealerClass = new ArrayList();
    {
        HealerClass.add("Claric");
        HealerClass.add("Priest");
        HealerClass.add("Shaman");
        HealerClass.add("Bard");
    }
    //Array for Caster Classes
    ArrayList CasterClass = new ArrayList();
    {
        CasterClass.add("Wizard");
        CasterClass.add("Druid");
        CasterClass.add("Warlock");
        CasterClass.add("Pyromancer");
    }
    //Array for Damage Classes
    ArrayList DpsClass = new ArrayList();
    {
        DpsClass.add("Swashbuckler");
        DpsClass.add("Thief");
        DpsClass.add("Ranger");
        DpsClass.add("Assassin");
    }
    
    //arrays for tank class skills
    ArrayList BarbaianSkills = new ArrayList();
    {
        BarbaianSkills.add("Rush");
        BarbaianSkills.add("Rage");
        BarbaianSkills.add("Spin");
        BarbaianSkills.add("knockBack");
                
    }
    
    ArrayList MonkSkills = new ArrayList();
    {
        MonkSkills.add("Meditate");
        MonkSkills.add("Focus Strike");
        MonkSkills.add("Stun");
        MonkSkills.add("Roundhouse");
    }
    
    ArrayList PaladinSkills = new ArrayList();
    {
        PaladinSkills.add("Lay on Hands");
        PaladinSkills.add("Banish");
        PaladinSkills.add("Holy Strike");
        PaladinSkills.add("Righteous Rage");
    }
    
    ArrayList WarriorSkills = new ArrayList();
    {
        WarriorSkills.add("Sheild Bash");
        WarriorSkills.add("Tactical Strike");
        WarriorSkills.add("Power Attack");
        WarriorSkills.add("Rally");
    }
    
    //Arrays for Caster Skills
    
}
