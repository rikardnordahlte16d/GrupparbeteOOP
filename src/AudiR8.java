import javafx.scene.paint.Color;

public class AudiR8 extends Car {
	public AudiR8() {
		color = Color.RED;
		enginePower = 5;
		modelName = "Audi R8";
		stopEngine();
	}		

	public double speedFactor() {
		return enginePower * 500000;
	}
}
