package model;
import javafx.scene.paint.Color;

public class Scania extends Vehicle {

	protected Flatbed flatbed;
	protected CarLoader carLoader;
	
	public Scania(Color color, double enginePower, String name, int carAmount) {
		super(color, enginePower, name);
		flatbed = new Flatbed();
		carLoader = new CarLoader(carAmount, flatbed);
	}
	public CarLoader getCarLoader() {
		return carLoader;
	}
}