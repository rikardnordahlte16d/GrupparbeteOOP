import javafx.scene.paint.Color;

public class Volvo740 extends Car implements Moveable{

	public final static double trimFactor = 1.25;

	/**
	 * En class som har variable för en biltyp som har färg, vad för hästkraft,
	 * har en modelnamn och har en metod som stoppa motor.  
	 */
	public Volvo740() {
		color = Color.RED;
		enginePower = 100;
		modelName = "Volvo740";
		stopEngine();
	}
	
}