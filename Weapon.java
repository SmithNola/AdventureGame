public class Weapon {
	private final String name;
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
		switch (name) {
			case "Bronze Sword" -> value = 10;
			case "Wooden Sword" -> value = 5;
			case "Silver Sword" -> value = 15;
			case "Diamond Sword" -> value = 17;
		}
	}
	
	public void setDamage(String name){
		switch (name) {
			case "Bronze Sword" -> damage = 10;
			case "Wooden Sword" -> damage = 5;
			case "Silver Sword" -> damage = 20;
			case "Diamond Sword" -> damage = 25;
			case "Teeth" -> damage = 12;
			case "Axe" -> damage = 15;
		}
	}
	
	public int getDamage(){
		return damage;
	}
}
