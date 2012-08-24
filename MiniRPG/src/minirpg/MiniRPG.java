//Created By Sean Forman and Ryan Severe
//This class has been Cleansed

package minirpg;

import java.util.ArrayList;
import javax.swing.JFrame;

public class MiniRPG {

    String name;
    int str, dex, end, wis;
    String Class, Role, Skill;
    public static ArrayList<Player> players = new ArrayList<Player>();
    
    public static void main(String[] args) {
        
        TabGUI gui = new TabGUI();      
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true); //now set in NewTabGUI
        gui.setSize(325, 355);; //now set in NewTabGUI
        TabGUI.disableSummeryPanel(); //initally disables the SummeryPanel
        TabGUI.disableStatPanel();
            
    }
    public String getName(int num) {
        name = players.get(num).getName();
        return name;
    }

    public int getStr(int num) {
        str = players.get(num).getStr();
        return str;
    }

    public int getDex(int num) {
        dex = players.get(num).getDex();
        return dex;
    }

    public int getEnd(int num) {
        end = players.get(num).getEnd();
        return end;
    }

    public int getWis(int num) {
        wis = players.get(num).getWis();
        return wis;
    }
    public String getRole(int num)
    {
        Role = players.get(num).getRole();
        return Role;
    }
    
}
