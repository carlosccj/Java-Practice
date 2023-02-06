package prHumans;

public class Human {
	private int health_points;
	private int carry_capacity;
	private double action_points;
	private double accuracy;
	private double knockback_chance;

	public Human() {
		this(100, 100, 100, 50, 25);
	}
	
	public Human(int hp, int cc, double ap, double acc, double kc) {
		health_points = hp;
		carry_capacity = cc;
		action_points = ap;
		accuracy = acc;
		knockback_chance = kc;
	}
}
