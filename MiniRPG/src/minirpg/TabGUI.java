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
    static JTabbedPane jtp = new JTabbedPane();
    
    //declare panels to create tabs
    static PlayerClassPanel PCP = new PlayerClassPanel();
    static PlayerSummeryPanel PSUMP = new PlayerSummeryPanel();
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
        this.setTitle("Player Creation");
        
       
        
        
    }
//    static void meow(){
//    jtp.setSelectedIndex(0);
//    
//    }
    
    static void activateSummeryPanel()
    {
        jtp.setEnabledAt(2, true);
    }
    
    public void disableSummeryPanel()
    {
        jtp.setEnabledAt(2, false);
        
    }
    
    static void SummerySelected()
    {
        
//        int count = 0; 
//        while(count <= MiniRPG.players.size())
//            {
//                int x = 0;
//                PSUMP.Players[x] = MiniRPG.players.get(x).getName();
//                x++;
//                count++;
//                System.out.println(PSUMP.Players[x]);
//            }  
    }
    

    static void returntoClassPanel()
    {
        
        //System.out.println("ReturntoClassPanel has been run");
        jtp.setSelectedIndex(0);
    }
    
    static void resetCombo()
    {
        PCP.comboRole.setSelectedItem(PCP.roles[0]);
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
