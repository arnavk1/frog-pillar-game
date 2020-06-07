import java.awt.Graphics;
import javax.swing.*;
import java.awt.Window.*;
import javax.swing.JComponent.*;
import java.awt.event.ActionEvent;
import java.awt.Component.*;
import java.awt.event.*;
import java.awt.*;

public class frogPillarV3  {
  public static void main(String[] args) {
      new ml();
  }
}

class ml extends JFrame  implements ActionListener
{
    
    int size = 7;
    int z = 0;
    JLabel l;
    int i = 0;
    JButton butarr[] = new JButton[7];
    JButton reset = new JButton("Reset!!");
    public ml(){
        
        for(i = 0; i < size; i++)
        {            
            butarr[i] = new JButton();
             
        }
        
        butarr[0].setBackground(Color.RED);
        butarr[1].setBackground(Color.RED);
        butarr[2].setBackground(Color.RED);
        butarr[3].setBackground(Color.white);
        butarr[4].setBackground(Color.blue);
        butarr[5].setBackground(Color.blue);
        butarr[6].setBackground(Color.blue);

        
        add(reset);
        
        
        for(i = 0; i < size; i++){
            add(butarr[i]);
        }
        
        l = new JLabel("          Go");
        add(l);

        reset.addActionListener(ae ->{
            butarr[0].setBackground(Color.RED);
            butarr[1].setBackground(Color.RED);
            butarr[2].setBackground(Color.RED);
            butarr[3].setBackground(Color.white);
            butarr[4].setBackground(Color.blue);
            butarr[5].setBackground(Color.blue);
            butarr[6].setBackground(Color.blue);
            add(l);
        });
    
        for(i = 0; i < size; i++){
            butarr[i].addActionListener(this);  
        }
            
        setLayout(new GridLayout());
        setSize(1200, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public boolean ischeck(){
        
            if(butarr[0].getBackground() != Color.blue){
                return false;
            }

            if(butarr[1].getBackground() != Color.blue){
                return false;
            }

            if(butarr[2].getBackground() != Color.blue){
                return false;
            }

            if(butarr[3].getBackground() != Color.white){
                return false;
            }
        
            if(butarr[4].getBackground() != Color.RED){
                return false;
            }
            if(butarr[5].getBackground() != Color.RED){
                return false;
            }
            if(butarr[6].getBackground() != Color.RED){
                return false;
            }
                  
        return true;
    }

    public void actionPerformed(ActionEvent ae){
        int counter = 0;

        for(i = 0; i < size; i++){
            if(ae.getSource() == butarr[i]){    
                
                if(!ischeck()){
                    for(int p = 0; p < size; p++){
                        if(butarr[p].getBackground() == Color.WHITE){
                            z = p;
                        }
                    }                
                    
                    try {
                        if(i >= z-2 && i <= z + 2){
                            if(butarr[i].getBackground() == Color.RED && i < z){
                                butarr[i].setBackground(Color.WHITE);
                                butarr[z].setBackground(Color.RED);
                            }
                            if(butarr[i].getBackground() == Color.BLUE && i > z){
                                butarr[i].setBackground(Color.WHITE);
                                butarr[z].setBackground(Color.BLUE);
                            }
                            
                        }
                        
                    } catch (Exception e) {
                        //TODO: handle exception
                    }
                }                 
                
                if(ischeck()){
                    l.setText("\t\tCongratulation!!");
                } 
                            
            }
        }
    }
}