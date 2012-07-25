/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minirpg;

import java.awt.*;
import java.util.ArrayList;
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
    String Role, Class, Skill;
    int count  = 0;
    
    public static ArrayList<ComboSelection> comboSelection = new ArrayList<ComboSelection>();
    
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
    
    static void activateSummeryPanel()
    {
        jtp.setEnabledAt(2, true);
        SummerySelected();
    }
    
    static void activateStatPanel()
    {
        jtp.setEnabledAt(1, true);
    }
    
    static void activateCreationpanels()
    {
        jtp.setEnabledAt(0, true);
        jtp.setEnabledAt(1, true);
    }
    
    static void activateClassPanel()
    {
        jtp.setEnabledAt(0, true);
    }
    
    static void disableClassPanel()
    {
        jtp.setEnabledAt(0, false);
    }
    
    static void disableSummeryPanel()
    {
        jtp.setEnabledAt(2, false);
        
    }
    
    static void disableStatPanel()
    {
        jtp.setEnabledAt(1, false);
    }
    
    static void disableCreationPanels()
    {
        jtp.setEnabledAt(0, false);
        jtp.setEnabledAt(1, false);
    }
    
    static void SummerySelected()
    {
        int x = 0;
        int count = 0; 
        while(count <= MiniRPG.players.size() - 1)
            {
                
                PSUMP.Players[x] = MiniRPG.players.get(x).getName();
                System.out.println("x: " + x);
                System.out.println("count: " + count);
                System.out.println("size of Player Array: " + MiniRPG.players.size());
                System.out.println("Player " + x + " is " + MiniRPG.players.get(x).getName());
                x++;
                count++;
            }
        PSUMP.comboPlayerList.setModel(new DefaultComboBoxModel(PSUMP.Players));
        jtp.setSelectedIndex(2);
        disableCreationPanels();
    }
    
    static void returntoClassPanel()
    {
        jtp.setSelectedIndex(0);
    }
    
    static void FowardStatPanel()
    {
        jtp.setSelectedIndex(1);
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
    
    public String getRole(int num) 
    {
        Role = comboSelection.get(num).getRole();
        return Role;
    }
    
    public String getclass(int num)
    {
        Class = comboSelection.get(num).getclass();
        return Class;
    }
    
    public String getSkill(int num)
    {
        Skill = comboSelection.get(num).getSkill();
        return Skill;
    }
    
}
