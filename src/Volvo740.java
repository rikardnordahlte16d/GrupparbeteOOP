import javafx.scene.paint.Color;

public class Volvo740 extends Car implements Moveable{

	public final static double trimFactor = 1.25;

	/**
	 * En class som har variable f�r en biltyp som har f�rg, vad f�r h�stkraft,
	 * har en modelnamn och har en metod som stoppa motor.  
	 */
	public Volvo740() {
		color = Color.RED;
		enginePower = 100;
		modelName = "Volvo740";
		stopEngine();
	}
	
}