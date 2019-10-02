public class Player {
	private double money;
	private String name;
	private String weapon;
	private String [] armor;
	private int position;
	private int health;
	private int totalHealth;
	private String [] potions;
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String getName() {
		return name;
	}
}
