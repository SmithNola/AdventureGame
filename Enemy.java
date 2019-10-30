public class Enemy {
	private int health;
	private String type;
	private String weapon;
	
	public void setHealth(int newHealth){
		this.health=newHealth;
	}
	
	public int getHealth(){
		return health;
	}
	
	public void setType(String newType){
		this.type=newType;
	}
	
	public String getType(){
		return type;
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
		case "Teeth":
			weapond=13;
			break;
		case "Axe":
			weapond=20;
			break;
		}
		return weapond;
	}
	
}
