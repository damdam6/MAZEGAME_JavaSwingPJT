package UI;

import java.awt.Container;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


import Algo.MazeAlgoVer2;

public class Frame extends JFrame implements Runnable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2326387529684285733L;
	private static Frame instance = new Frame();
	private static Thread thr = new Thread(instance);
	
	MazePanel MP = MazePanel.getMPinst();
	GamePlayUI GP = GamePlayUI.getGPinst();
	StartPanel SP =StartPanel.getSPinst();
	EndPanel EP = EndPanel.getEPinst();
	MazeAlgoVer2 MA2 = MazeAlgoVer2.getMazeInst();
	
	// 메인 프레임선언
	private Frame() {

		// 805 825 // 여백에 따른 사이즈 고정
		this.setSize(800, 800);

//		this.setPreferredSize(new Dimension(800, 800));
		this.setTitle("미로게임!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		this.getContentPane().setLayout(getLayout());
		this.setVisible(true);
	}
	
	public static Frame getFRinst() {
		return instance;
	}
	public Thread getThread() {
		return thr;
	}
	
	public void run() {
	
		if(MainUI.PageNum == 0) {
			SP.MakeInput(this);
			
		}
		else if(MainUI.PageNum == 1) {
			SP.setVisible(false);
			GamePlayUI GP = GamePlayUI.getGPinst();
			GP.PlayGame(this, MainUI.MazeSize);
			KeyWorkGP();
		}
		
	}
	
	public void KeyWorkGP() {
		
		Container c = getContentPane();
		
		c.requestFocus();
		c.setFocusable(true);
		
		c.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_UP) {
						MP.DrawPlayer(-1, 0);
				}
				else if(key == KeyEvent.VK_DOWN) {
					MP.DrawPlayer(1, 0);

				}else if(key == KeyEvent.VK_RIGHT) {
					MP.DrawPlayer(0, 1);

				}else if(key== KeyEvent.VK_LEFT){
					MP.DrawPlayer(0, -1);

				}else if(key== KeyEvent.VK_SPACE) {
					
				}else {
					
				}
				
			}
		});
	}

}
