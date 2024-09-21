package co.edu.uptc.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

public class PanelMenu2 extends JPanel {

    private final int WIDTH=200;
    private final int HEIGHT=100;
    private final int HEIGHT_BTN=30;
    private final int HGAP=2;
    private final int VGAP=1;
    private Color colorBackground= new Color(0, 31, 63);
    private Color colorBackgroundSelected= new Color(58, 109, 140);

    private List<JToggleButtonCustom> listBtn;


  public PanelMenu2() {
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setBackground(colorBackground);
    setLayout(new FlowLayout(FlowLayout.LEFT,HGAP,VGAP));
    createMenu();
  }

  private void createMenu() {
    listBtn = new ArrayList<>();
    addButton("Action 1");    
    addButton("Action 211");
    addButton("Action 2222");
    addButton("Action 23333333");
    addmenu(); 
    unSelectedItemMenu();
  }


  private void unSelectedItemMenu(){
    for (JToggleButtonCustom jToggleButtonCustom : listBtn) {
        jToggleButtonCustom.setSelected(false);
    }
  }

private void addmenu(){
    for (JToggleButtonCustom jToggleButtonCustom : listBtn) {
        add(jToggleButtonCustom);
    }
}

private JToggleButtonCustom addButton(String text){
    JToggleButtonCustom jButton = new JToggleButtonCustom();
    jButton.setText(text);
    jButton.setPreferredSize(new Dimension(WIDTH-(HGAP*2), HEIGHT_BTN));     
    jButton.setBackground(colorBackground); 
    jButton.setForeground(Color.WHITE);
    jButton.setBackgroundSelected(colorBackgroundSelected);
    listBtn.add(jButton);   
    jButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            unSelectedItemMenu();
            jButton.setSelected(true);
        }
        
    });
    return jButton;
}


public void showData1(){
    System.out.println("11111111111111");
}

public void showData2(){
    System.out.println("22222222222222");
}

}
