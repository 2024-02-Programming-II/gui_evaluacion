package co.edu.uptc.views.mainView;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import co.edu.uptc.enums.PanelEnum;
import co.edu.uptc.views.vehicleView.PanelVehicleManager;

public class MainFrame extends JFrame {

  private PanelMenu panelMenu;
  private PanelVehicleManager panelVehicleManager;
  private JPanel panelCenter;
  private PanelDefault panelDefault;
  private PanelMain panelMain;
  private PanelStatus panelStatus;

  

  private MainFrame() {
    setSize(500, 500);
    getContentPane().setBackground(new Color(234, 216, 177));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setMinimumSize(new Dimension(1000, 800));
    setLocationRelativeTo(null);
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
    addStatus();
    addCenter();       
  }


  private void addStatus() {    
    panelStatus = new PanelStatus();
    add(panelStatus, BorderLayout.SOUTH);
  }

  
  private void addCenter() {
    panelCenter = new JPanel(new CardLayout());    
    panelCenter.setBackground(Color.red);
    add(panelCenter, BorderLayout.CENTER);
    createPanels();
  }
  
  private void createPanels(){
    panelDefault = new PanelDefault();   
    panelMain = new PanelMain();
    panelVehicleManager = new PanelVehicleManager();     
    panelCenter.add(panelMain,PanelEnum.MAIN.toString()); 
    panelCenter.add(panelDefault,PanelEnum.DEFAULT.toString()); 
    panelCenter.add(panelVehicleManager,PanelEnum.VEHICLE_MANAGER.toString());
    
  }
  
  public void activatePanel(PanelEnum panelEnum) {   
    CardLayout cardLayout = (CardLayout) panelCenter.getLayout();       
    cardLayout.show(panelCenter, panelEnum.name());
    if (panelEnum==PanelEnum.MAIN){
      MainFrame.getInstance().panelMenu.unselectedAll();
    }

   
  }

 
  

}
