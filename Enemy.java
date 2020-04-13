import java.util.Random; 
public class Enemy {
	private int health;
	private String type;
	private String weapon;
	
	public Enemy(int newHealth, String newType, String newWeapon) {
		health = newHealth;
		type = newType;
		weapon = newWeapon;
	}
	
	public void setHealth(int newHealth){
		this.health = newHealth;
	}
	
	public int getHealth(){
		return health;
	}
	
	public void setType(String newType){
		this.type = newType;
		
		switch(newType){//sets the weapon and damage based on type
			case "Bandit":
				weapon = "Wooden Sword";
				health = 15;
				break;
			case "Big Dog":
				weapon = "Teeth";
				health = 25;
				break;
			case "Ogre":
				weapon = "Axe";
				health = 35;
				break;
		}
	}
	
	public String getType(){
		return type;
	}
	
	public void setWeapon(String newWeapon){
		this.weapon = newWeapon;
	}
	
	public String getWeapon(){
		return weapon;
	}
	
	private int generateRandom(int r){//generate random number for damage
		Random rand = new Random();
		int num = 0;
		while(num == 0){
			num = rand.nextInt(r+1);
		}
		return num;
	}
	
	public int getWeaponDamage(){//sets weapon damage based on current weapon
		int weapond = 0;
		switch(this.weapon){
			case "Wooden Sword":
				weapond = generateRandom(5);
				break;
			case "Teeth":
				weapond = generateRandom(10);
				break;
			case "Axe":
				weapond = generateRandom(15);
				break;
		}
		return weapond;
	}
}