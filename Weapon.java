
public class Weapon {
	private String name;
	private int damage;
	
	public Weapon(String newName){
		name = newName;
		setDamage(newName);
	}
	
	public String getName(){
		return name;
	}
	
	public void setDamage(String name){
		switch(name){
			case "Bronze Sword":
				damage = 10;
				break;
			case "Wooden Sword":
				damage = 5;
				break;
			case "Silver Sword":
				damage = 20;
				break;
			case "Teeth":
				damage = 10;
				break;
			case "Axe":
				damage = 15;
				break;
		}	
	}
	
	public int getDamage(){
		return damage;
	}
}
