package model.data;

public class CardData {
	private String name;
	private int speed;
	private int attack;
	private int deffence;
	private int shooting;
	private String imageUrl;
	
	public CardData(String name, int speed, int attack, int deffence,
			int shooting, String imageUrl) {
		super();
		this.name = name;
		this.speed = speed;
		this.attack = attack;
		this.deffence = deffence;
		this.shooting = shooting;
		this.imageUrl = imageUrl;
	}

	public CardData(){
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDeffence() {
		return deffence;
	}

	public void setDeffence(int deffence) {
		this.deffence = deffence;
	}

	public int getShooting() {
		return shooting;
	}

	public void setShooting(int shooting) {
		this.shooting = shooting;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "CardData [name=" + name + ", speed=" + speed + ", attack="
				+ attack + ", deffence=" + deffence + ", shooting=" + shooting
				+ ", imageUrl=" + imageUrl + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
