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
    
    String SelectedSkill = "";
    int Range;
    int Damage;
    int Heal;
    int DefenseBoost;
    int DefenseReduction;
    int DamageBoost;
    boolean IfStuned;
    int StunDuration;
    String TextOutput;
    
    public SkillAttacks()
    {
        //<editor-fold defaultstate="collapsed" desc="Tank Skills">
        //<editor-fold defaultstate="collapsed" desc="Barbarian Skills">
        if(SelectedSkill.equals("Rush"))
        {
            Rush();
        }
        else if(SelectedSkill.equals("Rage"))
        {
            Rage();   
        }
        else if(SelectedSkill.equals("Spin"))
        {
            Spin();
        }
        else if(SelectedSkill.equals("KnockBack"))
        {
            KnockBack();
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Monk Skills">
        else if(SelectedSkill.equals("Focus Strike"))
        {
            FocusStrike();
        }
        else if(SelectedSkill.equals("Meditate"))
        {
            Meditate();
        }
        else if(SelectedSkill.equals("Stun"))
        {
            Stun();
        }
        else if(SelectedSkill.equals("Roundhouse"))
        {
            Roundhouse();
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Paladin Skills">
        else if(SelectedSkill.equals("Lay on Hands"))
        {
            LayOnHands();
        }
        else if(SelectedSkill.equals("Banish"))
        {
            Banish();
        }
        else if(SelectedSkill.equals("Holy Strike"))
        {
            HolyStrike();
        }
        else if(SelectedSkill.equals("Righteous Rage"))
        {
            RighteousRage();
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Warrior Skills">
        else if(SelectedSkill.equals("Shield Bash"))
        {
            ShieldBash();
        }
        else if(SelectedSkill.equals("Tactical Strike"))
        {
            TacticalStrike();
        }
        else if(SelectedSkill.equals("Power Attack"))
        {
            PowerAttack();
        }
        else if(SelectedSkill.equals("Rally"))
        {
            Rally();
        }
        //</editor-fold>
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Caster Skills">
        //<editor-fold defaultstate="collapsed" desc="Wizard Skills">
        else if(SelectedSkill.equals("Fireball"))
        {
            Fireball();
        }
        else if(SelectedSkill.equals("Magic Missile"))
        {
            MagicMissle();
        }
        else if(SelectedSkill.equals("Lightning Bolt"))
        {
            LightningBolt();
        }
        else if(SelectedSkill.equals("Frost Shard"))
        {
            FrostShard();
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Druid Skills">
        else if(SelectedSkill.equals("Entanglement"))
        {
            Entanglement();
        }
        else if(SelectedSkill.equals("Natures Touch"))
        {
            NaturesTouch();
        }
        else if(SelectedSkill.equals("Summon Dire Wolf"))
        {
            SummonDireWolf();
        }
        else if(SelectedSkill.equals("Wild Shape"))
        {
            WildShape();
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Warlock Skills">
        else if(SelectedSkill.equals("Shadow Bolt"))
        {
            ShadowBolt();
        }
        else if(SelectedSkill.equals("Fear"))
        {
            Fear();
        }
        else if(SelectedSkill.equals("Drain Life"))
        {
            DrainLife();
        }
        else if(SelectedSkill.equals("Summon Demon"))
        {
            SummonDemon();
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Pyromancer Skills">
        else if(SelectedSkill.equals("Fire Blast"))
        {
            FireBlast();
        }
        else if(SelectedSkill.equals("Blaze"))
        {
            Blaze();
        }
        else if(SelectedSkill.equals("Incinerate"))
        {
            Incinerate();
        }
        else if(SelectedSkill.equals("Mind Fire"))
        {
            MindFire();
        }
        //</editor-fold>
        //</editor-fold>
        
        //<editor-fold defaultstate="Collapsed" desc="healer Skills">
        //<editor-fold defaultstate="collapsed" desc="Cleric Skills"> 
        else if(SelectedSkill.equals("Holy Bash"))
        {
            HolyBash();
        }
        else if(SelectedSkill.equals("Prayer"))
        {
            Prayer();
        }
        else if(SelectedSkill.equals("Holy Aura"))
        {
            HolyAura();
        }
        else if(SelectedSkill.equals("Divine Intervention"))
        {
            DivineIntervention();
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Priest Skills">
        else if(SelectedSkill.equals("Heal Target"))
        {
            HealTarget();
        }
        else if(SelectedSkill.equals("Holy Fire"))
        {
            HolyFire();
        }
        else if(SelectedSkill.equals("Heal All"))
        {
            HealAll();
        }
        else if(SelectedSkill.equals("Act of GOD"))
        {
            ActOfGOD();
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Shaman Skills">
        else if(SelectedSkill.equals("Curse"))
        {
            Curse();
        }
        else if(SelectedSkill.equals("Heal"))
        {
            Heal();
        }
        else if(SelectedSkill.equals("Protection"))
        {
            Protection();
        }
        else if(SelectedSkill.equals("Magic Weapon"))
        {
            MagicWeapon();
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Bard Skills">
        else if(SelectedSkill.equals("Throw Dagger"))
        {
            ThrowDagger();
        }
        else if(SelectedSkill.equals("Song of Inspiration"))
        {
            Inspiration();
        }
        else if(SelectedSkill.equals("Song of Renewal"))
        {
            Renewal();
        }
        else if(SelectedSkill.equals("Fascinate"))
        {
            Fascinate();
        }
        //</editor-fold>
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Damage Skills">
        //<editor-fold defaultstate="collapsed" desc="Swashbuckler Skills">
        else if(SelectedSkill.equals("Repose"))
        {
            Repose();
        }
        else if(SelectedSkill.equals("Dirty Trick"))
        {
            DirtyTrick();
        }
        else if(SelectedSkill.equals("Pistol Shot"))
        {
            PistolShot();
        }
        else if(SelectedSkill.equals("Pillage"))
        {
            Pillage();
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Thief Skills"> 
        else if(SelectedSkill.equals("Back Stab"))
        {
            BackStab();
        }
        else if(SelectedSkill.equals("Poison"))
        {
            Poison();
        }
        else if(SelectedSkill.equals("Stealth"))
        {
            Stealth();
        }
        else if(SelectedSkill.equals("Steal"))
        {
            Steal();
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Ranger Skills">
        else if(SelectedSkill.equals("Aimed Shot"))
        {
            AimedShot();
        }
        else if(SelectedSkill.equals("Bow Strike"))
        {
            BowStrike();
        }
        else if(SelectedSkill.equals("Arrow Stab"))
        {
            ArrowStab();
        }
        else if(SelectedSkill.equals("Rain of Arrows"))
        {
            RainofArrows();
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Assassin Skills">
        else if(SelectedSkill.equals("Garrote"))
        {
            Garrote();
        }
        else if(SelectedSkill.equals("Throwing Knife"))
        {
            ThrowingKnife();
        }
        else if(SelectedSkill.equals("Kidney Stab"))
        {
            KidneyStab();
        }
        else if(SelectedSkill.equals("Assassinate"))
        {
            Assassinate();
        }
        //</editor-fold>
        //</editor-fold>
    }
    
    //<editor-fold defaultstate="collapsed" desc="Tank Skill Functions">
    //<editor-fold defaultstate="collapsed" desc="Barbarian Skill Functions">
    public void Rush()
    {
        //needs movement limitor set up to allow for additional movements
        ReadFile();
    }
    
    public void Rage()
    {
        ReadFile();
    }
    
    public void Spin()
    {
        ReadFile();
    }
    
    public void KnockBack()
    {
        ReadFile();
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
    public void ShieldBash()
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
    public void Fireball()
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
    
    public void ShadowBolt()
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
    
    public void ArrowStab()
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
    
    public void StunFunction()
    {
        
    }
    
    public void ReadFile() //works
    {
        SelectedSkill = Battle.GetSelectedSkill();
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
                        Range = Integer.parseInt(reader.readLine());
                        Damage = Integer.parseInt(reader.readLine());
                        Heal = Integer.parseInt(reader.readLine());
                        DefenseBoost = Integer.parseInt(reader.readLine());
                        DamageBoost = Integer.parseInt(reader.readLine());
                        DefenseReduction = Integer.parseInt(reader.readLine());
                        IfStuned = Boolean.getBoolean(reader.readLine());
                        StunDuration = Integer.parseInt(reader.readLine());
                        TextOutput = reader.readLine();
                        
                    }
                }
                //close the input stream
                input.close();
            }
            catch (Exception e) 
            {
                System.err.println("Error: "+ e.getMessage());        
            }
        
        /*  data layout
            name
            Range
            Damage fixed
            Heal %
            Defense boost %
            Damage boost %
            Defense Reduction %
            if stuns 
            stun duration
            text output
         */
        
    }
    
    public void TestFileRead()
    {
        System.out.println(SelectedSkill);
        System.out.println(Range);
        System.out.println(Damage);
        System.out.println(Heal);
        System.out.println(DefenseBoost + "%");
        System.out.println(DamageBoost + "%");
        System.out.println(DefenseReduction + "%");
        System.out.println(IfStuned);
        System.out.println(StunDuration);
        System.out.println(TextOutput);
    }
}



