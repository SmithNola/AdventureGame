
public class Weapon {
	private String name;
	private int damage = 0;
	
	public Weapon(String newName){
		name = newName;
		setDamage(newName);
	}
	
	public String getName(){
		return name;
	}
	
	private void setDamage(String name){
		switch(name){
			case "Wooden Sword":
				damage = 5;
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
