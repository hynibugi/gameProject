import java.awt.Image;

public class Jelly {
	
	private int jellyX;
	private int jellyY;
	private Image imJelly;
	
	
	public Jelly(int jellyX, int jellyY, Image imJelly) {
		super();
		this.jellyX = jellyX;
		this.jellyY = jellyY;
		this.imJelly = imJelly;
	}
	
	public int getJellyX() {
		return jellyX;
	}
	public void setJellyX(int jellyX) {
		this.jellyX = jellyX;
	}
	public int getJellyY() {
		return jellyY;
	}
	public void setJellyY(int jellyY) {
		this.jellyY = jellyY;
	}

	public Image getImJelly() {
		return imJelly;
	}

	public void setImJelly(Image imJelly) {
		this.imJelly = imJelly;
	}
	
	

}
