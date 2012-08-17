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
    int Range, Damage, CurrentDamage, MaxDamage, StunDuration, StunCount, 
            CurrentHp, MaxHp, Target, SelectedPlayer = Battle.GetSelectedPlayer();
    double Heal, DefenseBoost, DefenseReduction, DamageBoost, CurrentDefense, MaxDefense;
    boolean IfStuned, CurrentStunStatus, skillSucessful;
    static String TextOutput;
    
    public void SkillAttacks()
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
        ReadFile();
    }
    
    public void FocusStrike()
    {
        ReadFile();
    }
    
    public void Stun()
    {
        ReadFile();
    }            
    
    public void Roundhouse()
    {
        ReadFile();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Paladin Skill Functions">
    public void LayOnHands()
    {
        ReadFile();
    }
    
    public void Banish()
    {
        ReadFile();
    }
    
    public void HolyStrike()
    {
        ReadFile();
    }
    
    public void RighteousRage()
    {
        ReadFile();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Warior Skill Functions">
    public void ShieldBash()
    {
        ReadFile();
    }
    
    public void TacticalStrike()
    {
        ReadFile();
    }
    
    public void PowerAttack()
    {
        ReadFile();
    }
    
    public void Rally()
    {
        ReadFile();
    }
    //</editor-fold>
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Healer Skill Functions">
    //<editor-fold defaultstate="collapsed" desc="Cleric Skill Functions">
    public void DivineIntervention()
    {
        ReadFile();
    }
    
    public void Prayer()
    {
        ReadFile();
    }
    
    public void HolyBash()
    {
        ReadFile();
    }
    
    public void HolyAura()
    {
        ReadFile();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Priest Skill Functions">
    public void HealTarget()
    {
        ReadFile();
    }
    
    public void HealAll()
    {
        ReadFile();
    }
    
    public void HolyFire()
    {
        ReadFile();
    }
    
    public void ActOfGOD()
    {
        ReadFile();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Shaman Skill Functions">
    public void Curse()
    {
        ReadFile();
    }
    
    public void Heal()
    {
        ReadFile();
    }
    
    public void MagicWeapon()
    {
        ReadFile();
    }
    
    public void Protection()
    {
        ReadFile();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Bard Skill Functions">
    public void Inspiration()
    {
        ReadFile();
    }
    
    public void Renewal()
    {
        ReadFile();
    }
    
    public void ThrowDagger()
    {
        ReadFile();
    }
    
    public void Fascinate()
    {
        ReadFile();
    }
    //</editor-fold>
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Caster Skill Functions">
    //<editor-fold defaultstate="collapsed" desc="Wizard Skill Functions">
    public void Fireball()
    {
        ReadFile();
    }
    
    public void MagicMissle()
    {
        ReadFile();
    }
    
    public void LightningBolt()
    {
        ReadFile();
    }
    
    public void FrostShard()
    {
        ReadFile();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Warlock Skill Functions">
    public void SummonDemon()
    {
        ReadFile();
    }
    
    public void ShadowBolt()
    {
        ReadFile();
    }
    
    public void Fear()
    {
        ReadFile();
    }
    
    public void DrainLife()
    {
        ReadFile();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Druid Skill Functions">
    public void Entanglement()
    {
        ReadFile();
    }
    
    public void SummonDireWolf()
    {
        ReadFile();
    }
    
    public void NaturesTouch()
    {
        ReadFile();
    }
    
    public void WildShape()
    {
        ReadFile();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Pyromancer Skill Functions">
    public void FireBlast()
    {
        ReadFile();
    }
    
    public void Blaze()
    {
        ReadFile();
    }
    
    public void Incinerate()
    {
        ReadFile();
    }
    
    public void MindFire()
    {
        ReadFile();
    }
    //</editor-fold>
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Damage Skill Functions">
    //<editor-fold defaultstate="collapsed" desc="Swashbuckler Skill Functions">
    public void PistolShot()
    {
        ReadFile();
    }
    
    public void Repose()
    {
        ReadFile();
    }
    
    public void Pillage()
    {
        ReadFile();
    }
    
    public void DirtyTrick()
    {
        ReadFile();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Thief Skill Functions">
    public void BackStab()
    {
        ReadFile();
    }
    
    public void Stealth()
    {
        ReadFile();
    }
    
    public void Poison()
    {
        ReadFile();
    }
    
    public void Steal()
    {
        ReadFile();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Ranger Skill Functions">
    public void AimedShot()
    {
        ReadFile();
    }
    
    public void RainofArrows()
    {
        ReadFile();
    }
    
    public void BowStrike()
    {
        ReadFile();
    }
    
    public void ArrowStab()
    {
        ReadFile();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Assassin Skill Functions">
    public void Garrote()
    {
        ReadFile();
    }
    
    public void ThrowingKnife()
    {
        ReadFile();
    }
    
    public void KidneyStab()
    {
        ReadFile();
    }
    
    public void Assassinate()
    {
        ReadFile();
    }
    //</editor-fold>
    //</editor-fold>
        
    public void MakeStunned()
    {
        CurrentStunStatus = MiniRPG.players.get(Target).getIsStunned();
        
        if(CurrentStunStatus == false)
        {
            MiniRPG.players.get(Target).setIsStunned(true);
        }
        else
        {
            TextOutput = "Target is already Stunned";
        }
    }
    
    public void HealFcn()
    {
        CurrentHp = MiniRPG.players.get(Target).getHp();
        MaxHp = MiniRPG.players.get(Target).getMaxHp();
        int AmountHealed = (int) (MaxHp * Heal);
        CurrentHp = CurrentHp + AmountHealed;
        if(CurrentHp < MaxHp)
        {
            MiniRPG.players.get(Target).setHp(CurrentHp);
        }
        else if(CurrentHp >= MaxHp)
        {
            MiniRPG.players.get(Target).setHp(MaxHp);
            TextOutput = "Player is already at Max Health";
        }
        
    }
    
    public void DefenseBoost()
    {
        CurrentDefense = MiniRPG.players.get(Target).getDefense();
        CurrentDefense = CurrentDefense + DefenseBoost;
        MiniRPG.players.get(Target).setDefense(CurrentDefense);
    }
    
    public void DamageBoost()
    {
        CurrentDamage = MiniRPG.players.get(Target).getDamage();
        int DamageBonus = (int) (CurrentDamage * DamageBoost);
        CurrentDamage = CurrentDamage + DamageBonus;
        MiniRPG.players.get(Target).setDamage(CurrentDamage);
    }
    
    public void DefenseRdn()
    {
        CurrentDefense = MiniRPG.players.get(Target).getDefense();
        CurrentDefense = CurrentDefense - DefenseBoost;
        if(CurrentDefense < 0)
        {
            CurrentDefense = 0;
            MiniRPG.players.get(Target).setDefense(CurrentDefense);
        }
        else
        {
            MiniRPG.players.get(Target).setDefense(CurrentDefense);
        }
    }
    
    public void ReadFile() //reads the needed kill information from the AttackDoc
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
                        Heal = Double.parseDouble(reader.readLine());
                        DefenseBoost = Double.parseDouble(reader.readLine());
                        DamageBoost = Double.parseDouble(reader.readLine());
                        DefenseReduction = Double.parseDouble(reader.readLine());
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
    
    static String GetTextOutput()
    {
        return TextOutput;
    }
    
}



