package prHumans;

public class Hero {
	private int strength;
	private int perception;
	private int endurance;
	private int charisma;
	private int intelligence;
	private int agility;
	private int luck;

	private int health_points;
	private int carry_capacity;
	private double action_points;
	private double accuracy;
	private double stealth;
	private double pickpocketing;
	private double knockback_chance;

	public Hero(int st, int per, int end, int cha, int intel, int agi, int lck) {
		int sum = st + per + end + cha + intel + agi + lck;
		if (sum != 35) {
			throw new RuntimeException("La asignación de los puntos es incorrecta");
		}
		
		strength = st;
		perception = per;
		endurance = end;
		charisma = cha;
		intelligence = intel;
		agility = agi;
		luck = lck;
		
		health_points = 3 * ((st * 25 + end * 50 + 25) / 10);
		carry_capacity = 150 + st * 10;
		action_points = 100 + agi * 10;
		accuracy = 10 * (per * 0.75 + agi * 0.25 - 0.01);
		stealth = 10 * (agi * 0.75 + 0.20);
		pickpocketing = stealth + 5 * luck;
		knockback_chance = 10 * (0.10 * st + 0.25 * end);
	}
}

