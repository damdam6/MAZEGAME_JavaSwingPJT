package UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class StartPanel extends JPanel{
	

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6362791845721411054L;
	TextField textF;
	int mazesize;
	
	private Image  startBack = new ImageIcon(StartPanel.class.getResource("/img/Start_Page.png")).getImage();
	
	private static StartPanel instance = new StartPanel();
	private StartPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setPreferredSize(new Dimension(800, 800));
		this.setBounds(0, 0, 800, 800);	
		this.setBorder(BorderFactory.createEmptyBorder(
				300,300,300,300));
	}
	public static StartPanel getSPinst() {
		return instance;
	}
	
	public void paint(Graphics g) {
		g.drawImage(startBack, 0, 0, null);
	}
	public void MakeInput(JFrame JF) {
		JPanel tempJP = new JPanel();
		textF = new TextField(9);
		tempJP.add(textF);
		JButton button = new JButton("확인");
		
		//버튼 액션 연결
		button.addActionListener(new Listener(this));
		
		tempJP.add(button);
	
		
		this.add(tempJP);
		JF.getContentPane().add(this);
				
	}
	
	
	class Listener implements ActionListener{
		StartPanel frame;
		public Listener(StartPanel startPanel){
			frame =startPanel;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String inputSize = (textF).getText();
			mazesize = Integer.valueOf(inputSize);
			
			MainUI.MazeSize = returnOdd(mazesize);
			MainUI.PageNum = 1;
			MainUI.MainFrame.getThread().start();
			
		}
		
		public int returnOdd(int i) {
			if(i%2 ==0) {
				return i+1;
			}else if(i<11) {
				return 11;
			}
			return i;
		}
	}

}
