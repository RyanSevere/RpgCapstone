/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minirpg;

import java.io.*;
import java.util.ArrayList;


/**
 *this class is not going to end up being used
 * 
 * @author LordShadow
 */
public class PlayerClassArrays {
    
    //Skill Description variables
    String SelectedSkill; //where the selected skill will go for the file read function
    String SkillDescription; //where the description from the file will be stored for output
    
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
    
             
    //Declare array for Player Names, Role, Class, and skill
    ArrayList<Player> players = new ArrayList<Player>();
    Player player;
    
    //Declare Array for Roles
    String[] roles = {"", "Tank", "Healer", "Caster", "Damage"};
//    ArrayList roles = new ArrayList();
//    {
//           
//        roles.add("Tank");
//        roles.add("Healer");
//        roles.add("Caster");
//        roles.add("Damage");
//    }
    
    //Array for Tank Classes
    String[] TankClass = {"", "Barbarian", "Monk", "Paladin", "Warrior"};
   
//    ArrayList TankClass = new ArrayList();
//    {
//        TankClass.add("Barbarain");
//        TankClass.add("Monk");
//        TankClass.add("Paladin");
//        TankClass.add("Warrior");
//    }
    //Array for Healer Classes
    String[] HealerClass = {"", "Claric", "Priest", "Shaman", "Bard"};
    
//    ArrayList HealerClass = new ArrayList();
//    {
//        HealerClass.add("Claric");
//        HealerClass.add("Priest");
//        HealerClass.add("Shaman");
//        HealerClass.add("Bard");
//    }
//    //Array for Caster Classes
    String[] CasterClass = {"", "Wizard", "Druid", "Warlock", "Pyromancer"};
//    ArrayList CasterClass = new ArrayList();
//    {
//        CasterClass.add("Wizard");
//        CasterClass.add("Druid");
//        CasterClass.add("Warlock");
//        CasterClass.add("Pyromancer");
//    }
//    //Array for Damage Classes
    String[] DpsClass = {"", "Swashbuckler", "Thief", "Ranger", "Assassin"};
//    ArrayList DpsClass = new ArrayList();
//    {
//        DpsClass.add("Swashbuckler");
//        DpsClass.add("Thief");
//        DpsClass.add("Ranger");
//        DpsClass.add("Assassin");
//    }
//    
//    //arrays for tank class skills
    String[] BarbaianSkills = {"", "Rush", "Rage", "Spin", "KnockBack"};
    String[] MonkSkills = {"", "Focus Strike", "Meditate", "Stun", "Roundhouse"};
    String[] PaladinSkills = {"", "Lay on Hands", "Banish", "Holy Strike", "Righteous Rage"};
    String[] WarriorSkills = {"", "Shield Bash", "Tactical Strike", "Power Attack", "Rally"};
//    ArrayList BarbaianSkills = new ArrayList();
//    {
//        BarbaianSkills.add("Rush");
//        BarbaianSkills.add("Rage");
//        BarbaianSkills.add("Spin");
//        BarbaianSkills.add("knockBack");
//                
//    }
//    
//    ArrayList MonkSkills = new ArrayList();
//    {
//        MonkSkills.add("Meditate");
//        MonkSkills.add("Focus Strike");
//        MonkSkills.add("Stun");
//        MonkSkills.add("Roundhouse");
//    }
//    
//    ArrayList PaladinSkills = new ArrayList();
//    {
//        PaladinSkills.add("Lay on Hands");
//        PaladinSkills.add("Banish");
//        PaladinSkills.add("Holy Strike");
//        PaladinSkills.add("Righteous Rage");
//    }
//    
//    ArrayList WarriorSkills = new ArrayList();
//    {
//        WarriorSkills.add("Sheild Bash");
//        WarriorSkills.add("Tactical Strike");
//        WarriorSkills.add("Power Attack");
//        WarriorSkills.add("Rally");
//    }
//    
//    //Arrays for Caster Skills
    String[] WizardSkills = {"", "FireBall", "Magic Missle", "Lightning Bolt", "Frost Shard"};
    String[] DruidSkills = {"", "Entanglement", "Natures Touch", "Summon Dire Wolf", "Wild Shape"};
    String[] WarlockSkills = {"", "Shadow Bolt", "Fear", "Drain Life", "Summon Demon"};
    String[] PyroSkills = {"", "Fire Blast", "Blaze", "Incinerate", "Mind Fire"};
//    ArrayList WizardSkills = new ArrayList();
//    {
//        WizardSkills.add("Fireball");
//        WizardSkills.add("Magic Missle");
//        WizardSkills.add("Lightning Bolt");
//        WizardSkills.add("Frost Shard");
//    }
//    ArrayList DruidSkills = new ArrayList();
//    {
//        DruidSkills.add("Entanglement");
//        DruidSkills.add("Summon Dire Wolf");
//        DruidSkills.add("Natures Touch");
//        DruidSkills.add("Wild Shape");
//    }
//    ArrayList WarlockSkills = new ArrayList();
//    {
//        WarlockSkills.add("Shadow Bolt");
//        WarlockSkills.add("Summon Demon");
//        WarlockSkills.add("Fear");
//        WarlockSkills.add("Drain Life");
//    }
//    ArrayList PyroSkills = new ArrayList();
//    {
//        PyroSkills.add("Fire Blast");
//        PyroSkills.add("Blaze");
//        PyroSkills.add("Incinerate");
//        PyroSkills.add("Mind Fire");
//    }
//    
    //Arrays for Healer Skills
    String[] ClaricSkills = {"", "Holy Bash", "Prayer", "Holy Aura", "Divine Intervention"};
    String[] PriestSkills = {"", "Heal Target", "Holy Fire", "Heal All", "Act of GOD"};
    String[] ShamanSkills = {"", "Curse", "Heal", "Protection", "Summon Ethereal Weapon"};
    String[] BardSkills = {"", "Throw Dagger", "Song of Inspiration", "Song of Renewal", "Facinate"};
//    ArrayList ClaricSkills = new ArrayList();
//    {
//        ClaricSkills.add("Holy Bash");
//        ClaricSkills.add("Prayer");
//        ClaricSkills.add("Holy Aura");
//        ClaricSkills.add("Divine Intervention");
//    }
//    ArrayList PriestSkills = new ArrayList();
//    {
//        PriestSkills.add("Heal Target");
//        PriestSkills.add("Holy Fire");
//        PriestSkills.add("Heal All");
//        PriestSkills.add("Act of GOD"); //possible expansion where player can choose god giving this skill different effects
//    }
//    ArrayList ShamanSkills = new ArrayList();
//    {
//        ShamanSkills.add("Curse");
//        ShamanSkills.add("Heal");
//        ShamanSkills.add("Protection");
//        ShamanSkills.add("Summon Ethereal Weapon");        
//    }
//    ArrayList BardSkills = new ArrayList();
//    {
//        BardSkills.add("Throw Dagger");
//        BardSkills.add("Song of Inspiration");
//        BardSkills.add("Song of Renewal");
//        BardSkills.add("Facinate");
//    }
//    
    //Arrays for Damage Skills
    String[] SwashSkills = {"", "Repose", "Dirty Trick", "Pistol Shot", "Pillage"};
    String[] ThiefSkills = {"", "Back Stab", "Poison", "Stealth", "Steal"};
    String[] RangerSkills = {"", "Aimed Shot", "Bow Strike", "Arrow Stab", "Rain of Arrows"};
    String[] AssassinSkills = {"", "Garrote", "Throwing Knife", "Kidney Stab", "Assassinate"};
//    ArrayList SwashSkills = new ArrayList();
//    {
//        SwashSkills.add("Repose");
//        SwashSkills.add("Pistol Shot");
//        SwashSkills.add("Dirty Trick");
//        SwashSkills.add("Pillage");
//    }
//    ArrayList ThiefSkills = new ArrayList();
//    {
//        ThiefSkills.add("Back Stab");
//        ThiefSkills.add("Poison");
//        ThiefSkills.add("Stealth");
//        ThiefSkills.add("Steal");
//    }
//    ArrayList RangerSkills = new ArrayList();
//    {
//        RangerSkills.add("Targeted Shot");
//        RangerSkills.add("Bow Strike");
//        RangerSkills.add("Arrow Stab");
//        RangerSkills.add("Rain of Arrows");
//    }
//    ArrayList AssassinSkills = new ArrayList();
//    {
//        AssassinSkills.add("Garrote");
//        AssassinSkills.add("Throwing Knife");
//        AssassinSkills.add("Kidney Stab");
//        AssassinSkills.add("Assassinate");
//    }
    
    
    
}
