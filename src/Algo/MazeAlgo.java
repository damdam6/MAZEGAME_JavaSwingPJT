package Algo;

import java.util.Random;

public class MazeAlgo {
	
	//싱글턴으로 미로 하나만 생성
	private static MazeAlgo instance = new MazeAlgo();
	private MazeAlgo() {}	
	public static MazeAlgo getMazeInst() {
		return instance;
	}

	
	//미로 만드는 알고리즘
	public int[][] MakeM(int x) {
		int[][] Maze = new int[x][x];

		// 초기 값은 -1로 설정
		for (int i = 0; i < Maze[0].length; i++) {
			for (int j = 0; j < Maze.length; j++) {
				Maze[i][j] = -1;
				// 짝수 지점 -> 갈 수 있는 공간으로 설정
				if (i % 2 == 1 && j % 2 == 1) {
					Maze[i][j] = 1;
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



		// 오른쪽o아래쪽으로만 뚫기 -> 길이 다 안이엊
		int[][] move2 = { { 1, 0 }, { 0, 1 } };
		int k;
		Random random = new Random();
		// random.nextInt(4)
		for (int i = 1; i < Maze[0].length; i += 2) {
			for (int j = 1; j < Maze.length; j += 2) {
				k = random.nextInt(2);
				if (Maze[i + move2[k][0]][j + move2[k][1]] != 0) {
					Maze[i + move2[k][0]][j + move2[k][1]] = 1;
				} else if (i == Maze[0].length - 2 && j == Maze[0].length - 2) {
				} else {
					k = Math.abs(k - 1);
					Maze[i + move2[k][0]][j + move2[k][1]] = 1;
				}
			}
		}

		for (int i = 0; i < Maze[0].length; i++) {
			for (int j = 0; j < Maze.length; j++) {
				if (Maze[i][j] == 2) {
					Maze[i][j] = 0;
				}
			}

		}

		return Maze;
	}
	
	
	public void MazePrint(int[][] Maze) {
		// 미로 프린트용//
		for (int i = 0; i < Maze[0].length; i++) {
			for (int j = 0; j < Maze.length; j++) {
				System.out.print(Maze[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

}
