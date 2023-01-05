package info;

public class Userinfo {

	private String id;
	private String password;
	private String nickname;
	private int money;
	
	
	public Userinfo(String id, String password, String nickname) {
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
	}

	public Userinfo(String id, String password, String nickname, int money) {
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.money = money;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Userinfo [id=" + id + ", password=" + password + ", nickname=" + nickname + ", money=" + money + "]";
	}
	
	
	
}
