import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @Class ButtonPane
 * @author Kenny Wu
 * @created 02/05/2019
 */

public class ButtonPane extends JPanel {
	ArrayList<RoundedButton> buttons = new ArrayList<>();
	RoundedButton blue, cyan, green, orange, yellow, magenta, red, non, white, lightGray, gray, darkGray, black, pink;
	Color outColor = Color.black;
	String colorName = "";
	String color = "";
	
	public ButtonPane(String colorName) {
		
		this.colorName = colorName;
		
		JPanel p = new JPanel();		
        p.setPreferredSize(new Dimension(147, 45));
		p.setLayout(new GridLayout(2,7));
		
    	blue = new RoundedButton(Color.blue);
    	cyan = new RoundedButton(Color.cyan);
    	green = new RoundedButton(Color.green);
    	orange = new RoundedButton(Color.orange);
    	yellow = new RoundedButton(Color.yellow);
    	magenta = new RoundedButton(Color.magenta);
    	red = new RoundedButton(Color.red);
    	white = new RoundedButton(Color.white);
    	lightGray = new RoundedButton(Color.lightGray);
    	gray = new RoundedButton(Color.gray);
    	darkGray = new RoundedButton(Color.darkGray);
    	black = new RoundedButton(Color.black);
    	pink = new RoundedButton(Color.pink);
    	non = new RoundedButton(new Color(255,255,255,0));
    	
    	Collections.addAll(buttons, blue, cyan, green, orange, yellow, magenta, red, white, lightGray, gray, darkGray, black, pink, non);
        ButtonHandler handler = new ButtonHandler();
        for (RoundedButton button : buttons) {
    		button.addActionListener(handler);
    		p.add(button);
    	}
        
		int offsetX = (getInsets().left + getInsets().right);
		int offsetY = (getInsets().top + getInsets().bottom);
        
        setSize(127 + offsetX, 28 + offsetY);
        setVisible(true);
        
        add(p);
	}
	
	public Color outColor () {
		return outColor;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public class ButtonHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		final RoundedButton source = (RoundedButton)e.getSource();
			if (source == blue) {
				non.nonNewColor = Color.blue;
				color = "Blue";
				Badge.colorUpdate(colorName, color);
			} else if (source == cyan) {
				non.nonNewColor = Color.cyan;
				color = "Cyan";
				Badge.colorUpdate(colorName, color);
			} else if (source == green) {
				non.nonNewColor = Color.green;
				color = "Green";
				Badge.colorUpdate(colorName, color);
			} else if (source == orange) {
				non.nonNewColor = Color.orange;
				color = "Orange";
				Badge.colorUpdate(colorName, color);
			} else if (source == yellow) {
				non.nonNewColor = Color.yellow;
				color = "Yellow";
				Badge.colorUpdate(colorName, color);
			} else if (source == magenta) {
				non.nonNewColor = Color.magenta;
				color = "Magenta";
				Badge.colorUpdate(colorName, color);
			} else if (source == red) {
				non.nonNewColor = Color.red;
				color = "Red";
				Badge.colorUpdate(colorName, color);
			} else if (source == white) {
				non.nonNewColor = Color.white;
				color = "White";
				Badge.colorUpdate(colorName, color);
			} else if (source == lightGray) {
				non.nonNewColor = Color.lightGray;
				color = "Light Gray";
				Badge.colorUpdate(colorName, color);
			} else if (source == gray) {
				non.nonNewColor = Color.gray;
				color = "Gray";
				Badge.colorUpdate(colorName, color);
			} else if (source == darkGray) {
				non.nonNewColor = Color.darkGray;
				color = "Dark Gray";
				Badge.colorUpdate(colorName, color);
			} else if (source == black) {
				non.nonNewColor = Color.black;
				color = "Black";
				Badge.colorUpdate(colorName, color);
			} else if (source == pink) {
				non.nonNewColor = Color.pink;
				color = "Pink";
				Badge.colorUpdate(colorName, color);
			}
			revalidate();
			repaint();
    	}
    }
}
