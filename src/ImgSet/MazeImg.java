package ImgSet;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MazeImg extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8210268688875983702L;


	int setblocksize;

	
	private ImageIcon iconBlack = new ImageIcon(MazeImg.class.getResource("/img/box_black.png"));
	private ImageIcon iconWhite = new ImageIcon(MazeImg.class.getResource("/img/box_white.png"));
	private ImageIcon iconPlayer = new ImageIcon(MazeImg.class.getResource("/img/Player_OH.png"));
	private ImageIcon iconStartPoint = new ImageIcon(MazeImg.class.getResource("/img/point_start.png"));
	//싱글턴
	private static MazeImg mazeImg = new MazeImg();
	private MazeImg() {		
	}
	public static MazeImg getImgInst() {	
		return mazeImg;
	}
	

	
	//미로용 JL한 칸
	public JLabel getJL() {
		JLabel JL = new JLabel();
		return JL;
	}
	
	//라벨 색칠하기
	public void setBlackIcon(JLabel JL) {
		JL.setIcon(iconBlack);
	}
	public void setWhiteIcon(JLabel JL) {
		JL.setIcon(iconWhite);
	}
	public void setPlayerIcon(JLabel JL) {
		this.setPlayersize(this.setblocksize);
		JL.setIcon(iconPlayer);
	}
	public void setStartIcon(JLabel JL) {
		this.setStartsize(this.setblocksize);
		JL.setIcon(iconStartPoint);
	}

	
	//block사이즈 받아오는 함수
	public void setblocksize(int blocksize) {
		this.setblocksize = blocksize;
	}
	
	//이미지 사이즈 조절한 아이콘 반환
	//이미지 설정 변경시 1회 사용
	private void setPlayersize(int blocksize) {
		Image imageImg = (this.iconPlayer).getImage();
		imageImg = imageImg.getScaledInstance(blocksize, blocksize, Image.SCALE_DEFAULT);
		this.iconPlayer = new ImageIcon(imageImg);	
	}
	//문 사이즈 변경-icon추가해야됨
	private void setStartsize(int blocksize) {
		Image imageImg = (this.iconStartPoint).getImage();
		imageImg = imageImg.getScaledInstance(blocksize, blocksize, Image.SCALE_DEFAULT);
		this.iconStartPoint = new ImageIcon(imageImg);	
	}
	

}
