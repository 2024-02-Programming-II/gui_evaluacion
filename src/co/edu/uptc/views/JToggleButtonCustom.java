package co.edu.uptc.views;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.plaf.metal.MetalToggleButtonUI;

public class JToggleButtonCustom extends JToggleButton {

  private static final int RADIUS = 35;

  private Color backgroundSelected = Color.RED;
  public Color background = new Color(100, 100, 0);

  public JToggleButtonCustom() {
    setFocusPainted(false); 
    setBorderPainted(false);
    setFocusable(false);
    background = getBackground();
    setHorizontalAlignment(SwingConstants.LEFT);
    setHideActionText(false);
    setUI(
      new MetalToggleButtonUI() {
        @Override
        protected Color getSelectColor() {
          return new Color(0, 0, 0, 0);         
        }
      }
    );
  }

  public void setBackgroundSelected(Color color) {
    this.backgroundSelected = color;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (isSelected()) {
      g.setColor(backgroundSelected);
      g.fillRoundRect(0, 0, getWidth(), getHeight(), RADIUS, RADIUS);
      g.setColor(getForeground());   
      g.drawString(getText(), getInsets().left, (getHeight()/2)+5);
    }
  }
}
