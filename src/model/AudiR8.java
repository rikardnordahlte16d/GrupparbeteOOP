package model;
import javafx.scene.paint.Color;

public class AudiR8 extends Vehicle {
	public AudiR8() {
		super(Color.RED, 5, "Audi R8");
		stopEngine();
	}		

	/**
	 * 
	 *	Bilens snabbhet, j�vligt snabb kan man s�ga. 
	 */
	public double speedFactor() {
		return getEnginePower() * 500000;
	}
}
