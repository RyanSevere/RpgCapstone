package minirpg;

import java.util.ArrayList;
import javax.swing.JFrame;

public class MiniRPG {

    String name;
    int str, dex, end, wis;
    public static ArrayList<Player> players = new ArrayList<Player>();
    
    //Player playerList = new Player();
    public static void main(String[] args) {
        
        TabGUI gui = new TabGUI();      
        //SetPlayerInfo gui = new SetPlayerInfo();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //gui.setVisible(true); //now set in NewTabGUI
        //gui.setSize(275, 315); //now set in NewTabGUI
            
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
}
