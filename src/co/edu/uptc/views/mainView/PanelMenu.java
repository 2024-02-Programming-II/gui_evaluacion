package co.edu.uptc.views.mainView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import co.edu.uptc.enums.PanelEnum;
import co.edu.uptc.views.componets.JToggleButtonCustom;
import co.edu.uptc.views.palettes.ColorPalette;

public class PanelMenu extends JPanel {

    private final int WIDTH=200;
    private final int HEIGHT=100;
    private final int HEIGHT_BTN=30;
    private final int TOP_MENU=10;
    private final int HGAP=5;
    private final int VGAP=1;
    private Color colorBackground= ColorPalette.COLOR_BACKGROUND_MAIN_MENU;
    private Color colorForeground= ColorPalette.COLOR_TEXT_MAIN_MENU;
    private Color colorBackgroundSelected= ColorPalette.COLOR_SELECT_MAIN_MENU;
    
     ButtonGroup group = new ButtonGroup();


  public PanelMenu() {
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setBackground(colorBackground);
    setLayout(new FlowLayout(FlowLayout.LEFT,HGAP,VGAP));
    createMenu();
  }

  private void createMenu() {
    addSeparator();
    addBtnMain();
    addBtnVihicleManager();
    addBtnAction1();
    addBtnAction2();
    addBtnAction3();
    addBtnExit();
  }

  public void addSeparator(){
    JPanel panelSeparator = new JPanel();
    panelSeparator.setPreferredSize(new Dimension(WIDTH-(HGAP*2), TOP_MENU)); 
    panelSeparator.setBackground(colorBackground);
    add(panelSeparator);
  }
  
  
    private void addBtnMain(){
      addButton("Principal").addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              MainFrame.getInstance().activatePanel(PanelEnum.MAIN);
          }
          
      });    
    }

    private void addBtnAction1(){
      addButton("Accion 1").addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              MainFrame.getInstance().activatePanel(PanelEnum.DEFAULT);
          }
          
      });    
    }
    private void addBtnAction2(){
      addButton("Accion 2").addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              MainFrame.getInstance().activatePanel(PanelEnum.DEFAULT);
          }
          
      });    
    }
    private void addBtnAction3(){
      addButton("Accion 3").addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              MainFrame.getInstance().activatePanel(PanelEnum.DEFAULT);
          }
          
      });    
    }

  private void addBtnVihicleManager(){
    addButton("Administrar Vehiculos").addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            MainFrame.getInstance().activatePanel(PanelEnum.VEHICLE_MANAGER);
        }
        
    });    
  }

  private void addBtnExit(){
    addButton("Salir").addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
    });    
  }





private JToggleButtonCustom addButton(String text){
    JToggleButtonCustom jButton = new JToggleButtonCustom();
    jButton.setText(text);
    jButton.setPreferredSize(new Dimension(WIDTH-(HGAP*2), HEIGHT_BTN));     
    jButton.setBackground(colorBackground); 
    jButton.setForeground(colorForeground);
    jButton.setBackgroundSelected(colorBackgroundSelected);
    group.add(jButton);   
    add(jButton);       
    return jButton;
}

public void unselectedAll(){
  group.clearSelection();
}


}
