import javafx.scene.paint.Color;

public class Saab95 extends Car implements Moveable {

	public boolean turboOn; //Om turbo är på eller ej

	public Saab95() {
		super(Color.BLACK, 125, "Saab95");
		turboOn = false;
		stopEngine();
	}		

	/**
	 * 
	 * Stänger av turbon
	 * 
	 */
	public void setTurboOn() {
		turboOn = true;
	}

	/**
	 * Aktiverar Turbo
	 * 
	 */
	
	public void setTurboOff() {
		turboOn = false;
		
	}

	/**
	 * Ökar farten med 30 % på bilen när turboon är. Returnerar bilens snabbhet formel, 
	 */
	public double speedFactor() {
		double turbo = 1;
		if (turboOn)
			turbo = 1.3;
		return getEnginePower() * 0.01 * turbo;
	}
}

