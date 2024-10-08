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
            JComponent auxComponent = (JComponent) getComponent(i);
            for (int pos = 0; pos < auxComponent.getComponentCount(); pos++) {              
              auxComponent.getComponent(pos).setBackground(
                  new ColorUIResource(ColorPalette.COLOR_BACKGROUND_INFO)
                );
                setColorFatherComponets( auxComponent,pos );
                setColorChildrenComponets( auxComponent,i );              
            }            
          }
    }

    private void setColorFatherComponets(JComponent auxComponent, int pos ){
      if ("javax.swing.JPanel".equals(auxComponent.getComponent(pos).getClass().getName())) {
        JPanel pp = (JPanel) auxComponent.getComponent(pos);
        for (int k = 0; k < pp.getComponentCount(); k++) {
          pp.getComponent(k).setBackground(
              new ColorUIResource(ColorPalette.COLOR_BACKGROUND_INFO)
            );
        }
      }
    }


    private void setColorChildrenComponets(JComponent auxComponent, int pos ){
      if (getComponent(pos).getClass().getName().equals("javax.swing.JPanel")) {
        auxComponent = (JPanel) getComponent(pos);
        auxComponent.setBackground(ColorPalette.COLOR_BACKGROUND_INFO);
      
        for (int j = 0; j < auxComponent.getComponentCount(); j++) {                
          auxComponent.getComponent(j).setBackground(
              new ColorUIResource(ColorPalette.COLOR_BACKGROUND_INFO)
            );
        }
      }
    }
}
