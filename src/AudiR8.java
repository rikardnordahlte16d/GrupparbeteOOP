import javafx.scene.paint.Color;

public class AudiR8 extends Car {
	public AudiR8() {
		super(Color.RED, 5, "Audi R8");
		stopEngine();
	}		

	public double speedFactor() {
		return getEnginePower() * 500000;
	}
}
