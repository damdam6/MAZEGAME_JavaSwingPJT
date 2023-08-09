package UI;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


import Algo.MazeAlgoVer2;
import ImgSet.MazeImg;

public class MazePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3076642019499704932L;


	MazeAlgoVer2 MA2 = MazeAlgoVer2.getMazeInst();
		

	// Grid패널에 알고리즘에 따라 붙이기
	// 캐릭터 이동 등 고려
	// 패널 최종 생성 후 return

	int maze_size;
	int[][] raw_map;
	JLabel[][] jpArray;
	MazeImg MI = MazeImg.getImgInst();
	
	
	private static MazePanel instance = new MazePanel();
	
	public static MazePanel getMPinst() {
		return instance;
	}
	

	//패널생성
	private MazePanel() {
		this.setPreferredSize(new Dimension(800, 800));
		this.setBounds(0, 0, 800, 800);		
		
	}
	
	//미로 사이즈 받아서 설정하기
	public void setblocksize(int maze_size) {
		this.setLayout(new GridLayout(maze_size, maze_size));
		this.maze_size = maze_size;
		//미로 알고리즘 변경
		this.raw_map = MA2.MakeM(maze_size);
		
		this.jpArray = new JLabel[maze_size][maze_size];
		MI.setblocksize(800/maze_size);
	}



	public void DrawBlocks() {		

		for (int i = 0; i < maze_size; i++) {
			for (int j = 0; j < maze_size; j++) {
				jpArray[i][j] = MI.getJL();
				
				if(raw_map[i][j] == 0) {
					MI.setBlackIcon(jpArray[i][j]);
				}else {
					MI.setWhiteIcon(jpArray[i][j]);
				}				
				this.add(jpArray[i][j]);
			}
		}
			
	}
	
	public void DrawPlayer(int gox, int goy) {
		if(raw_map[MainUI.player_x+gox][MainUI.player_y+goy] != 0) {
			MI.setPlayerIcon(jpArray[MainUI.player_x+gox][MainUI.player_y+goy]);
			//player 이전에 존재한 위치에 새로 그리는 명령어
			DrawRe(MainUI.player_x, MainUI.player_y);
			
			MainUI.player_x = MainUI.player_x+gox;
			MainUI.player_y = MainUI.player_y+goy;
			if(MainUI.player_x == jpArray.length-2 && MainUI.player_y == jpArray.length-2 ) {
				MainUI.PageNum = 2;
				this.setVisible(false);
				EndPanel EP = EndPanel.getEPinst();
				EP.EndGame(MainUI.MainFrame);
				EP.setVisible(true);
			}
		}

		
		
	}
	public void DrawStartP(int x, int y) {
		MI.setStartIcon(jpArray[x][y]);
	}
	public void DrawRe(int x, int y) {
		if(raw_map[x][y] == 0) {
			MI.setBlackIcon(jpArray[x][y]);
		}else {
			MI.setWhiteIcon(jpArray[x][y]);
		}
		
	}

}
