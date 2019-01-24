import javafx.scene.paint.Color;

public class Volvo740 extends Car {

	public final static double trimFactor = 1.25;

	public Volvo740() {
		color = Color.RED;
		enginePower = 100;
		modelName = "Volvo740";
		stopEngine();
	}
	public double speedFactor() {
		return enginePower * 0.01 * trimFactor;
	}
}