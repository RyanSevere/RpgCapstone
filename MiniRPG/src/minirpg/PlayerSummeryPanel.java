/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minirpg;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

/**
 *
 * @author LordShadow
 */
public class PlayerSummeryPanel extends JPanel {
    
    JLabel lblClass, lblpClass, lblRole, lblpRole, lblStr, lblStatStr, lblDex, lblStatDex,
            lblEnd, lblStatEnd, lblWis, lblStatWis, lblSkill1, lblpSkill1, lblSkill2, lblpSkill2, 
            lblSkill3, lblpSkill3, lblSkill4, lblpSkill4, lblTitle, lblStatBreak, lblSkillLine;
    JComboBox comboPlayerList;
    JButton btnBattle, btnEdit;
       
    PlayerClassPanel PCP = new PlayerClassPanel();
    SetPlayerInfo SPI = new SetPlayerInfo();
    String Role, Class, Skill1, Skill2, Skill3, Skill4, Str, Dex, End, Wis;
    String[] Players = new String[5];
    static int comboindex;
    
    
    public PlayerSummeryPanel()
            {
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
                comboPlayerList = new JComboBox();
                c.gridx = 0;
                c.gridy = 2;
                add(comboPlayerList, c);
                
                //Player Role Label
                lblRole = new JLabel("Role: ");
                c.gridx = 0;
                c.gridy = 3;
                add(lblRole, c);
                
                //Player Role
                lblpRole = new JLabel("");
                c.gridx = 1;
                c.gridy = 3;
                add(lblpRole, c);
                
                //Player Class Label
                lblClass = new JLabel("Class: ");
                c.gridx = 0;
                c.gridy = 4;
                add(lblClass, c);
                
                //Player Class
                lblpClass = new JLabel("");
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
                
                //Skill1 Label
                lblSkill1 = new JLabel("First Skill: ");
                c.gridx = 0;
                c.gridy = 11;
                c.gridwidth = 1;
                add(lblSkill1, c);
                
                //player skill
                lblpSkill1 = new JLabel("");
                c.gridx = 1;
                c.gridy = 11;
                add(lblpSkill1, c);
                
                //Skill2 Label
                lblSkill2 = new JLabel("Second Skill: ");
                c.gridx = 0;
                c.gridy = 12;
                c.gridwidth = 1;
                add(lblSkill2, c);
                
                //player skill
                lblpSkill2 = new JLabel("");
                c.gridx = 1;
                c.gridy = 12;
                add(lblpSkill2, c);
                
                //Skill3 Label
                lblSkill3 = new JLabel("Third Skill: ");
                c.gridx = 0;
                c.gridy = 13;
                c.gridwidth = 1;
                add(lblSkill3, c);
                
                //player skill
                lblpSkill3 = new JLabel("");
                c.gridx = 1;
                c.gridy = 13;
                add(lblpSkill3, c);
                
                //Skill4 Label
                lblSkill4 = new JLabel("Fourth Skill: ");
                c.gridx = 0;
                c.gridy = 14;
                c.gridwidth = 1;
                add(lblSkill4, c);
                
                //player skill
                lblpSkill4 = new JLabel("");
                c.gridx = 1;
                c.gridy = 14;
                add(lblpSkill4, c);
                
                //Battle Button
                btnBattle = new JButton("Battle!");
                c.gridx = 0;
                c.gridy = 15;
                add(btnBattle, c);
                //</editor-fold>
                
                ItemListener PlayerSelect = new ItemListener()
                {
                    @Override
                    public void itemStateChanged(ItemEvent e)
                    {
                        if(comboPlayerList.getSelectedIndex() == 0)
                        {
                            Str = " # ";
                            Dex = " # ";
                            End = " # ";
                            Wis = " # ";
                            Role = "";
                            Class = "";
                            Skill1 = "";
                            Skill2 = "";
                            Skill3 = "";
                            Skill4 = "";
                            lblStatStr.setText(Str);
                            lblStatDex.setText(Dex);
                            lblStatEnd.setText(End);
                            lblStatWis.setText(Wis);
                            lblpRole.setText(Role);
                            lblpClass.setText(Class);
                            lblpSkill1.setText(Skill1);
                            lblpSkill2.setText(Skill2);
                            lblpSkill3.setText(Skill3);
                            lblpSkill4.setText(Skill4);
                            comboindex = comboPlayerList.getSelectedIndex();
                        }
                        else 
                        {
                            Str = Integer.toString(MiniRPG.players.get(comboPlayerList.getSelectedIndex() - 1).getStr());
                            Dex = Integer.toString(MiniRPG.players.get(comboPlayerList.getSelectedIndex()- 1).getDex());
                            End = Integer.toString(MiniRPG.players.get(comboPlayerList.getSelectedIndex()- 1).getEnd());
                            Wis = Integer.toString(MiniRPG.players.get(comboPlayerList.getSelectedIndex()- 1).getWis());
                            Role = MiniRPG.players.get(comboPlayerList.getSelectedIndex()- 1).getRole();
                            Class = MiniRPG.players.get(comboPlayerList.getSelectedIndex()- 1).getclass();
                            Skill1 = MiniRPG.players.get(comboPlayerList.getSelectedIndex()- 1).getSkill1();
                            Skill2 = MiniRPG.players.get(comboPlayerList.getSelectedIndex()- 1).getSkill2();
                            Skill3 = MiniRPG.players.get(comboPlayerList.getSelectedIndex()- 1).getSkill3();
                            Skill4 = MiniRPG.players.get(comboPlayerList.getSelectedIndex()- 1).getSkill4();

                            lblStatStr.setText(Str);
                            lblStatDex.setText(Dex);
                            lblStatEnd.setText(End);
                            lblStatWis.setText(Wis);
                            lblpRole.setText(Role);
                            lblpClass.setText(Class);
                            lblpSkill1.setText(Skill1);
                            lblpSkill2.setText(Skill2);
                            lblpSkill3.setText(Skill3);
                            lblpSkill4.setText(Skill4);
                            comboindex = comboPlayerList.getSelectedIndex();
                        }
                        
                    }
                };
            
            PlayerSummeryPanel.Event a = new PlayerSummeryPanel.Event();
                
            comboPlayerList.addItemListener(PlayerSelect);    
            btnBattle.addActionListener(a);
            }
    
    
    public class Event implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent a)
        {
            if(a.getSource() == btnBattle)
            {
                setVisible(false);
                Battle gui = new Battle();
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gui.setSize(1100, 720);
                gui.setResizable(false);
                gui.setVisible(true);
                
            }
        }
    }

    static int getcomboIndex()
    {
        return comboindex;
    }
}
