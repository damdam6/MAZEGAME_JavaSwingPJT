package UI;

import javax.swing.JFrame;


public class GamePlayUI {
	
	private static GamePlayUI instance = new GamePlayUI();
	
	private GamePlayUI() {
		
	}
	public static GamePlayUI getGPinst() {	
		return instance;
	}
	
	static MazePanel MP = MazePanel.getMPinst();
	
	//메이즈 크기 - 알고리즘 고르기
	public void PlayGame(JFrame JF, int maze_size) {
		
		
		//미로 사이즈 결정
		MP.setblocksize(maze_size);

		
		//maze 콘솔에 프린트
//		map.MazePrint(mazeArray);
			
		JF.getContentPane().add(MP);
		
		
		MP.DrawBlocks();
		
		//임시 고정 위치들
		MP.DrawPlayer(1,1);
		MP.DrawStartP(maze_size-2, maze_size-2);
	}
	
	public void EndGame() {

		MP.setVisible(false);
	}

}
