import Frames.showGame;
import info.CharacterInfo;

public class Game {	
	
	private static int y;
	
	public static void main(String[] args) {
		
		System.out.println("게임 시작");
		int x = 0;
		//y = 450;
		int money = 0;
		int time = 60;
		int jelly = 0;
		
		CharacterInfo c = new CharacterInfo(1, 1, x, y, money, time, jelly);

		showGame first = new showGame();
			
		first.setVisible(true);
		
	}
}
