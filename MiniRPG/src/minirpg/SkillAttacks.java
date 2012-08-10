/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minirpg;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Shadow
 */
public class SkillAttacks {
    
    String SelectedSkill;
    
    public SkillAttacks()
    {
        //<editor-fold defaultstate="collapsed" desc="Barbarian Skills">
        if(SelectedSkill.equals("Rush"))
        {
            
        }
        else if(SelectedSkill.equals("Rage"))
        {
            
        }
        else if(SelectedSkill.equals("Spin"))
        {
            
        }
        else if(SelectedSkill.equals("KnockBack"))
        {
            
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Monk Skills">
        else if(SelectedSkill.equals("Focus Strike"))
        {
            
        }
        else if(SelectedSkill.equals("Meditate"))
        {
            
        }
        else if(SelectedSkill.equals("Stun"))
        {
            
        }
        else if(SelectedSkill.equals("Roundhouse"))
        {
            
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Paladin Skills">
        else if(SelectedSkill.equals("Lay on Hands"))
        {
            
        }
        else if(SelectedSkill.equals("Banish"))
        {
            
        }
        else if(SelectedSkill.equals("Holy Strike"))
        {
            
        }
        else if(SelectedSkill.equals("Righteous Rage"))
        {
            
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Warrior Skills">
        else if(SelectedSkill.equals("Shield Bash"))
        {
            
        }
        else if(SelectedSkill.equals("Tactical Strike"))
        {
            
        }
        else if(SelectedSkill.equals("Power Attack"))
        {
            
        }
        else if(SelectedSkill.equals("Rally"))
        {
            
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Wizard Skills">
        else if(SelectedSkill.equals("Fireball"))
        {
            
        }
        else if(SelectedSkill.equals("Magic Missile"))
        {
            
        }
        else if(SelectedSkill.equals("Lightning Bolt"))
        {
            
        }
        else if(SelectedSkill.equals("Frost Shard"))
        {
            
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Druid Skills">
        else if(SelectedSkill.equals("Entanglement"))
        {
            
        }
        else if(SelectedSkill.equals("Natures Touch"))
        {
            
        }
        else if(SelectedSkill.equals("Summon Dire Wolf"))
        {
            
        }
        else if(SelectedSkill.equals("Wild Shape"))
        {
            
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Warlock Skills">
        else if(SelectedSkill.equals("Shadow Bolt"))
        {
            
        }
        else if(SelectedSkill.equals("Fear"))
        {
            
        }
        else if(SelectedSkill.equals("Drain Life"))
        {
            
        }
        else if(SelectedSkill.equals("Summon Demon"))
        {
            
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Pyromancer Skills">
        else if(SelectedSkill.equals("Fire Blast"))
        {
            
        }
        else if(SelectedSkill.equals("Blaze"))
        {
            
        }
        else if(SelectedSkill.equals("Incinerate"))
        {
            
        }
        else if(SelectedSkill.equals("Mind Fire"))
        {
            
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Cleric Skills"> 
        else if(SelectedSkill.equals("Holy Bash"))
        {
            
        }
        else if(SelectedSkill.equals("Prayer"))
        {
            
        }
        else if(SelectedSkill.equals("Holy Aura"))
        {
            
        }
        else if(SelectedSkill.equals("Divine Intervention"))
        {
            
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Priest Skills">
        else if(SelectedSkill.equals("Heal Target"))
        {
            
        }
        else if(SelectedSkill.equals("Holy Fire"))
        {
            
        }
        else if(SelectedSkill.equals("Heal All"))
        {
            
        }
        else if(SelectedSkill.equals("Act of GOD"))
        {
            
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Shaman Skills">
        else if(SelectedSkill.equals("Curse"))
        {
            
        }
        else if(SelectedSkill.equals("Heal"))
        {
            
        }
        else if(SelectedSkill.equals("Protection"))
        {
            
        }
        else if(SelectedSkill.equals("Magic Weapon"))
        {
            
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Bard Skills">
        else if(SelectedSkill.equals("Throw Dagger"))
        {
            
        }
        else if(SelectedSkill.equals("Song of Inspiration"))
        {
            
        }
        else if(SelectedSkill.equals("Song of Renewal"))
        {
            
        }
        else if(SelectedSkill.equals("Fascinate"))
        {
            
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Swashbuckler Skills">
        else if(SelectedSkill.equals("Repose"))
        {
            
        }
        else if(SelectedSkill.equals("Dirty Trick"))
        {
            
        }
        else if(SelectedSkill.equals("Pistol Shot"))
        {
            
        }
        else if(SelectedSkill.equals("Pillage"))
        {
            
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Thief Skills"> 
        else if(SelectedSkill.equals("Back Stab"))
        {
            
        }
        else if(SelectedSkill.equals("Poison"))
        {
            
        }
        else if(SelectedSkill.equals("Stealth"))
        {
            
        }
        else if(SelectedSkill.equals("Steal"))
        {
            
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Ranger Skills">
        else if(SelectedSkill.equals("Aimed Shot"))
        {
            
        }
        else if(SelectedSkill.equals("Bow Strike"))
        {
            
        }
        else if(SelectedSkill.equals("Arrow Stab"))
        {
            
        }
        else if(SelectedSkill.equals("Rain of Arrows"))
        {
            
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Assassin Skills">
        else if(SelectedSkill.equals("Garrote"))
        {
            
        }
        else if(SelectedSkill.equals("Throwing Knife"))
        {
            
        }
        else if(SelectedSkill.equals("Kidney Stab"))
        {
            
        }
        else if(SelectedSkill.equals("Assassinate"))
        {
            
        }
        //</editor-fold>
    }
    
    //<editor-fold defaultstate="collapsed" desc="Tank Skill Functions">
    //<editor-fold defaultstate="collapsed" desc="Barbarian Skill Functions">
    public void Rush()
    {

    }
    public void Rage()
    {
        
    }
    
    public void Spin()
    {
        
    }
    
    public void KnockBack()
    {
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Monk Skill Functions">
    public void Meditate()
    {
        
    }
    
    public void FocusStrike()
    {
        
    }
    
    public void Stun()
    {
        
    }            
    
    public void Roundhouse()
    {
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Paladin Skill Functions">
    public void LayOnHands()
    {
        
    }
    
    public void Banish()
    {
        
    }
    
    public void HolyStrike()
    {
        
    }
    
    public void RighteousRage()
    {
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Warior Skill Functions">
    public void SheildBash()
    {
        
    }
    
    public void TacticalStrike()
    {
        
    }
    
    public void PowerAttack()
    {
        
    }
    
    public void Rally()
    {
        
    }
    //</editor-fold>
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Healer Skill Functions">
    //<editor-fold defaultstate="collapsed" desc="Cleric Skill Functions">
    public void DivineIntervention()
    {
        
    }
    
    public void Prayer()
    {
        
    }
    
    public void HolyBash()
    {
        
    }
    
    public void HolyAura()
    {
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Priest Skill Functions">
    public void HealTarget()
    {
        
    }
    
    public void HealAll()
    {
        
    }
    
    public void HolyFire()
    {
        
    }
    
    public void ActOfGOD()
    {
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Shaman Skill Functions">
    public void Curse()
    {
        
    }
    
    public void Heal()
    {
        
    }
    
    public void MagicWeapon()
    {
        
    }
    
    public void Protection()
    {
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Bard Skill Functions">
    public void Inspiration()
    {
        
    }
    
    public void Renewal()
    {
        
    }
    
    public void ThrowDagger()
    {
        
    }
    
    public void Fascinate()
    {
        
    }
    //</editor-fold>
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Caster Skill Functions">
    //<editor-fold defaultstate="collapsed" desc="Wizard Skill Functions">
    public void FireBall()
    {
        
    }
    
    public void MagicMissle()
    {
        
    }
    
    public void LightningBolt()
    {
        
    }
    
    public void FrostShard()
    {
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Warlock Skill Functions">
    public void SummonDemon()
    {
        
    }
    
    public void ShadowBold()
    {
        
    }
    
    public void Fear()
    {
        
    }
    
    public void DrainLife()
    {
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Druid Skill Functions">
    public void Entanglement()
    {
        
    }
    
    public void SummonDireWolf()
    {
        
    }
    
    public void NaturesTouch()
    {
        
    }
    
    public void WildShape()
    {
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Pyromancer Skill Functions">
    public void FireBlast()
    {
        
    }
    
    public void Blaze()
    {
        
    }
    
    public void Incinerate()
    {
        
    }
    
    public void MindFire()
    {
        
    }
    //</editor-fold>
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Damage Skill Functions">
    //<editor-fold defaultstate="collapsed" desc="Swashbuckler Skill Functions">
    public void PistolShot()
    {
        
    }
    
    public void Repose()
    {
        
    }
    
    public void Pillage()
    {
        
    }
    
    public void DirtyTrick()
    {
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Thief Skill Functions">
    public void BackStab()
    {
        
    }
    
    public void Stealth()
    {
        
    }
    
    public void Poison()
    {
        
    }
    
    public void Steal()
    {
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Ranger Skill Functions">
    public void AimedShot()
    {
        
    }
    
    public void RainofArrows()
    {
        
    }
    
    public void BowStrike()
    {
        
    }
    
    public void ArrowStrike()
    {
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Assassin Skill Functions">
    public void Garrote()
    {
        
    }
    
    public void ThrowingKnife()
    {
        
    }
    
    public void KidneyStab()
    {
        
    }
    
    public void Assassinate()
    {
        
    }
    //</editor-fold>
    //</editor-fold>
    
    public void GlobalStun()
    {
        
    }
    
    public void ReadFile()
    {
        
        try
            {
                //open the file
                //command line parameter
                FileInputStream fstream = new FileInputStream("src/Attackdoc.txt");
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
                        //SkillDescription = reader.readLine();
                        
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
}



