/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minirpg;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author LordShadow
 */
public class PlayerSummeryPanel extends JPanel {
    
    JLabel lblClass, lblpClass, lblRole, lblpRole, lblStr, lblStatStr, lblDex, lblStatDex,
            lblEnd, lblStatEnd, lblWis, lblStatWis, lblSkill, lblpSkill, lblTitle, lblStatBreak, lblSkillLine;
    JComboBox comboPlayerList;
    JButton btnBattle, btnEdit;
       
    PlayerClassPanel Pcp = new PlayerClassPanel();
    SetPlayerInfo Spi = new SetPlayerInfo();
    int playerid, str, dex, end, wis;
    String Role, Class, Skill;
    String[] Players = {"", "", "", ""};
    
    
    public PlayerSummeryPanel()
            {
//                int count = 0; 
//                while(count <= MiniRPG.players.size())
//                    {
//                        int x = 0;
//                        Players[0] = MiniRPG.players.get(x).getName();
//                        x++;
//                        count++;
//                        System.out.println(Players[x]);
//                    } 
                
                
                //<editor-fold defaultstate="collapesed" desc="GUI layout">
                //uses gridbag payout to setup GUI
                setLayout(new GridBagLayout());
                GridBagConstraints c = new GridBagConstraints();
                
                //Title
                lblTitle = new JLabel("Player Summery");
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = 0;
                c.gridy = 1;
                add(lblTitle, c);
                
                //Combo Box to selected Player
                comboPlayerList = new JComboBox(Players);
                c.gridx = 0;
                c.gridy = 2;
                add(comboPlayerList, c);
                
                //Player Role Label
                lblRole = new JLabel("Role: ");
                c.gridx = 0;
                c.gridy = 3;
                add(lblRole, c);
                
                //Player Role
                lblpRole = new JLabel("Tank");
                c.gridx = 1;
                c.gridy = 3;
                add(lblpRole, c);
                
                //Player Class Label
                lblClass = new JLabel("Class: ");
                c.gridx = 0;
                c.gridy = 4;
                add(lblClass, c);
                
                //Player Class
                lblpClass = new JLabel("Barbarian");
                c.gridx = 1;
                c.gridy = 4;
                add(lblpClass, c);
                
                //Line between class info and stats
                lblStatBreak = new JLabel("---------------Stats----------------");
                c.gridx = 0;
                c.gridy = 5;
                c.gridwidth = 2;
                add(lblStatBreak, c);
                
                //Player Stats
                //Strength
                lblStr = new JLabel("Strength ");
                c.gridx = 0;
                c.gridy = 6;
                c.gridwidth = 1;
                add(lblStr, c);
                
                //str stat
                lblStatStr = new JLabel(" # ");
                c.gridx = 1;
                c.gridy = 6;
                add(lblStatStr, c);
                
                //dex label
                lblDex = new JLabel("Dexterity ");
                c.gridx = 0;
                c.gridy = 7;
                add(lblDex, c);
                
                //dex stat
                lblStatDex = new JLabel(" # ");
                c.gridx = 1;
                c.gridy = 7;
                add(lblStatDex, c);
                
                //end label
                lblEnd = new JLabel("Endurance: ");
                c.gridx = 0;
                c.gridy = 8;
                add(lblEnd, c);
                
                //end stat
                lblStatEnd = new JLabel(" # ");
                c.gridx = 1;
                c.gridy = 8;
                add(lblStatEnd, c);
                
                //wis label
                lblWis = new JLabel("Wisdom: ");
                c.gridx = 0;
                c.gridy = 9;
                add(lblWis, c);
                
                //wis stat
                lblStatWis = new JLabel(" # ");
                c.gridx = 1;
                c.gridy = 9;
                add(lblStatWis, c);
                
                //skilllinebreak
                lblSkillLine = new JLabel("---------------Skill----------------");
                c.gridx = 0;
                c.gridy = 10;
                c.gridwidth = 2;
                add(lblSkillLine, c);
                
                //Skill Label
                lblSkill = new JLabel("Skill: ");
                c.gridx = 0;
                c.gridy = 11;
                c.gridwidth = 1;
                add(lblSkill, c);
                
                //player skill
                lblpSkill = new JLabel("Rush");
                c.gridx = 1;
                c.gridy = 11;
                add(lblpSkill, c);
                
                //Battle Button
                btnBattle = new JButton("Battle!");
                c.gridx = 0;
                c.gridy = 12;
                add(btnBattle, c);
                
                //Edit Button
                btnEdit = new JButton("Edit");
                c.gridx = 1;
                c.gridy = 12;
                add(btnEdit, c);
                //</editor-fold>
                
                        
            }
    
    
//   ChangeListener changeListener = new ChangeListener() {
//       public void stateChanged(ChangeEvent evt)
//       {
//           JTabbedPane sourceTabbedPane = (JTabbedPane) evt.getSource();
//           int index = sourceTabbedPane.getSelectedIndex();
//           System.out.println("Summery Panel Selected");
//       }
//   };
   
}
