
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.awt.FontMetrics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @class RoundedButton
 * @author Kenny Wu
 * @created 02/05/2019
 */

public class RoundedButton extends JButton {
	boolean mouseOver = false;
	boolean mousePressed = false;
	Color initialColor;
	Color newColor = new Color(165, 42, 42);
	Color nonNewColor = new Color(255, 255, 255, 0);
	private String name;
	
	public RoundedButton (Color initial) {
//		this.name = name;
		initialColor = initial;
		setOpaque(false);
		setFocusPainted(false);
		setBorderPainted(false);
		MouseAdapter mouseListener = new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent m) {
				mousePressed = true;
				repaint();
			}		
		};
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
		
	}
	
	private int getDiameter() {
		int diameter = 19;
		return diameter;
	}
	
	@Override
	public boolean contains(int x, int y) {
		int radius = getDiameter()/2;
		return Point2D.distance(x, y, getWidth()/2, getHeight()/2) < radius;
	}
	
	@Override
	public Dimension getPreferredSize() {
		FontMetrics metrics = getGraphics().getFontMetrics(getFont());
		int minDiameter = 10 + Math.max(metrics.stringWidth(getText()), metrics.getHeight());
		return new Dimension(minDiameter, minDiameter);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int diameter = getDiameter();
		int radius = diameter/2;
		
		if (initialColor.getAlpha() == 0) {
			g.setColor(Color.black);
			g.drawOval(getWidth()/2 - radius, getHeight()/2 - radius, diameter, diameter);
			g.setColor(nonNewColor);
			g.fillOval(getWidth()/2 - radius, getHeight()/2 - radius, diameter, diameter);
		} else {
			if (mousePressed) {
				g.setColor(Color.black);
				g.fillOval(getWidth()/2 - radius, getHeight()/2 - radius, diameter, diameter);
				g.setColor(initialColor);
				g.fillOval(getWidth()/2 - radius + 3, getHeight()/2 - radius + 3, diameter - 6, diameter - 6);
				mousePressed = false;
			} else {
				g.setColor(initialColor);
				g.fillOval(getWidth()/2 - radius, getHeight()/2 - radius, diameter, diameter);
			}
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
