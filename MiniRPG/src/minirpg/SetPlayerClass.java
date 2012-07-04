/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minirpg;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
    
    //Set up veribles for class, skill, and description
    String SelectedSkill;
    String SkillDiscription;
    
    public void readfile()
    {
        try{
  // Open the file that is first 
  // command line parameter
            FileInputStream fstream = new FileInputStream("src/SkillsDiscriptions.txt");
  // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
  //Read File Line By Line
  while ((strLine = br.readLine()) != null)   {
  // Print the content on the console
          if(strLine.equals(SelectedSkill)){
             SkillDiscription = br.readLine();
          }
  }
  //Close the input stream
  in.close();
    }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
    }
    
    
       
    
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
    ArrayList WizardSkills = new ArrayList();
    {
        WizardSkills.add("Fireball");
        WizardSkills.add("Magic Missle");
        WizardSkills.add("Lightning Bolt");
        WizardSkills.add("Frost Shard");
    }
    ArrayList DruidSkills = new ArrayList();
    {
        DruidSkills.add("Entanglement");
        DruidSkills.add("Summon Dire Wolf");
        DruidSkills.add("Natures Touch");
        DruidSkills.add("Wild Shape");
    }
    ArrayList WarlockSkills = new ArrayList();
    {
        WarlockSkills.add("Shadow Bolt");
        WarlockSkills.add("Summon Demon");
        WarlockSkills.add("Fear");
        WarlockSkills.add("Drain Life");
    }
    ArrayList PyroSkills = new ArrayList();
    {
        PyroSkills.add("Fire Blast");
        PyroSkills.add("Blaze");
        PyroSkills.add("Incinerate");
        PyroSkills.add("Mind Fire");
    }
    
    //Arrays for Healer Skills
    ArrayList ClaricSkills = new ArrayList();
    {
        ClaricSkills.add("Holy Bash");
        ClaricSkills.add("Prayer");
        ClaricSkills.add("Holy Aura");
        ClaricSkills.add("Divine Intervention");
    }
    ArrayList PriestSkills = new ArrayList();
    {
        PriestSkills.add("Heal Target");
        PriestSkills.add("Holy Fire");
        PriestSkills.add("Heal All");
        PriestSkills.add("Act of GOD"); //possible expansion where player can choose god giving this skill different effects
    }
    ArrayList ShamanSkills = new ArrayList();
    {
        ShamanSkills.add("Curse");
        ShamanSkills.add("Heal");
        ShamanSkills.add("Protection");
        ShamanSkills.add("Summon Ethereal Weapon");        
    }
    ArrayList BardSkills = new ArrayList();
    {
        BardSkills.add("Throw Dagger");
        BardSkills.add("Song of Inspiration");
        BardSkills.add("Song of Renewal");
        BardSkills.add("Facinate");
    }
    
    //Arrays for Damage Skills
    ArrayList SwashSkills = new ArrayList();
    {
        SwashSkills.add("Repose");
        SwashSkills.add("Pistol Shot");
        SwashSkills.add("Dirty Trick");
        SwashSkills.add("Pillage");
    }
    ArrayList ThiefSkills = new ArrayList();
    {
        ThiefSkills.add("Back Stab");
        ThiefSkills.add("Poison");
        ThiefSkills.add("Stealth");
        ThiefSkills.add("Steal");
    }
    ArrayList RangerSkills = new ArrayList();
    {
        RangerSkills.add("Targeted Shot");
        RangerSkills.add("Bow Strike");
        RangerSkills.add("Arrow Stab");
        RangerSkills.add("Rain of Arrows");
    }
    ArrayList AssassinSkills = new ArrayList();
    {
        AssassinSkills.add("Garrote");
        AssassinSkills.add("Throwing Knife");
        AssassinSkills.add("Kidney Stab");
        AssassinSkills.add("Assassinate");
    }
    
    
    
}
