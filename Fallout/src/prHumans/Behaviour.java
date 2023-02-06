package prHumans;

public interface Behaviour {
	
	public void attack(Human x);
	
	public void talk(Human x);
	
	public void trade(Hero h);
	
	//public void sleep(FurnitureBed x);
	//public void sit(FurnitureChair x);
	public void walk();
	public void run();

}
