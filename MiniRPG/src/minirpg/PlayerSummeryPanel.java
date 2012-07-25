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
            lblEnd, lblStatEnd, lblWis, lblStatWis, lblSkill, lblpSkill, lblTitle, lblStatBreak, lblSkillLine;
    JComboBox comboPlayerList;
    JButton btnBattle, btnEdit;
       
    PlayerClassPanel PCP = new PlayerClassPanel();
    SetPlayerInfo SPI = new SetPlayerInfo();
    String Role, Class, Skill, Str, Dex, End, Wis;
    String[] Players = {"", "", "", ""};
    
    
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
                
                //Skill Label
                lblSkill = new JLabel("Skill: ");
                c.gridx = 0;
                c.gridy = 11;
                c.gridwidth = 1;
                add(lblSkill, c);
                
                //player skill
                lblpSkill = new JLabel("");
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
                
                ItemListener PlayerSelect = new ItemListener()
                {
                    @Override
                    public void itemStateChanged(ItemEvent e)
                    {
                        Str = Integer.toString(MiniRPG.players.get(comboPlayerList.getSelectedIndex()).getStr());
                        Dex = Integer.toString(MiniRPG.players.get(comboPlayerList.getSelectedIndex()).getDex());
                        End = Integer.toString(MiniRPG.players.get(comboPlayerList.getSelectedIndex()).getEnd());
                        Wis = Integer.toString(MiniRPG.players.get(comboPlayerList.getSelectedIndex()).getWis());
                        Role = MiniRPG.players.get(comboPlayerList.getSelectedIndex()).getRole();
                        Class = MiniRPG.players.get(comboPlayerList.getSelectedIndex()).getclass();
                        Skill = MiniRPG.players.get(comboPlayerList.getSelectedIndex()).getSkill1();
                        
                        lblStatStr.setText(Str);
                        lblStatDex.setText(Dex);
                        lblStatEnd.setText(End);
                        lblStatWis.setText(Wis);
                        lblpRole.setText(Role);
                        lblpClass.setText(Class);
                        lblpSkill.setText(Skill);
                    }
                };
            
            PlayerSummeryPanel.Event a = new PlayerSummeryPanel.Event();
                
            comboPlayerList.addItemListener(PlayerSelect);    
            btnBattle.addActionListener(a);
            btnEdit.addActionListener(a);
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
                gui.setSize(1000, 550);
                gui.setResizable(false);
                gui.setVisible(true);
            }
            if(a.getSource() == btnEdit)
            {
                edit();
                SPI.nameField.setText(MiniRPG.players.get(comboPlayerList.getSelectedIndex()).getName());
            }
        }
    }
    
    public void edit() 
        {
            String setStr = Integer.toString(MiniRPG.players.get(comboPlayerList.getSelectedIndex()).getStr());
            String setDex = Integer.toString(MiniRPG.players.get(comboPlayerList.getSelectedIndex()).getDex());
            String setEnd = Integer.toString(MiniRPG.players.get(comboPlayerList.getSelectedIndex()).getEnd());
            String setWis = Integer.toString(MiniRPG.players.get(comboPlayerList.getSelectedIndex()).getWis());
            String setPointsLeft = Integer.toString(MiniRPG.players.get(comboPlayerList.getSelectedIndex()).getPointsLeft());
            SPI.strTotal.setText(setStr);
            SPI.dexTotal.setText(setDex);
            SPI.endTotal.setText(setEnd);
            SPI.wisTotal.setText(setWis);
            SPI.pointsLeftField.setText(setPointsLeft);
            SPI.create.setVisible(false);
            SPI.done.setVisible(true);
            SPI.playerName = MiniRPG.players.get(comboPlayerList.getSelectedIndex()).getName();
            SPI.name.setText(SPI.playerName);
            SPI.pointsLeftField.setText(Integer.toString(MiniRPG.players.get(comboPlayerList.getSelectedIndex()).getPointsLeft()));
            TabGUI.activateCreationpanels();
            TabGUI.returntoClassPanel();
        }
}
