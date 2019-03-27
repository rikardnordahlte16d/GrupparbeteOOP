package model;

import javafx.scene.paint.Color;

public class Ferry extends Vehicle {

	CarLoader carLoader;
	Flatbed flatbed;
	public Ferry(Color color, double enginePower, String modelName) {
		super(color, enginePower, modelName);
		flatbed = new Flatbed();
		carLoader = new CarLoader(10, flatbed); //�ndra senare till variabel ist�llet f�r 10
		carLoader.firstOut = true;
	}

	

}
