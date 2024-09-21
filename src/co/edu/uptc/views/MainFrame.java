package co.edu.uptc.views;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

  private PanelMenu panelMenu;
  private PanelManagerVehicle panelManagerVehicle;
  private PanelVehicle panelVehicle;
  private PanelStatus panelStatus;

  private MainFrame() {
    setSize(500, 500);
    getContentPane().setBackground(new Color(234, 216, 177));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    initComponents();
    setVisible(true);
  }

  private static MainFrame instance;

  public static MainFrame getInstance() {
    if (instance == null) {
      instance = new MainFrame();
    }
    return instance;
  }

  private void initComponents() {
    panelMenu = new PanelMenu();
    add(panelMenu, BorderLayout.WEST);

    panelManagerVehicle = new PanelManagerVehicle();
    panelVehicle = new PanelVehicle();

    panelStatus = new PanelStatus();
    add(panelStatus, BorderLayout.SOUTH);
  }

  public void activatePanel(String namePanel) {   
    switch (namePanel) {
      case "Action 1":
        add(panelVehicle, BorderLayout.CENTER);
        paintComponents(getGraphics());
        break;
      case "Action 2":
        add(panelManagerVehicle, BorderLayout.CENTER);
        paintComponents(getGraphics());
        break;
      default:
        break;
    }    
  }
}
