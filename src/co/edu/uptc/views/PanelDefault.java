package co.edu.uptc.views;



import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDefault extends JPanel {

  private GridBagConstraints gbc;

  public PanelDefault() {    
    setLayout(new GridBagLayout());
    gbc = new GridBagConstraints();    
    gbc.fill = GridBagConstraints.CENTER;   
    gbc.insets = new Insets(10, 0, 10, 0);  
    gbc.weightx = 3.0;
    setBackground(ColorPalette.COLOR_BACKGROUND_INFO);    
    initComponents();
  }

  private void initComponents() {
    addTitle();   
  }



  private void addTitle() {  
    JLabel title1 = new JLabel("SIN IMPLEMTAR");    
    title1.setForeground(ColorPalette.COLOR_FOREGROUND_INFO);    
    title1.setFont(FontPalette.TITLE_FONT);
    gbc.gridy = 0;
    add(title1,gbc);

    


  }

}
