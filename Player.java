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
}
