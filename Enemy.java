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
	
}
