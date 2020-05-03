public class Weapon {
	private String name;
	private int damage;
	private int value;
	
	public Weapon(String newName){
		name = newName;
		setDamage(newName);
		setValue(newName);
	}
	
	public String getName(){
		return name;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setValue(String name){
		switch (name){
			case "Bronze Sword":
				value = 10;
				break;
			case "Wooden Sword":
				value = 5;
				break;
			case "Silver Sword":
				value = 15;
				break;
			case "Diamond Sword":
				value = 17;
				break;
		}
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
			case "Diamond Sword":
				damage = 25;
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
