package Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MazeAlgoVer2 {
	// 싱글턴으로 미로 하나만 생성
	private static MazeAlgoVer2 instance = new MazeAlgoVer2();

	private MazeAlgoVer2() {
	}

	public static MazeAlgoVer2 getMazeInst() {
		return instance;
	}

	// 미로 만드는 알고리즘
	public int[][] MakeM(int x) {
		int[][] Maze = new int[x][x];

		// 초기 값은 -1로 설정
		for (int i = 0; i < Maze[0].length; i++) {
			for (int j = 0; j < Maze.length; j++) {
				Maze[i][j] = -1;
				// 짝수 지점 -> 갈 수 있는 공간으로 설정
				if (i % 2 == 1 && j % 2 == 1) {
					Maze[i][j] = 2;
				} // 양테두리 -> 벽으로 설정
				else if (i == 0 || j == 0 || i == Maze[0].length - 1 || j == Maze[0].length - 1) {
					Maze[i][j] = 0;
				} // 대각선 방향 -> 벽으로 설정
				else if (i % 2 == 0 && j % 2 == 0) {
					Maze[i][j] = 0;
				} else {
					// 그외 -> 수정 가능한 영역
					Maze[i][j] = 2;
				}
			}
		}
		

		this.Maze = Maze;;

		MazeAlgo2(1,1);
		
		
		return this.Maze;
	}

//	k = random.nextInt(2);
	Random random = new Random();

	// 상[-1,0], 하[1,0] 좌[0,-1] 우[0,1]
	// 상0 하1 좌2 우3
	int[][] move = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
	int[][] moveTwo = { { 0, -2 }, { 0, 2 }, { -2, 0 }, { 2, 0 } };
	int[][] Maze;
	
	int cnt = 0;

	// 0:벽 1:길 2:갈 수 있는 길 3: 지금 지나온길
	public void MazeAlgo2(int x, int y) {

		Maze[x][y] = 3;

		//1칸 가는 배열 & 2칸 가는 배열
		//1칸은 벽 - 2칸은 너머의 길 체크
		ArrayList<int[]> dir = new ArrayList<>(Arrays.asList(move));
		ArrayList<int[]> dirTwo = new ArrayList<>(Arrays.asList(moveTwo));


		//네 방향으로 반복
		while (dir.size() != 0) {
			
			
			int goDir = random.nextInt(dir.size());
			int gox = x+dirTwo.get(goDir)[0];
			int goy = y +dirTwo.get(goDir)[1];
			int nextx = x+dir.get(goDir)[0];
			int nexty = y+dir.get(goDir)[1];
			
			if(gox <0 || gox >= Maze[0].length || goy <0 ||goy >=Maze[0].length) {
				//1. 범위를 넘어간 경우 -> 해당 방향 제거
				dir.remove(goDir);
				dirTwo.remove(goDir);
				
			}
			else if((Maze[gox][goy]==1 || Maze[gox][goy]==3 )&& Maze[nextx][nexty] !=1){
				//2. 한 칸 너머가 길일 경우 -> 벽으로 만들기 / 해당 방향 제거
				Maze[nextx][nexty] = 0;				
				dir.remove(goDir);
				dirTwo.remove(goDir);
				
				
			}else if(Maze[gox][goy]==3 && Maze[nextx][nexty] ==1 ) {
				dir.remove(goDir);
				dirTwo.remove(goDir);
			}else {
				Maze[nextx][nexty] = 1;
				Maze[gox][goy]= 3;
				dir.remove(goDir);
				dirTwo.remove(goDir);
				//그 외의 경우 -> 재귀 함수 실행
				MazeAlgo2(gox, goy);
			}
			
			
		} //while의 종료
		//while이 종료되면 1로 바꿔준다->확정루트
		Maze[x][y] = 1;
	}
	
	
	public int[][] getMaze(){
		return Maze;
	}
	
	public void MazePrint2(int[][] Maze) {
		// 미로 프린트용//
		for (int i = 0; i < Maze[0].length; i++) {
			for (int j = 0; j < Maze.length; j++) {
				System.out.print(Maze[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
