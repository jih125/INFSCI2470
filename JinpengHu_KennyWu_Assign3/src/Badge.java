import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @Class Badge
 * @author Jinpeng Hu, Kenny Wu
 * @created 02/04/2019
 */

public class Badge {
	
	public static final int LABEL_SIZE = 12;
	public static String name = "Ex: Kenny";
	public static String color = "Black";
	public static String shape = "oval";
	public static String bgColor = "White";
	public static String width1 = "150";
	public static String height1 = "150";
	public static String fontStyle = "regular";
	public static int fontSize = 20;
	private static JFrame badge;
	private static BadgePanel badgePanel;
	
	public static void main(String[] args) {
		badge();
	}
	
	public static void badge() {

		badge = new JFrame("Badge");
		badge.setSize(750, 400);
		badge.setLocationRelativeTo(null);
		badge.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font labelFont = new Font("Arial",Font.PLAIN,LABEL_SIZE);
		//Initialize widgets
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(82, 7, 36, 16);
		nameLabel.setFont(labelFont);
		
		JTextField nameField = new JTextField("Ex: Kenny");
		nameField.setBounds(27, 24, 147, 22);
		
		JLabel shapesLabel = new JLabel("Shapes:");
		shapesLabel.setBounds(78, 52, 45, 16);
		shapesLabel.setFont(labelFont);
		
		ImageIcon rectIcon = new ImageIcon("Image/thumbnail_Square.png");
		JButton rectButton = new JButton(rectIcon);
		rectButton.setBounds(27, 70, 49, 22);
		
		ImageIcon roundRectIcon = new ImageIcon("Image/thumbnail_Rounded.png");
		JButton roundRectButton = new JButton(roundRectIcon);
		roundRectButton.setBounds(76, 70, 49, 22);
		
		ImageIcon ovalIcon = new ImageIcon("Image/thumbnail_Oval.png");
		JButton ovalButton = new JButton(ovalIcon);
		ovalButton.setBounds(125, 70, 49, 22);
		
		JLabel widthLabel = new JLabel("Width:");
		widthLabel.setBounds(42, 98, 35, 16);
		widthLabel.setFont(labelFont);
		
		JLabel heightLabel = new JLabel("Height:");
		heightLabel.setBounds(122, 98, 39, 16);
		heightLabel.setFont(labelFont);

		JTextField widthField = new JTextField("150");
		widthField.setBounds(27, 116, 65, 22);
		
		JTextField heightField = new JTextField("150");
		heightField.setBounds(109, 116, 65, 22);
		
//		JSpinner heightSpinner = new JSpinner(new SpinnerNumberModel(height,1,null,10));
//		heightSpinner.setBounds(109, 116, 65, 22);
		
		JLabel fcLabel = new JLabel("Foreground Color:");
		fcLabel.setBounds(50, 144, 110, 16);
		fcLabel.setFont(labelFont);
		
		JLabel bcLabel = new JLabel("Background Color:");
		bcLabel.setBounds(50, 210, 110, 16);
		bcLabel.setFont(labelFont);
		
		JLabel fStyleLabel = new JLabel("Font Style:");
		fStyleLabel.setBounds(72, 279, 64, 16);
		fStyleLabel.setFont(labelFont);
		
		JLabel fSizeLabel = new JLabel("Font Size:");
		fSizeLabel.setBounds(74, 324, 64, 16);
		fSizeLabel.setFont(labelFont);
		
		JSpinner fSizeSpinner = new JSpinner(new SpinnerNumberModel(fontSize,1,null,2));
		fSizeSpinner.setBounds(27, 342, 147, 22);
		
		JButton boldButton = new JButton("B");
		boldButton.setFont(new Font("serif", Font.BOLD,14));
		boldButton.setBounds(27, 297, 49, 22);

		JButton italicButton = new JButton("I");
		italicButton.setFont(new Font("serif", Font.ITALIC,14));
		italicButton.setBounds(76, 297, 49, 22);

		JButton boldItalicButton = new JButton("BI");
		boldItalicButton.setFont(new Font("serif", Font.BOLD+Font.ITALIC,14));
		boldItalicButton.setBounds(125, 297, 49, 22);
		
		JButton save = new JButton("Save");
		save.setFont(labelFont);
		save.setBounds(615, 342, 110, 22);
		
		//Initialize panel and distribute the widgets
		JPanel controller = new JPanel();
		controller.setLayout(null);
		controller.setBounds(0, 0, 200, 400);
		controller.add(nameLabel);
		controller.add(nameField);
		controller.add(shapesLabel);
		controller.add(rectButton);
		controller.add(roundRectButton);
		controller.add(ovalButton);
		controller.add(widthLabel);
		controller.add(heightLabel);
		controller.add(fcLabel);
		controller.add(bcLabel);
		controller.add(fStyleLabel);
		controller.add(fSizeLabel);
		controller.add(fSizeSpinner);
		controller.add(boldButton);
		controller.add(italicButton);
		controller.add(boldItalicButton);
		controller.add(widthField);
		controller.add(heightField);
		
		ButtonPane fColorBoard = new ButtonPane("ForegroundC");
		fColorBoard.setBounds(27, 159, 147, 52);
		controller.add(fColorBoard,JLayeredPane.DEFAULT_LAYER);
		
		ButtonPane bColorBoard = new ButtonPane("BackgroundC");
		bColorBoard.setBounds(27, 225, 147, 52);
		controller.add(bColorBoard,JLayeredPane.DEFAULT_LAYER);		
		
		badgePanel = new BadgePanel(name,"oval","Black","150","150","regular",20);
		badgePanel.setBounds(225, 25, 500, 300);
		badgePanel.setBackground(Color.WHITE);
		badgePanel.setVisible(true);
		badge.add(badgePanel);
		badge.getContentPane().add(save);
		
		rectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shapeUpdate("rect");
			}
		});
		
		roundRectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shapeUpdate("roundRect");
			}
		});
		
		ovalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shapeUpdate("oval");
			}
		});
		
		boldButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fontUpdate("bold");
			}
		});
		
		italicButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fontUpdate("italic");
			}
		});
		
		boldItalicButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fontUpdate("bold italic");
			}
		});	
		
		fSizeSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int fSize = (int) fSizeSpinner.getValue();
				if(fSize > 0) {
				badgePanel.setFontSize(fSize);
				badge.add(badgePanel);
				badgePanel.repaint();
				}else {
					JOptionPane.showMessageDialog(null, "Your name is missing!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		
		nameField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				for(int i = 0;i< name.length();i++) {
					int cast = (int)name.charAt(i);
					if(cast>=48 && cast<=57) {
						JOptionPane.showMessageDialog(null, "Sorry, name only. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				if(!name.equals("")) {
					badgePanel.setName(name);
					badge.add(badgePanel);
					badgePanel.repaint();
				}else {
					JOptionPane.showMessageDialog(null, "Your name is missing! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		
		widthField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String width1 = widthField.getText();
				for(int i = 0;i< width1.length();i++) {
					int cast = (int)width1.charAt(i);
					if(cast<48||cast>57) {
						JOptionPane.showMessageDialog(null, "Sorry, number only. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				if(width1.equals("")) {
					JOptionPane.showMessageDialog(null, "Your width is missing! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}else {
					badgePanel.setWidth1(width1);
					badge.add(badgePanel);
					badgePanel.repaint();
				}
			}
		});
		
		heightField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String height1 = heightField.getText();
				for(int i = 0;i< height1.length();i++) {
					int cast = (int)height1.charAt(i);
					if(cast<48||cast>57) {
						JOptionPane.showMessageDialog(null, "Sorry, number only. Please try again.", "Error", JOptionPane.ERROR_MESSAGE); 
						return;
					}
				}
				if(!height1.equals("")) {
					badgePanel.setHeight1(height1);
					badge.add(badgePanel);
					badgePanel.repaint();
				}else {
					JOptionPane.showMessageDialog(null, "Your height is missing! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveCanvas(badgePanel);
			}
		});
		
		badge.setLayout(null);
		badge.add(controller);
		badge.setVisible(true);
	}
	
	public static void colorUpdate(String colorType,String color) {
		if(colorType.equals("ForegroundC")) {
			badgePanel.setColor(color);
		}else if(colorType.equals("BackgroundC")) {
			badgePanel.setBackground(badgePanel.getBgColor(color));
		}
		badge.add(badgePanel);
		badgePanel.repaint();
	}
	
	public static void fontUpdate(String fontStyle) {
		badgePanel.setFontStyle(fontStyle);
		badge.add(badgePanel);
		badgePanel.repaint();
	}
	
	public static void shapeUpdate(String shape) {
		badgePanel.setShape(shape);
		badge.add(badgePanel);
		badgePanel.repaint();
	}
	
	public static boolean isEmpty() {
		if (!badgePanel.getName().equals("") && !badgePanel.getWidth1().equals("") && !badgePanel.getHeight1().equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void saveCanvas(JPanel canvas) {
		BufferedImage image = new BufferedImage(canvas.getWidth(),canvas.getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D)image.getGraphics();
		
		canvas.paint(g);
		try {
			ImageIO.write(image, "png", new File("Image/canvas.png"));
		}catch(Exception e) {
			
		}
	}
}
