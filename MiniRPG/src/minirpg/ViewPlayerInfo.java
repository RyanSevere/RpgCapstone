//token change
package minirpg;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import minirpg.Player;

public class ViewPlayerInfo extends JFrame {
    String[] playerNameList = new String[20];
    String s;
    MiniRPG miniRpg = new MiniRPG();
    JLabel title,str,dex,end,wis,strView,dexView,endView,wisView,values;;
    JButton view,edit,add;
    private JComboBox listBox;
  
        public ViewPlayerInfo(){
            
            int i = 0;
            while (i < MiniRPG.players.size()) {
                playerNameList[i] = miniRpg.getName(i);
                System.out.println(miniRpg.getStr(i));
                i++;
            }
                       listBox = new JComboBox(playerNameList);
                       
        GridBagConstraints c = new GridBagConstraints();
        setLayout(new GridBagLayout());
        
        
        
        str = new JLabel("Strengh   ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        add(str, c);
        
        dex = new JLabel("Dexerity  ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        add(dex, c);
        
        end = new JLabel("Endurance     ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        add(end, c);
        
        wis = new JLabel("Wisdom    ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
        add(wis, c);
        
        strView = new JLabel("      0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 25;
        c.gridx = 2;
        c.ipady = 25;
        c.gridy = 1;
        add(strView, c);
        
        dexView = new JLabel("      0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        add(dexView, c);
        
        endView = new JLabel("      0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 3;
        add(endView, c);
        
        wisView = new JLabel("      0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 4;
        add(wisView, c);
        
        values = new JLabel("Stats");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 40;
        c.gridx = 2;
        c.gridy = 0;
        add(values, c);
        
        edit = new JButton("edit");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 5;
        add(edit, c);
        
        edit = new JButton("Add New");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 5;
        add(edit, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        add(listBox, c);
        
        Event a = new Event();
        listBox.addActionListener(a);
        edit.addActionListener(a);
        }
        
        
    public class Event implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a){
            String setStr = Integer.toString(MiniRPG.players.get(listBox.getSelectedIndex()).getStr());
            String setDex = Integer.toString(MiniRPG.players.get(listBox.getSelectedIndex()).getDex());
            String setEnd = Integer.toString(MiniRPG.players.get(listBox.getSelectedIndex()).getEnd());
            String setWis = Integer.toString(MiniRPG.players.get(listBox.getSelectedIndex()).getWis());
            if(a.getSource() == listBox){
                //listBox.getItemCount();
               // System.out.println(Integer.toString(listBox.getSelectedIndex()));
            strView.setText(setStr);
            dexView.setText(setDex);
            endView.setText(setEnd);
            wisView.setText(setWis);
           }
            else if(a.getSource() == edit){
                listBox.remove(listBox.getSelectedIndex());
                MiniRPG.players.remove(listBox.getSelectedIndex());
                SetPlayerInfo gui2 = new SetPlayerInfo(MiniRPG.players.get(listBox.getSelectedIndex()));
                //gui2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gui2.setVisible(true);
                gui2.setSize(250,250);
            }
            else if(a.getSource() == add){
                SetPlayerInfo gui = new SetPlayerInfo();
                //gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gui.setVisible(true);
                gui.setSize(250,250);
            }
       }
    }
}
