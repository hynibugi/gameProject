//신경안쓰셔도 됨니당
//import java.awt.image.BufferedImage;
//import java.awt.image.PixelGrabber;
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;
//
//public class Bf2 {
//	ImageIcon step = new ImageIcon("step.png");
//
//	List<Foot> filedList = new ArrayList<>(); // 발판리스트
//
//	int[][] colorArr; // x,y좌표의 색을 저장하는 배열
//	int[] sizeArr; // 이미지 사이즈 가져오는 배열
//
//	static int[] getSize1(String src) throws Exception { // 이미지의 사이즈를 가져오는 메서드
//		File imgf = new File(src); // 이미지 경로를 입력받아서 파일객체를 만든다.
//		BufferedImage img = ImageIO.read(imgf); // 이미지를 버퍼드이미지에 넣는다.
//		int width = img.getWidth(); // 이미지의 넓이
//		int height = img.getHeight(); // 이미지의 높이
//		int[] tempPos = { width, height }; // 넓이 높이를 배열로 만든다.
//		return tempPos; // 리턴한다.
//	}
//
//	class MyPanel extends JPanel {
//
//		public MyPanel() {
//
//			setFocusable(true);
//
//			try {
//
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
//	}
//}