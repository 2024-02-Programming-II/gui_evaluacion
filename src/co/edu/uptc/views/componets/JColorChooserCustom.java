package co.edu.uptc.views.componets;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

import co.edu.uptc.views.palettes.ColorPalette;

public class JColorChooserCustom extends JColorChooser{
    

    public JColorChooserCustom(){    
        
          setOpaque(true); 
          setBackground(ColorPalette.COLOR_BACKGROUND_INFO); 
          custom();
    }

    private void custom(){
          
          for (int i = 0; i < getComponentCount(); i++) {                       
            JComponent hh = (JComponent) getComponent(i);
            for (int j = 0; j < hh.getComponentCount(); j++) {
              
              hh.getComponent(j).setBackground(
                  new ColorUIResource(ColorPalette.COLOR_BACKGROUND_INFO)
                );

              if ("javax.swing.JPanel".equals(hh.getComponent(j).getClass().getName())) {
                JPanel pp = (JPanel) hh.getComponent(j);
                for (int k = 0; k < pp.getComponentCount(); k++) {
                  pp.getComponent(k).setBackground(
                      new ColorUIResource(ColorPalette.COLOR_BACKGROUND_INFO)
                    );
                }
              }
              
            }
            if (getComponent(i).getClass().getName().equals("javax.swing.JPanel")
            ) {
              hh = (JPanel) getComponent(i);
              hh.setBackground(ColorPalette.COLOR_BACKGROUND_INFO);
            
              for (int j = 0; j < hh.getComponentCount(); j++) {                
                hh.getComponent(j).setBackground(
                    new ColorUIResource(ColorPalette.COLOR_BACKGROUND_INFO)
                  );
              }
            }
          }


        //   JDialog dialog = JColorChooser.createDialog(
        //     null,
        //     "Seleccionar Color",
        //     true,
        //     this,
        //     actionEvent -> {

        //       Color selectedColor = getColor();
        //       if (selectedColor != null) {

        //      //   btnCarColor.setBackground(selectedColor);
        //       }
        //     },
        //     null
        //   );


          
        //   for (int i = 0; i < dialog.getContentPane().getComponentCount(); i++) {
        //      System.out.println("aaaaaaaaaa:  "+dialog.getContentPane().getComponent(i).getClass().getName()); 
        //      dialog.getContentPane().getComponent(i).setBackground(ColorPalette.COLOR_BACKGROUND_STATUS_BAR);
        //   }
        //   dialog.setVisible(true);
    }
}
