import javafx.scene.paint.Color;

public class TeslaModelX extends Car {

	public TeslaModelX() {
		color = Color.WHITE;
		enginePower = 10000;
		modelName = "Tesla Model X";
		stopEngine();
	}		

	public double speedFactor() {
		return enginePower * 500 * 500;
	}
}
