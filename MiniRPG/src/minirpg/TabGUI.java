/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minirpg;

import java.awt.*;
import javax.swing.*;

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
    SingleSelectionModel model;
    int index;
    int count  = 0;
    public TabGUI()
    {
        Container canvas = getContentPane();  //declare the container to hold the tabs/panels
        canvas.add(jtp);
        
        //add the panels to frames container
        jtp.addTab("Player Class", null, PCP, "Class Selection");
        jtp.addTab("Player Stat", null, PSP, "Player Stats");
        jtp.addTab("Player Summery", null, PSUMP, "Summery");
        
        //this.setSize(325, 355);
        this.setTitle("Player Creation");
        //this.setVisible(true);
       
        
        
    }
    
    public void disableSummeryPanel()
    {
        //if(count != 1)
        //{
            jtp.setEnabledAt(2, false);
            System.out.println("DisableSummeryPanel");
            //count = 1;
        //}
        
    }
    
    public void SummerySelected()
    {
        index = jtp.getSelectedIndex();
        if(index == 3)
        {
            //where code will go to populate the combo box of players in summery panel
            System.out.println("Selected Tab is Summery");
        }
        
    }
    
    public void activateSummeryPanel()
    {
        jtp.setEnabledAt(0, true);
        jtp.setEnabledAt(1, true);
        jtp.setEnabledAt(2, true);
        //summery still wont enable
        
        System.out.println("ActivateSummyPanel has been run");
        //index = jtp.getSelectedIndex();
        System.out.println("Current tab index: " + index);
    }
    public void returntoClassPanel()
    {
        
        System.out.println("ReturntoClassPanel has been run");
        index = jtp.getSelectedIndex();
        System.out.println("Current tab index: " + index);
    }
    
    public int GetSelectedTab()
    {
        index = jtp.getSelectedIndex();
        return index;
    }
    
    private void SetSelctedTab()
    {
        this.index = index;
    }
}
