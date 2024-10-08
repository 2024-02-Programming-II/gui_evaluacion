package co.edu.uptc.views.vehicleView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.uptc.views.componets.JColorChooserCustom;
import co.edu.uptc.views.mainView.MainFrame;
import co.edu.uptc.views.palettes.ColorPalette;
import co.edu.uptc.views.palettes.FontPalette;


public class DialogVehicle extends JDialog {

  private int posY = 40;
  private int paddingX = 50;
  private int heightComponent = 25;
  private int widthSubTitle = 75;
  private int spaceVerticalBetweenComponents = 5;

  public DialogVehicle() {
    super(MainFrame.getInstance(), true);
    getContentPane().setBackground(Color.red);
    setSize(440, 316);
    setResizable(false);
    setLocationRelativeTo(MainFrame.getInstance());
    setLayout(new BorderLayout());
    initComponents();

   
  }

  private void initComponents() {
    addPanelTitle();
    addPanelInfo();
    addPanelButtones();
  }

  private void dialogClose() {
    this.setVisible(false);
  }

  private void addPanelTitle() {
    JPanel panelTitle = new JPanel();
    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 1, 20);
    panelTitle.setLayout(flowLayout);
    add(panelTitle, BorderLayout.NORTH);
    JLabel title = new JLabel("CREACIÓN DE VEHÍCULO");
    title.setFont(FontPalette.TITLE_FONT);
    panelTitle.setBackground(ColorPalette.COLOR_TITLE_BACKGROUND);
    title.setForeground(ColorPalette.COLOR_TITLE_FOREGROUND);

    panelTitle.add(title);
  }

  private void addPanelButtones() {
    JPanel panel = new JPanel();
    panel.setBackground(ColorPalette.COLOR_BACKGROUND_STATUS_BAR);
    add(panel, BorderLayout.SOUTH);
    addBtnSave(panel);
    addBtnCancel(panel);
  }

  private void addBtnSave(JPanel panel) {
    JButton jButton = new JButton("Guardar");
    jButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          dialogClose();
        }
      }
    );
    panel.add(jButton);
  }

  private void addBtnCancel(JPanel panel) {
    JButton jButton = new JButton("Cancelar");
    jButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          dialogClose();
        }
      }
    );
    panel.add(jButton);
  }

  private void addPanelInfo() {
    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(ColorPalette.COLOR_BACKGROUND_INFO);
    add(panel, BorderLayout.CENTER);
    addComponents(panel);
  }

  private void addComponents(JPanel panel) {
    addFieldPlate(panel);
    addFieldModel(panel);
    addFieldColor(panel);
    addFieldOwner(panel);
  }

  private void addFieldPlate(JPanel panel) {
    JTextField fieldLicensePlate = new JTextField();
    fieldLicensePlate.setSize(50, 20);
    addComponent(panel, fieldLicensePlate, "Placa:");
  }

  private void addFieldModel(JPanel panel) {
    DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<>();
    System.out.println(java.util.Calendar.YEAR);
    int currentYear = java.util.Calendar
      .getInstance()
      .get(java.util.Calendar.YEAR);
    for (int year = currentYear; year >= 1900; year--) {
      yearModel.addElement(year);
    }
    JComboBox<Integer> yearComboBox = new JComboBox<>(yearModel);

    yearComboBox.setSelectedItem(
      java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)
    );
    yearComboBox.setSize(70, 20);
    addComponent(panel, yearComboBox, "Modelo:");
  }

  private void addFieldColor(JPanel panel) {
    JButton btnCarColor = new JButton("Color");
    btnCarColor.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          addChooserColor( btnCarColor);         
          
        }
      }
    );
    btnCarColor.setSize(100, 30);
    addComponent(panel, btnCarColor, "Color:");
  }


  private void addChooserColor(JComponent component){
    JColorChooserCustom colorChooser = new JColorChooserCustom();
    JDialog dialog = JColorChooser.createDialog(
      null,
      "Seleccionar Color",
      true,
      colorChooser,
      actionEvent -> {
        Color selectedColor = colorChooser.getColor();
        if (selectedColor != null) {
          component.setBackground(selectedColor);
        }
      },
      null
    );


    
    for (int i = 0; i < dialog.getContentPane().getComponentCount(); i++) {
       dialog.getContentPane().getComponent(i).setBackground(ColorPalette.COLOR_BACKGROUND_STATUS_BAR);
    }
    dialog.setVisible(true);
  }

  private void addFieldOwner(JPanel panel) {
    JTextField fieldOwner = new JTextField();
    fieldOwner.setSize(250, 20);
    addComponent(panel, fieldOwner, "Propietario:");
  }

  private void addComponent(JPanel panel, JComponent field, String title) {
    JLabel jLabel = new JLabel(title);
    jLabel.setBounds(paddingX, posY, widthSubTitle, heightComponent);
    panel.add(jLabel);

    field.setBounds(
      widthSubTitle + paddingX,
      posY,
      field.getSize().width,
      heightComponent
    );
    panel.add(field);
    posY = posY + heightComponent + spaceVerticalBetweenComponents;
  }
}
