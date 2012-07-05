/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minirpg;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author LordShadow
 */
public class TabGUI extends JFrame {
    
    //creates tabbed pane for tabs to attach to
    JTabbedPane jtp = new JTabbedPane();
    
    //declare panels to create tabs
    PlayerClassPanel PCP = new PlayerClassPanel();
    PlayerSummeryPanel PSUMP = new PlayerSummeryPanel();
    SetPlayerInfo PSP = new SetPlayerInfo();
    
    public TabGUI()
    {
        Container canvas = getContentPane();  //declare the container to hold the tabs/panels
        canvas.add(jtp);
        
        //add the panels to frames container
        jtp.addTab("Player Class", null, PCP, "Class Selection");
        jtp.addTab("Player Stat", null, PSP, "Player Stats");
        jtp.addTab("Player Summery", null, PSUMP, "Summery");
        
        this.setSize(325, 355);
        this.setTitle("Player Creation");
        this.setVisible(true);
                
        
    }
    
}
