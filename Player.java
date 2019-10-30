public class Player {
	private int health=50;
	private String weapon="Bronze Sword";
	
	
	public void setHealth(int newHealth) {
		this.health = newHealth;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setWeapon(String newWeapon){
		this.weapon=newWeapon;
	}
	
	public String getWeapon(){
		return weapon;
	}
	
	public int weapond(){//sets weapon damage based on current weapon
		int weapond = 0;
		switch(this.weapon){
		case "Wooden Sword":
			weapond=5;
			break;
		case "Bronze Sword":
			weapond=10;
			break;
		case "Silver Sword":
			weapond=15;
			break;
		}
		return weapond;
	}
}
