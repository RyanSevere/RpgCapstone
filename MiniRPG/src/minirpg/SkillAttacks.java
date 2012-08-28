//Created by Ryan Severe and Sean Forman
package minirpg;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Shadow
 */
public class SkillAttacks{
    
    String SelectedSkill = "", FileText;
    static String TextOutput;
    int Range, Damage, CurrentDamage, MaxDamage, StunDuration, StunCount, ModifyedHp, 
            CurrentHp, MaxHp, Target, SelectedPlayer = Battle.getSelectedPlayer(), Self;
    double Heal, DefenseBoost, DefenseReduction, DamageBoost, CurrentDefense, MaxDefense;
    boolean IfStuned, CurrentStunStatus, inRange, validTarget;
    static boolean skillSuccessful = false;
    
    public void SkillAttacks ()
    {
        SelectedSkill = Battle.Skill;
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
        Self = Battle.getPlayerSelf();
        MiniRPG.players.get(Self).setMoves(MiniRPG.players.get(Self).getMoves() + 1);
        Target = Battle.GetSelectedMonster();
        MiniRPG.players.get(Self).setDamage(Damage);
        TextOutput = FileText;
        skillSuccessful = true;
    }
    
    public void Rage()
    {
        ReadFile();
        Self = Battle.getPlayerSelf();
        DamageBoost();
        DefenseRdn();
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
        Target = Battle.GetSelectedMonster();
        inRange = Battle.CheckMeleeRange();
        CheckTarget();
        if(validTarget == true)
        {
            Damage();
        }
    }
    
    public void Stun()
    {
        ReadFile();
        Target = Battle.GetSelectedMonster();
        inRange = Battle.CheckMeleeRange();
        CheckTarget();
        if(validTarget == true)
        {
            MakeStunned();
        }
        
                  
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
        Target = Battle.getSelectedPlayer();
        inRange = Battle.CheckMeleeRange();
        if(inRange == true || Target == Battle.getPlayerSelf())
        {
            HealFcn();
            skillSuccessful = true;
        }
        else 
        {
            TextOutput = "You must get closer to heal that target";
            skillSuccessful = false;
        }    

    }
    
    public void Banish()
    {
        ReadFile();
    }
    
    public void HolyStrike()
    {
        ReadFile();
        Target = Battle.GetSelectedMonster();
        inRange = Battle.CheckMeleeRange();
        CheckTarget();
        if(validTarget == true)
        {
            Damage();
        }
    }
    
    public void RighteousRage()
    {
        ReadFile();
        Self = Battle.getPlayerSelf();
        DamageBoost();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Warior Skill Functions">
    public void ShieldBash()
    {
        ReadFile();
        Target = Battle.GetSelectedMonster();
        inRange = Battle.CheckMeleeRange();
        CheckTarget();
        if(validTarget == true)
        {
            Damage();
            if(skillSuccessful == true)
            {
                MakeStunned();
            }
        }
        
        
    }
    
    public void TacticalStrike()
    {
        ReadFile();
        Target = Battle.GetSelectedMonster();
        inRange = Battle.CheckMeleeRange();
        CheckTarget();
        if(validTarget == true)
        {
            Damage();
        }
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
        Target = Battle.getSelectedPlayer();
        CheckTarget();
        if(validTarget == true)
        {
            HealFcn();
        }
    }
    
    public void HolyBash()
    {
        ReadFile();
        inRange = Battle.CheckMeleeRange();
        Target = Battle.GetSelectedMonster();
        CheckTarget();
        if(validTarget == true)
        {
            Damage();
        }
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
        Target = Battle.getSelectedPlayer();
        CheckTarget();
        if(validTarget == true)
        {
            HealFcn();
        }
    }
    
    public void HealAll()
    {
        ReadFile();
        int count = 0;
        while(MiniRPG.players.size() <= count)
        {
            Target = count;
            HealFcn();
            count ++;
        }
        
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
        Target = Battle.getSelectedPlayer();
        CheckTarget();
        if(validTarget == true)
        {
            HealFcn();
        }
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
        int count = 0;
        while(MiniRPG.players.size() <= count)
        {
            Target = count;
            MiniRPG.players.get(Target).setMoves(MiniRPG.players.get(Target).getMoves() + 2);
            count ++;
        }
    }
    
    public void Renewal()
    {
        ReadFile();
        int count = 0;
        while(MiniRPG.players.size() <= count)
        {
            Target = count;
            HealFcn();
            count ++;
        }
    }
    
    public void ThrowDagger()
    {
        ReadFile();
        Target = Battle.GetSelectedMonster();
        if(Target != -1)
        {
            inRange = Battle.rangedAttack(Range);
            Damage();
        }
        else
        {
            TextOutput = "You Must Select a Target";
            skillSuccessful = false;
        }
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
        Target = Battle.GetSelectedMonster();
        inRange = Battle.rangedAttack(Range);
        CheckTarget();
        if(validTarget == true)
        {
            Damage();
        }
        
    }
    
    public void MagicMissle()
    {
        ReadFile();
        Target = Battle.GetSelectedMonster();
        inRange = Battle.rangedAttack(Range);
        CheckTarget();
        if(validTarget == true)
        {
            Damage();
        }
    }
    
    public void LightningBolt()
    {
        ReadFile();
        Target = Battle.GetSelectedMonster();
        inRange = Battle.rangedAttack(Range);
        CheckTarget();
        if(validTarget == true)
        {
            Damage();
        }
        if(skillSuccessful == true)
        {
            MakeStunned();
        }
    }
    
    public void FrostShard()
    {
        ReadFile();
        Target = Battle.GetSelectedMonster();
        inRange = Battle.rangedAttack(Range);
        CheckTarget();
        if(validTarget == true)
        {
            Damage();
        }
        if(skillSuccessful == true)
        {
            MakeStunned();
        }
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
        Target = Battle.GetSelectedMonster();
        inRange = Battle.rangedAttack(Range);
        CheckTarget();
        if(validTarget == true)
        {
            Damage();
        }
    }
    
    public void Fear()
    {
        ReadFile();
        Target = Battle.GetSelectedMonster();
        inRange = Battle.rangedAttack(Range);
        CheckTarget();
        if(validTarget == true)
        {
            MakeStunned();
        }
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
        Target = Battle.GetSelectedMonster();
        inRange = Battle.rangedAttack(Range);
        CheckTarget();
        if(validTarget == true)
        {
            MakeStunned();
        }
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
        Target = Battle.GetSelectedMonster();
        inRange = Battle.rangedAttack(Range);
        CheckTarget();
        if(validTarget == true)
        {
            Damage();
        }
    }
    
    public void Blaze()
    {
        ReadFile();
    }
    
    public void Incinerate()
    {
        ReadFile();
        Target = Battle.GetSelectedMonster();
        inRange = Battle.rangedAttack(Range);
        CheckTarget();
        if(validTarget == true)
        {
            Damage();
        }
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
        Target = Battle.GetSelectedMonster();
        inRange = Battle.rangedAttack(Range);
        CheckTarget();
        if(validTarget == true)
        {
            Damage();
        }
    }
    
    public void Repose()
    {
        ReadFile();
        Self = Battle.getPlayerSelf();
        DefenseBoost();
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
        inRange = Battle.CheckMeleeRange();
        Target = Battle.GetSelectedMonster();
        CheckTarget();
        if(validTarget == true)
        {
            Damage();
        }
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
        Target = Battle.GetSelectedMonster();
        inRange = Battle.rangedAttack(Range);
        CheckTarget();
        if(validTarget == true)
        {
            Damage();
        }
        
    }
    
    public void RainofArrows()
    {
        ReadFile();
    }
    
    public void BowStrike()
    {
        ReadFile();
        Target = Battle.GetSelectedMonster();
        inRange = Battle.rangedAttack(Range);
        CheckTarget();
        if(validTarget == true)
        {
            Damage();
        }
        if(skillSuccessful == true)
        {
            MakeStunned();
        }
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
        inRange = Battle.CheckMeleeRange();
        Target = Battle.GetSelectedMonster();
        inRange = Battle.rangedAttack(Range);
        CheckTarget();
        if(validTarget == true)
        {
            Damage();
            if(skillSuccessful == true)
            {
                MakeStunned();
            }
        }
       
    }
    
    public void Assassinate()
    {
        ReadFile();
    }
    //</editor-fold>
    //</editor-fold>
    
    //functitions for common skill events
    public void CheckTarget()
    {
        if(Target == -1)
        {
            TextOutput = " You must select a target";
            skillSuccessful = false;
        }
        else
        {
            validTarget = true;
        }
    } 
    
    public void Damage()
    {
        System.out.println("is in Range " + inRange);
        if(inRange == true)
        {
            try {
                Battle.monsters.get(Target).setHp(Battle.monsters.get(Target).getHp() - Damage);
                TextOutput = FileText + " " + Battle.monsters.get(Target).getName() + " for " + Damage + " damage"
                         + Battle.monsters.get(Target).getName() + " is down to " + Battle.monsters.get(Target).getHp() + " health.";
                skillSuccessful = true;
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        else
        {
            TextOutput = Battle.monsters.get(Target).getName() + " is out of Range";
            skillSuccessful = false;
        }
    }
    
    public void MakeStunned()
    {
        CurrentStunStatus = MiniRPG.players.get(Target).getIsStunned();
        if(Battle.isPlayer == true)
        {
            if(CurrentStunStatus == false)
            {
                MiniRPG.players.get(Target).setIsStunned(true);
                MiniRPG.players.get(Target).setStunDuration(StunDuration);
                skillSuccessful = true;
            }
        }
        else if(Battle.isMonster == true)
        {
            if(inRange == true)
            {
                if(CurrentStunStatus == false)
                {
                    Battle.monsters.get(Target).setIsStunned(true);
                    Battle.monsters.get(Target).setStunDuration(StunDuration);
                    TextOutput = FileText + " " + Battle.monsters.get(Target).getName() + " stunning them for " + StunDuration + " rounds";
                    skillSuccessful = true;
                }
                else
                {
                    TextOutput = "Target is already Stunned";
                    skillSuccessful = false;
                }
            }
            else
            {
                TextOutput = "Target is out of Range";
                skillSuccessful = false;
            }
        }
    }
    
    public void HealFcn()
    {
        if(Battle.isPlayer == true)
        {
            CurrentHp = MiniRPG.players.get(Target).getHp();
            MaxHp = MiniRPG.players.get(Target).getMaxHp();
            int AmountHealed = (int) (MaxHp * Heal);
            System.out.println("Current HP" + CurrentHp);
            System.out.println("MaxHp" + MaxHp);
            if(CurrentHp < MaxHp)
            {
                ModifyedHp = CurrentHp + AmountHealed;
                if(ModifyedHp > MaxHp)
                {
                    MiniRPG.players.get(Target).setHp(MaxHp);
                    TextOutput = FileText + " " + MiniRPG.players.get(Target).getName() + " back to full health";
                }
                else
                {
                    MiniRPG.players.get(Target).setHp(ModifyedHp);
                    TextOutput = FileText + MiniRPG.players.get(Target).getName() + " For " + AmountHealed;
                }
                skillSuccessful = true;
            }
            else if(CurrentHp >= MaxHp)
            {
                MiniRPG.players.get(Target).setHp(MaxHp);
                TextOutput = Target + " is already at Max Health";
                skillSuccessful = false;
            }
        }
        else
        {
            TextOutput = "Invalid Target only other players can be healed";
            skillSuccessful = false;
        }
        
    }
    
    public void DefenseBoost()
    {
        CurrentDefense = MiniRPG.players.get(Self).getDefense();
        CurrentDefense = CurrentDefense + DefenseBoost;
        MiniRPG.players.get(Self).setDefense(CurrentDefense);
    }
    
    public void DamageBoost()
    {
        CurrentDamage = MiniRPG.players.get(Self).getDamage();
        int DamageBonus = (int) (CurrentDamage * DamageBoost);
        CurrentDamage = CurrentDamage + DamageBonus;
        MiniRPG.players.get(Self).setDamage(CurrentDamage);
    }
    
    public void DefenseRdn()
    {
        CurrentDefense = MiniRPG.players.get(Self).getDefense();
        CurrentDefense = CurrentDefense - DefenseBoost;
        if(CurrentDefense < 0)
        {
            CurrentDefense = 0;
            MiniRPG.players.get(Self).setDefense(CurrentDefense);
        }
        else
        {
            MiniRPG.players.get(Self).setDefense(CurrentDefense);
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
                        FileText = reader.readLine();
                        
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
    
    static String getTextOutput()
    {
        return TextOutput;
    }
    
    static boolean getSkillSuccess()
    {
        return skillSuccessful;
    }
    
}



