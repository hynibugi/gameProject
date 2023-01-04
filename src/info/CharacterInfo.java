package info;

public class CharacterInfo {
	// 게임중인 캐릭터 (쿠키)

	private int no;
	private int who;
	private int x;
	private int y;
	private int money;
	private int time;
	private int jelly;
	
	
	public CharacterInfo(int no, int who, int x, int y, int money, int time, int jelly) {
		super();
		this.no = no;
		this.who = who;
		this.x = x;
		this.y = y;
		this.money = money;
		this.time = time;
		this.jelly = jelly;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getWho() {
		return who;
	}
	public void setWho(int who) {
		this.who = who;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getJelly() {
		return jelly;
	}
	public void setJelly(int jelly) {
		this.jelly = jelly;
	}
	@Override
	public String toString() {
		return "CharacterInfo [no=" + no + ", who=" + who + ", x=" + x + ", y=" + y + ", money=" + money + ", time="
				+ time + ", jelly=" + jelly + "]";
	}
}