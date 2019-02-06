import javafx.scene.paint.Color;

public class TeslaModelX extends Car {

	public TeslaModelX() {
		super(Color.WHITE, 1000, "Tesla Model X");
		stopEngine();
	}		

	public double speedFactor() {
		return getEnginePower() * 500 * 500;
	}
}
