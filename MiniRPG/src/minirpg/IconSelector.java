//Created by Ryan Severe and Sean Forman
package minirpg;

import javax.swing.ImageIcon;

public class IconSelector {
    
    ImageIcon PlayerIcon = new ImageIcon();
    ImageIcon Barbarian = new ImageIcon("src/Icons/Icon-Barbarian.png");
    ImageIcon Assassin = new ImageIcon("src/Icons/Icon-Assassin.png");
    ImageIcon Default = new ImageIcon("src/Icons/RedX.png");
    ImageIcon Bard = new ImageIcon("src/Icons/Icon-Bard.png");
    ImageIcon Cleric = new ImageIcon("src/Icons/Icon-Cleric.png");
    ImageIcon Druid = new ImageIcon("src/Icons/Icon-Druid.png");
    ImageIcon Monk = new ImageIcon("src/Icons/Icon-Monk.png");
    ImageIcon Paladin = new ImageIcon("src/Icons/Icon-Paladin.png");
    ImageIcon Priest = new ImageIcon("src/Icons/Icon-Priest.png");
    ImageIcon Pyromancer = new ImageIcon("src/Icons/Icon-Pyromancer.png");
    ImageIcon Ranger = new ImageIcon("src/Icons/Icon-Ranger.png");
    ImageIcon Shaman = new ImageIcon("src/Icons/Icon-Shaman.png");
    ImageIcon Swashbuckler = new ImageIcon("src/Icons/Icon-Swashbuckler.png");
    ImageIcon Thief = new ImageIcon("src/Icons/Icon-Thief.png");
    ImageIcon Warlock = new ImageIcon("src/Icons/Icon-Warlock.png");
    ImageIcon Warrior = new ImageIcon("src/Icons/Icon-Warrior.png");
    ImageIcon Wizard = new ImageIcon("src/Icons/Icon-Wizard.png");
    ImageIcon Orc = new ImageIcon("src/Icons/Icon-Orc.png");
    ImageIcon Ogre = new ImageIcon("src/Icons/Icon-Ogre.png");
    ImageIcon Goblin = new ImageIcon("src/Icons/Icon-Goblin.png");
    String PlayerClass;
    int x = 0;
    
    
    //function to set the correct icon for player based on class selection. called from Create Function in SetPlayerInfo
    public void IconSelector()
    {
        PlayerClass = TabGUI.comboSelection.get(x).getclass();
        if(PlayerClass == "" || PlayerClass == null)
        {
            PlayerIcon = Default;
        }
        else if(PlayerClass == "Barbarian")
        {
            PlayerIcon = Barbarian;
        }
        else if(PlayerClass == "Monk")
        {
            PlayerIcon = Monk;
        }
        else if(PlayerClass == "Paladin")
        {
            PlayerIcon = Paladin;
        }
        else if(PlayerClass == "Warrior")
        {
            PlayerIcon = Warrior;
        }
        else if(PlayerClass == "Cleric")
        {
            PlayerIcon = Cleric;
        }
        else if(PlayerClass == "Priest")
        {
            PlayerIcon = Priest;
        }
        else if(PlayerClass == "Shaman")
        {
            PlayerIcon = Shaman;
        }
        else if(PlayerClass == "Bard")
        {
            PlayerIcon = Bard;
        }
        else if(PlayerClass == "Wizard")
        {
            PlayerIcon = Wizard;
        }
        else if(PlayerClass == "Druid")
        {
            PlayerIcon = Druid;
        }
        else if(PlayerClass == "Warlock")
        {
            PlayerIcon = Warlock;
        }
        else if(PlayerClass == "Pyromancer")
        {
            PlayerIcon = Pyromancer;
        }
        else if(PlayerClass == "Swashbuckler")
        {
            PlayerIcon = Swashbuckler;
        }
        else if(PlayerClass == "Thief")
        {
            PlayerIcon = Thief;
        }
        else if(PlayerClass == "Ranger")
        {
            PlayerIcon = Ranger;
        }
        else if(PlayerClass == "Assassin")
        {
            PlayerIcon = Assassin;
        }
        x++;
    }
    
    public ImageIcon getPlayerIcon()
    {
        return PlayerIcon;
    }
    
    public ImageIcon getOrc()
    {
        return Orc;
    }
    
    public ImageIcon getOgre()
    {
        return Ogre;
    }
    
    public ImageIcon getGoblin()
    {
        return Goblin;
    }
    
    public void setPlayerIcon()
    {
        this.PlayerIcon = PlayerIcon;
    }
    
    public void setOrc()
    {
        this.Orc = Orc;
    }
    
    public void setOgre()
    {
        this.Ogre = Ogre;
    }
    
    public void setGoblin()
    {
        this.Goblin = Goblin;
    } 
    
    
}
