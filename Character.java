import java.util.Random;

public class Character {
	private int health;
	private String type;
	private Weapon weapon;
	private int coins;
	
	public Character(String newType) {
		coins = 5;
		setType(newType);
	}
	
	public void setCoins(int coins){
		this.coins = coins;
	}
	
	public int getCoins(){
		return coins;
	}
	
	public void setHealth(int newHealth){
		this.health = newHealth;
	}
	
	public int getHealth(){
		return health;
	}
	
	public int getWeaponValue(){
		return weapon.getValue();
	}
	
	public void setType(String newType){
		this.type = newType;

		//sets the weapon and damage based on type
		switch (newType) {
			case "Player" -> {
				weapon = new Weapon("Bronze Sword");
				health = 50;
			}
			case "Bandit" -> {
				weapon = new Weapon("Wooden Sword");
				health = 15;
			}
			case "Big Dog" -> {
				weapon = new Weapon("Teeth");
				health = 25;
			}
			case "Ogre" -> {
				weapon = new Weapon("Axe");
				health = 35;
			}
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
