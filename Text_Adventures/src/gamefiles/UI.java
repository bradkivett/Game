package gamefiles;

public class UI {

	public static void main(String[] args) {
		Enemy Dragon = new Enemy("Dragon", 120, 20, "fire", "range", "fire", "melee");
		Enemy Hero = new Enemy("Hero", 100, 18, "range", "melee", "melee", "");
		
		while (Dragon.getHealth() > 0 && Hero.getHealth() > 0) {
			if (Dragon.getHealth() > 0) {
			Dragon.Attack(Hero);
			}
			if (Hero.getHealth() > 0) {
			Hero.Attack(Dragon);
			}
		}
	}

}
