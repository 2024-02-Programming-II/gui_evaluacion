package co.edu.uptc.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

public class PanelMenu extends JPanel {

    private final int WIDTH=200;
    private final int HEIGHT=100;
    private final int HEIGHT_BTN=30;
    private final int TOP_MENU=10;
    private final int HGAP=5;
    private final int VGAP=1;
    private Color colorBackground= new Color(0, 31, 63);
    private Color colorBackgroundSelected= new Color(58, 109, 140);
    
     ButtonGroup group = new ButtonGroup();


  public PanelMenu() {
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setBackground(colorBackground);
    setLayout(new FlowLayout(FlowLayout.LEFT,HGAP,VGAP));
    createMenu();
  }

  private void createMenu() {
    addSeparator();
    addBtnAction1();
    addBtnAction2();
  }

  public void addSeparator(){
    JPanel panelSeparator = new JPanel();
    panelSeparator.setPreferredSize(new Dimension(WIDTH-(HGAP*2), TOP_MENU)); 
    panelSeparator.setBackground(colorBackground);
    add(panelSeparator);
  }
  

  private void addBtnAction1(){
    addButton("Action 1").addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            MainFrame.getInstance().activatePanel("Action 1");
        }
        
    });    
  }

  private void addBtnAction2(){
    addButton("Action 22222").addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            MainFrame.getInstance().activatePanel("Action 2");
        }
        
    });    
  }





private JToggleButtonCustom addButton(String text){
    JToggleButtonCustom jButton = new JToggleButtonCustom();
    jButton.setText(text);
    jButton.setPreferredSize(new Dimension(WIDTH-(HGAP*2), HEIGHT_BTN));     
    jButton.setBackground(colorBackground); 
    jButton.setForeground(Color.WHITE);
    jButton.setBackgroundSelected(colorBackgroundSelected);
    group.add(jButton);   
    add(jButton);       
    return jButton;
}


public void showData1(){
    System.out.println("11111111111111");
}

public void showData2(){
    System.out.println("22222222222222");
}

}
