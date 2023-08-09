package UI;

import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Image;


import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class EndPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7891209224736867047L;

	private Image EndBack = new ImageIcon(EndPanel.class.getResource("/img/Win_Page.png")).getImage();

	private static EndPanel instance = new EndPanel();
	
	public void paint(Graphics g) {
		g.drawImage(EndBack, 0, 0, null);
	}

	private EndPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setPreferredSize(new Dimension(800, 800));
		this.setBounds(0, 0, 800, 800);

	}

	public static EndPanel getEPinst() {
		return instance;
	}


	public void EndGame(JFrame JF) {
		this.setVisible(true);
		JF.getContentPane().add(this);
	}
	
}
