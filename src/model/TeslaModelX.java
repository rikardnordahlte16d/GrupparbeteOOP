package model;
import javafx.scene.paint.Color;

public class TeslaModelX extends Vehicle {

	public TeslaModelX() {
		super(Color.WHITE, 1000, "Tesla Model X");
		stopEngine();
	}		
	/**
	 * Returnerar bilens snabbhet
	 */
	public double speedFactor() {
		return getEnginePower() * 500 * 500;
	}
}
