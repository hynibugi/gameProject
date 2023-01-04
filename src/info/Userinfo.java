package info;

public class Userinfo {
	private int no;
	private String id;
	private String password;
	private int money;
	public Userinfo(int no, String id, String password, int money) { //전적
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.money = money;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Userinfo [no=" + no + ", id=" + id + ", password=" + password + ", money=" + money + "]";
	}
	
	
}
