package co.edu.uptc.views.vehicleView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import co.edu.uptc.enums.PanelEnum;
import co.edu.uptc.views.mainView.MainFrame;
import co.edu.uptc.views.palettes.ColorPalette;
import co.edu.uptc.views.palettes.FontPalette;

public class PanelVehicleManager extends JPanel {

  private JPanel panelOperations;

  public PanelVehicleManager() {
    setBackground(Color.LIGHT_GRAY);
    setLayout(new BorderLayout());
    initComponents();
  }

  private void initComponents() {
    addTitle();
    addButtonsGeneral();
    addPanelOperations();
  }

  private void addTitle() {
    JPanel panelTitle = new JPanel();
    FlowLayout flowLayout =new FlowLayout(FlowLayout.CENTER,1,20);
    panelTitle.setLayout(flowLayout);    
    add(panelTitle, BorderLayout.NORTH);
    JLabel title = new JLabel("ADMINISTRADOR DE VEHICULOS");
    title.setFont(FontPalette.TITLE_FONT);
    panelTitle.setBackground(ColorPalette.COLOR_TITLE_BACKGROUND);    
    title.setForeground(ColorPalette.COLOR_TITLE_FOREGROUND);    

    panelTitle.add(title);
  }

  private void addButtonsGeneral() {
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT,30,20));
    
    panel.setBackground(ColorPalette.COLOR_BACKGROUND_STATUS_BAR);
    add(panel, BorderLayout.SOUTH);
    JButton btnCancel = new JButton("Cancelar");
    btnCancel.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().activatePanel(PanelEnum.DEFAULT);
      }
      
    });
    panel.add(btnCancel);
  }

  private void addPanelOperations() {
    panelOperations = new JPanel();    
    panelOperations.setLayout(new BorderLayout());
    panelOperations.setBackground(Color.DARK_GRAY);
    add(panelOperations, BorderLayout.CENTER);
    addInformation();
    addButtonsOperations();
  }

  private void addInformation() {    
    String[] columnNames = { "Placa", "Modelo", "Color", "propietario" };
    Object[][] data = LoadData();
    JTable table = new JTable(data, columnNames);
    ajustSizeColumns( table);
    JScrollPane scrollPane = new JScrollPane(table);
    table.setRowHeight(25);
    table.setFillsViewportHeight(true);
    panelOperations.add(scrollPane);
  }

   private void ajustSizeColumns(JTable table){
    sizeTable(table, 0, 40);
    sizeTable(table, 1, 40);
    sizeTable(table, 2, 40);
    sizeTable(table, 3, 250);
   }

  private void sizeTable(JTable table, int col, int size) {
    TableColumn column = table.getColumnModel().getColumn(col);
    column.setPreferredWidth(size);
  }

  // This method is temporary
  private Object[][] LoadData() {
    Object[][] data = {
      { "MYP123", "2020", "Rojo", "Juan Torres" },
      { "HCA911", "1990", "Azul", "Carlos Jose Apornte" },
      { "AAA765", "2000", "Amarillo", "Cristina Maria Perez" },
      { "MYP123", "2020", "Verde", "Diego Alberto Mesa" },
      { "HCA911", "1990", "Cyan", "Carlos Jose Apornte" },
      { "AAA765", "2000", "Negro", "Cristina Maria Perez" },
      { "MYP123", "2020", "Magenta", "Diego Alberto Mesa" },
      { "HCA911", "1990", "Rosado", "Carlos Jose Apornte" },
      { "AAA765", "2000", "Gris", "Cristina Maria Perez" },
      { "MYP123", "2020", "azul", "Diego Alberto Mesa" },
      { "HCA911", "1990", "Amarillo", "Carlos Jose Apornte" },
      { "AAA765", "2000", "azul", "Cristina Maria Perez" },
      { "MYP123", "2020", "azul", "Diego Alberto Mesa" },
      { "HCA911", "1990", "azul", "Carlos Jose Apornte" },
      { "AAA765", "2000", "Magenta", "Cristina Maria Perez" },
      { "MYP123", "2020", "azul", "Diego Alberto Mesa" },
      { "HCA911", "1990", "Gris", "Carlos Jose Apornte" },
      { "AAA765", "2000", "Verde", "Cristina Maria Perez" },
      { "MYP123", "2020", "azul", "Diego Alberto Mesa" },
      { "HCA911", "1990", "azul", "Carlos Jose Apornte" },
      { "AAA765", "2000", "azul", "Cristina Maria Perez" },
      { "MYP123", "2020", "azul", "Diego Alberto Mesa" },
      { "HCA911", "1990", "azul", "Carlos Jose Apornte" },
      { "AAA765", "2000", "azul", "Cristina Maria Perez" },
      { "MYP123", "2020", "azul", "Diego Alberto Mesa" },
      { "HCA911", "1990", "azul", "Carlos Jose Apornte" },
      { "AAA765", "2000", "azul", "Cristina Maria Perez" },
      { "MYP123", "2020", "azul", "Diego Alberto Mesa" },
      { "HCA911", "1990", "azul", "Carlos Jose Apornte" },
      { "AAA765", "2000", "azul", "Cristina Maria Perez" },
      { "MYP123", "2020", "azul", "Diego Alberto Mesa" },
      { "DUI712", "2023", "azul", "Juan Artuto Torres" },
    };
    return data;
  }

  private void addButtonsOperations() {
    JPanel panel = new JPanel();
    panel.setBackground(ColorPalette.COLOR_BACKGROUND_SECOND_MENU);
    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
    panel.setPreferredSize(new Dimension(150,100));
    panelOperations.add(panel, BorderLayout.EAST);
    addBtnNewVehicle( panel);
    addBtnModifyVehicle(panel);
    
  }


  


  private void addBtnNewVehicle(JPanel panel){
    JButton btn = new JButton("Nuevo");
    btn.setPreferredSize(new Dimension(100,30));
    panel.add(btn);
    btn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        DialogVehicle dialogVehicle = new DialogVehicle();
        dialogVehicle.setVisible(true);
      }
      
    });
  }

  private void addBtnModifyVehicle(JPanel panel){
    JButton btn = new JButton("Modificar");
    btn.setPreferredSize(new Dimension(100,30));
    panel.add(btn);
  }


}
