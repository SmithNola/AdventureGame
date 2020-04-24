import java.util.Random;

public class Character {
	private int health;
	private String type;
	private Weapon weapon;
	
	public Character(String newType) {
		setType(newType);
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
			case "Player":
				weapon = new Weapon("Bronze Sword");
				health = 50;
				break;
			case "Bandit":
				weapon = new Weapon("Wooden Sword");
				health = 15;
				break;
			case "Big Dog":
				weapon = new Weapon("Teeth");
				health = 25;
				break;
			case "Ogre":
				weapon = new Weapon("Axe");
				health = 35;
				break;
		}
	}
	
	public String getType(){
		return type;
	}
	
	public void setWeapon(String newWeapon){
		weapon.setDamage(newWeapon);
		this.weapon = new Weapon(newWeapon);
	}
	
	public String getWeaponName(){
		return weapon.getName();
	}
	
	public int getWeaponDamage(){//sets weapon damage based on current weapon
		int weaponDamage = 0;
		if(type.equals("Player")){
			weaponDamage = weapon.getDamage();
		}else{
			Random rand = new Random();
			while(weaponDamage == 0){
				weaponDamage = rand.nextInt(weapon.getDamage()+1);
			}
		}
		return weaponDamage;
	}
}
