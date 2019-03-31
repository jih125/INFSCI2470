import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

/**
 * Class BadgePanel
 * @author Jinpeng Hu
 * @created 02/04/2019
 */

public class BadgePanel extends JPanel {

	private String name;
	private String shape;
	private String color;
	private int width;
	private int height;
	private String fontStyle;
	private int fontSize;
	private String width1;
	private String height1;
	
public BadgePanel() {
		this.name = "?";
		this.shape = "oval";
		this.color = "black";
		this.width1 = "150";
		this.height1 = "150";
		this.fontStyle = "regular";
		this.fontSize = 20;
	}
	
	//Constructor
	public BadgePanel(String name,String shape,String color,String width1,String height1,String fontStyle,int fontSize) {
		this.name = name;
		this.shape = shape;
		this.color = color;
		this.width1 = width1;
		this.height1 = height1;
		this.fontStyle = fontStyle;
		this.fontSize = fontSize;		
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		//Set the color
		g.setColor(getColor(color));
		
		//Transfer the strings to integers
		width = Integer.parseInt(width1);
		height = Integer.parseInt(height1);
		
		//Define the type and size of the shape
		Dimension d = getSize();

		if (width > d.width || height > d.height) {
			width = d.width;
			height = d.height;
		}

		int shapeX = (d.width - width) / 2;
		int shapeY = (d.height - height) / 2;
	
		if (shape.equalsIgnoreCase("oval")) {
			g.drawOval(shapeX, shapeY, width, height);
		} else if (shape.equalsIgnoreCase("rect")) {
			g.drawRect(shapeX, shapeY, width, height);
		} else if (shape.equalsIgnoreCase("roundrect")) {
			g.drawRoundRect(shapeX, shapeY, width, height, 60, 60);
		}
		

		//Set the strings
		String string1 = "Hello";
		String string2  = "My name is";
		
		//Define the font and their location information
		Font font = getFont(fontStyle);
		FontMetrics fm = g.getFontMetrics(font);
		g.setFont(font);

		int totalWidth1 = fm.stringWidth(string1);
		int totalWidth2 = fm.stringWidth(string2);
		int totalWidth3 = fm.stringWidth(name);
		int textX1 = (width - totalWidth1) / 2 + shapeX;
		int textX2 = (width - totalWidth2) / 2 + shapeX;
		int textX3 = (width - totalWidth3) / 2 + shapeX;
		int textY1 = (height - fm.getHeight()) / 2 + shapeY - fm.getAscent();
		int textY2 = (height - fm.getHeight()) / 2 + shapeY + fm.getAscent();
		int textY3 = (height - fm.getHeight()) / 2 + shapeY + fm.getAscent()*3;
		
		//If the strings are oversized then the system will show the message
		int minTextX = (textX1 > textX2 ? (textX2 > textX3 ? textX3 : textX2) : (textX1 > textX3 ? textX3 : textX1));
		if (minTextX <= shapeX || shapeY >= textY1 || (shapeY+height) <= textY3) {
			g.drawString(string1, textX1, textY1);
			g.drawString(string2, textX2, textY2);
			g.drawString(name, textX3, textY3);
//			JOptionPane.showMessageDialog(null, "Your text is oversized","Error",JOptionPane.ERROR_MESSAGE);
//			return;
			g.setFont(new Font("serif",Font.PLAIN,20));
			g.drawString("Error: Your text is oversized!", 250, 285);
		} else {
			g.drawString(string1, textX1, textY1);
			g.drawString(string2, textX2, textY2);
			g.drawString(name, textX3, textY3);
		}
	}
	
	//Color getter
	public Color getColor(String colorName) {

		//Set the colors with Hash map
		Map<String, Color> colorMap = new HashMap<>();
		colorMap.put("Black", Color.black);
		colorMap.put("Blue", Color.blue);
		colorMap.put("Cyan", Color.CYAN);
		colorMap.put("Dark Gray", Color.darkGray);
		colorMap.put("Gray", Color.gray);
		colorMap.put("Green", Color.green);
		colorMap.put("Light Gray", Color.lightGray);
		colorMap.put("Magenta", Color.magenta);
		colorMap.put("Orange", Color.orange);
		colorMap.put("Pink", Color.pink);
		colorMap.put("Red", Color.red);
		colorMap.put("White", Color.white);
		colorMap.put("Yellow", Color.yellow);

		Color c = colorMap.get(colorName);
		return c;
	}
	
	//Font style getter
	public Font getFont(String fontStyle) {

		//Set the default font
		Font font = new Font("serif", Font.BOLD, fontSize);

		if (fontStyle.equalsIgnoreCase("bold")) {
			font = new Font("serif", Font.BOLD, fontSize);
		} else if (fontStyle.equalsIgnoreCase("regular")) {
			font = new Font("serif", Font.PLAIN, fontSize);
		} else if (fontStyle.equalsIgnoreCase("italic")) {
			font = new Font("serif", Font.ITALIC, fontSize);
		} else if (fontStyle.equalsIgnoreCase("bold italic")) {
			font = new Font("serif", Font.ITALIC + Font.BOLD, fontSize);
		}
		return font;

	}
	
	//Background color getter
	public Color getBgColor(String colorName) {
		Color c = getColor(colorName);
		return c;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getWidth1() {
		return this.width1;
	}
	
	public String getHeight1() {
		return this.height1;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setShape(String shape) {
		this.shape = shape;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setWidth1(String width1) {
		this.width1 = width1;
	}
	
	public void setHeight1(String height1) {
		this.height1 = height1;
	}
	
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	
	public void setFontStyle(String fontStyle) {
		this.fontStyle = fontStyle;
	}
	
}
