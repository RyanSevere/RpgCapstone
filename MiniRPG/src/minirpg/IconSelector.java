/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minirpg;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author LordShadow
 */
public class IconSelector {
    
    ImageIcon Player1Icon = new ImageIcon();
    ImageIcon Player2Icon = new ImageIcon();
    ImageIcon Player3Icon = new ImageIcon();
    ImageIcon Player4Icon = new ImageIcon();
    ImageIcon Orc = new ImageIcon("Icon-Orc.png");
    ImageIcon Ogre = new ImageIcon("Icon-Ogre.png");
    ImageIcon Goblin = new ImageIcon("Icon-Goblin.png");
    
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
