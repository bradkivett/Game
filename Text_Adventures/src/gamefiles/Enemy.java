package gamefiles;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Nathan & Brad
 */
public class Enemy {
	public String name;
	private int health;
	private int maxHealth;
	private int damage = 1;
	private Random rand = new Random();

	private ArrayList<String> resistanceTypes = new ArrayList<String>();
	private ArrayList<String> characterTypes = new ArrayList<String>();
	
	public Enemy() {
		
	}
	public Enemy(String n, int h, int d, String type1, String type2, String char1, String char2) {
		this.resistanceTypes.add(type1);
		this.resistanceTypes.add(type2);
		this.characterTypes.add(char1);
		this.characterTypes.add(char2);
		this.health = h;
		this.maxHealth = h;
		this.name = n;
		this.damage = d;
	}
	
	
	public void setHealth(int health) {
		if (health > this.maxHealth) {
		this.health = this.maxHealth;
		} else {
		this.health = health;
		}
	}
	
	public int getHealth() {
		return health;
	}
	
	
	
	public ArrayList<String> getResistance() {
		return this.resistanceTypes;
	}
	
	public ArrayList<String> getCharacteristic(){
		return this.characterTypes;
	}
	
	public boolean resistanceCheck(ArrayList<String> r, ArrayList<String> c) {
		for (int i = 0; i < r.size(); i++ ) {
			if (c.contains(r.get(i))) {
				return true;
			}
				
		}
		return false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public void Attack(Enemy e){
		int damageDealt = rand.nextInt(this.damage);
		System.out.println(damageDealt);
			if (resistanceCheck(this.getCharacteristic(), e.getResistance())) {
				damageDealt = (int) (damageDealt * .75);
			} 
		e.setHealth(e.getHealth() - damageDealt);
		
		
		// Print results & doesn't allow health to fall below 0
		if (e.getHealth() <= 0) {
			e.setHealth(0);
			System.out.println(this.getName() + " dealt " + damageDealt + " damage to " + e.getName());
			System.out.println(e.getName() + " has " + e.getHealth() + " health left");
			System.out.println("----------------------------------------------------");
			e.slain();
		} else {
			System.out.println(this.getName() + " dealt " + damageDealt + " damage to " + e.getName());
			System.out.println(e.getName() + " has " + e.getHealth() + " health left");
			System.out.println("----------------------------------------------------");
		}
		
			
	}
	
	public void slain() {
		System.out.println("The " + this.name + " was slain!");
	}
	
  
}