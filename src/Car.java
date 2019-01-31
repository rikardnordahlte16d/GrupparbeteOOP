import javafx.scene.paint.Color;

public abstract class Car implements Moveable {

	public double enginePower; // Engine power of the car
	public double currentSpeed; // The current speed of the car
	public Color color; // Color of the car
	public String modelName; // The car model name
	private float x,y;
	/**
	 * Returnerar bilens motor kraft
	 * @return
	 */
	public double getEnginePower() {
		return enginePower;
	}
	/**
	 * Returnerar bilens fart 
	 * @return
	 */
	public double getCurrentSpeed() {
		return currentSpeed;
	}
	/**
	 * Returnerar bilens färg
	 * @return
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * Startar upp bilens motor 
	 */
	public void startEngine() {
		currentSpeed = 0.1;
	}
	/**
	 * Motor på bilen stoppar
	 */
	public void stopEngine() {
		currentSpeed = 0;
	}
	/**
	 * Returnerar formeln på bilens fart
	 * @return
	 */
	public double speedFactor() {
		return 0;
	}
	
	/**
	 * ökning av farten, i form av en variable av Currentspeed och speedfactor gånger amount
	 * @param amount
	 */
	
	public void incrementSpeed(double amount) {
		currentSpeed = getCurrentSpeed() + speedFactor() * amount;
		
	}
	
	
	/**
	 * minskning av farten, i form av en variable av Currentspeed och speedfactor gånger amount
	 * @param amount
	 */

	public void decrementSpeed(double amount) {
		currentSpeed = getCurrentSpeed() - speedFactor() * amount;
	}

	
	/**
	 * gasa bilen med amount förändring beroende på ökad fart.	
	 * @param amount
	 */
	
	public void gas(double amount) {
		incrementSpeed(amount);
	}

	/**
	 * 
	 * @param 
	 */
	
	public void brake(double amount) {
		decrementSpeed(amount);
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	public void move() {
		
	}
	
	public void turnLeft() {
		x-=currentSpeed;
	}
	
	public void turnRight() {
		x+=currentSpeed;
	}
}